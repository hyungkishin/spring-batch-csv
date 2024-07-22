//package com.example.batch.step;
//
//import com.example.batch.PersonDTO;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//
//@Configuration
//public class PersonItemReader {
//
//    @Bean
//    public FlatFileItemReader<PersonDTO> reader() {
//        return new FlatFileItemReaderBuilder<PersonDTO>()
//                .name("personItemReader")
//                .resource(new ClassPathResource("test.csv"))
//                .delimited()
//                .names("이름", "휴대폰")
//                .targetType(PersonDTO.class)
//                .build();
//    }
//}