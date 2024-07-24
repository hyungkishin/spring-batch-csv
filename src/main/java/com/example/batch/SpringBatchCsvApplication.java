package com.example.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.Date;

@EnableConfigurationProperties
@SpringBootApplication
public class SpringBatchCsvApplication implements CommandLineRunner {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job importRestaurantJob;

    public static void main(String[] args) {
        SpringApplication.run(SpringBatchCsvApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        jobLauncher.run(importRestaurantJob, new JobParametersBuilder()
                .addLong("startAt", System.currentTimeMillis())
                .toJobParameters());
    }
}