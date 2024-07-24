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
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

    private static final Integer CHUNK_SIZE = 5;

    @Bean
    public Step step(RestaurantItemReader itemReader, RestaurantItemProcessor itemProcessor, RestaurantItemWriter itemWriter) {
        return new StepBuilder("step1", jobRepository)
                .<RestaurantDto, Restaurant>chunk(CHUNK_SIZE, restaurantTransactionManager)
                .reader(itemReader.reader())
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();
    }

    @Bean
    public Job importRestaurantJob() {
        return new JobBuilder("importRestaurantJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .start(step(null, null, null))
                .build();
    }

}