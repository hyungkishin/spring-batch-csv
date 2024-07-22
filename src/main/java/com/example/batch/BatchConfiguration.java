package com.example.batch;

import com.example.batch.domain.Person;
import com.example.batch.domain.dto.PersonDTO;
import com.example.batch.listener.JobCompletionNotificationListener;
import com.example.batch.step.PersonItemProcessor;
import com.example.batch.step.PersonItemReader;
import com.example.batch.step.PersonItemWriter;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.example.batch")
public class BatchConfiguration {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private PlatformTransactionManager transactionManager;


    @Autowired
    private JobCompletionNotificationListener listener;


    @Bean
    public Step step(PersonItemReader itemReader, PersonItemProcessor itemProcessor, PersonItemWriter itemWriter) {
        return new StepBuilder("step1", jobRepository)
                .<PersonDTO, Person>chunk(5, transactionManager)
                .reader(itemReader.reader())
                .processor(itemProcessor)
                .writer(itemWriter.writer())
                .build();
    }

    @Bean
    public Job importPersonJob() {
        return new JobBuilder("importPersonJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .start(step(null, null, null))
                .build();
    }

}
