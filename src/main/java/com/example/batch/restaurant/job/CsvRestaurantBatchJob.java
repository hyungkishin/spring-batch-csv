package com.example.batch.restaurant.job;

import com.example.batch.listener.JobCompletionNotificationListener;
import com.example.batch.restaurant.dto.RestaurantDto;
import com.example.batch.restaurant.entity.Restaurant;
import com.example.batch.restaurant.step.RestaurantItemProcessor;
import com.example.batch.restaurant.step.RestaurantItemReader;
import com.example.batch.restaurant.step.RestaurantItemWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.partition.support.MultiResourcePartitioner;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@RequiredArgsConstructor
@EnableTransactionManagement
@EnableBatchProcessing
public class CsvRestaurantBatchJob {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager restaurantTransactionManager;
    private final JobCompletionNotificationListener listener;

    private static final Integer CHUNK_SIZE = 10000;

    @Value("classpath:fulldata.csv")
    private Resource[] inputResources;

    @Bean
    public Step masterStep(RestaurantItemReader itemReader, RestaurantItemProcessor itemProcessor, RestaurantItemWriter itemWriter) {
        return new StepBuilder("masterStep", jobRepository)
                .partitioner("slaveStep", partitioner())
                .step(slaveStep(itemReader, itemProcessor, itemWriter))
                .taskExecutor(taskExecutor())
                .build();
    }

    @Bean
    public Step slaveStep(RestaurantItemReader itemReader, RestaurantItemProcessor itemProcessor, RestaurantItemWriter itemWriter) {
        return new StepBuilder("slaveStep", jobRepository)
                .<RestaurantDto, Restaurant>chunk(CHUNK_SIZE, restaurantTransactionManager)
                .reader(itemReader.reader())
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();
    }

    @Bean
    public Job importRestaurantJob(RestaurantItemReader itemReader, RestaurantItemProcessor itemProcessor, RestaurantItemWriter itemWriter) {
        return new JobBuilder("importRestaurantJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .start(masterStep(itemReader, itemProcessor, itemWriter))
                .build();
    }

    @Bean
    public MultiResourcePartitioner partitioner() {
        MultiResourcePartitioner partitioner = new MultiResourcePartitioner();
        partitioner.partition(10); // 파티션 수를 늘려 병렬 처리
        partitioner.setResources(inputResources);
        return partitioner;
    }

    @Bean
    public TaskExecutor taskExecutor() {
        SimpleAsyncTaskExecutor taskExecutor = new SimpleAsyncTaskExecutor();
        taskExecutor.setConcurrencyLimit(25); // 병렬 처리 스레드 수 설정
        return taskExecutor;
    }
}
