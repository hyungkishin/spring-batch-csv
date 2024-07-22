package com.example.batch;

import com.example.batch.listener.JobCompletionNotificationListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Date;


@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public DataSource dataSource;

    @Autowired
    public JobRepository jobRepository;

    @Autowired
    public PlatformTransactionManager transactionManager;

    @Autowired
    public JobCompletionNotificationListener listener;

    @Bean
    public FlatFileItemReader<Person> reader() {
        return new FlatFileItemReaderBuilder<Person>()
                .name("personItemReader")
                .resource(new ClassPathResource("test.csv"))
                .delimited()
                .names("이름", "휴대폰")
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                    setTargetType(Person.class);
                }})
                .linesToSkip(1)
                .build();
    }

    @Bean
    public JdbcBatchItemWriter<Person> writer() {
        return new JdbcBatchItemWriterBuilder<Person>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO person (name, phone) VALUES (:name, :phone)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public Job importPersonJob() {
        return new JobBuilder("importPersonJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .start(step1())
                .build();
    }

    @Bean
    public Step step1() {
        return new StepBuilder("step1", jobRepository)
                .<Person, Person>chunk(10, transactionManager)
                .reader(reader())
                .writer(writer())
                .build();
    }

//    @Autowired
//    private JobRepository jobRepository;
//
//    @Autowired
//    private PlatformTransactionManager transactionManager;
//
//    @Bean
//    public Step step1(PersonItemReader itemReader, PersonItemProcessor itemProcessor, PersonItemWriter itemWriter) {
//        return new StepBuilder("step1", jobRepository)
//                .<PersonDTO, Person>chunk(5, transactionManager)
//                .reader(itemReader.reader())
//                .processor(itemProcessor)
//                .writer(itemWriter.writer())
//                .build();
//    }
}
