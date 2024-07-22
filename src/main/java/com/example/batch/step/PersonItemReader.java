package com.example.batch.step;

import com.example.batch.domain.dto.PersonDTO;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class PersonItemReader {

    @Bean
    public FlatFileItemReader<PersonDTO> reader() {
        return new FlatFileItemReaderBuilder<PersonDTO>()
                .name("personItemReader")
                .resource(new ClassPathResource("test.csv"))
                .linesToSkip(1)
                .delimited()
                .names("name", "phone")
                .targetType(PersonDTO.class)
                .build();
    }
}