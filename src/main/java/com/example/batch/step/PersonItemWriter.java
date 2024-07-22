//package com.example.batch.step;
//
//import com.example.batch.Person;
//import jakarta.persistence.EntityManagerFactory;
//import lombok.RequiredArgsConstructor;
//import org.springframework.batch.item.database.JpaItemWriter;
//import org.springframework.batch.item.database.builder.JpaItemWriterBuilder;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@RequiredArgsConstructor
//@Configuration
//public class PersonItemWriter {
//
//    @Qualifier("entityManagerFactory")
//    private final EntityManagerFactory entityManagerFactory;
//
//    @Bean
//    public JpaItemWriter<Person> writer() {
//        return new JpaItemWriterBuilder<Person>()
//                .entityManagerFactory(entityManagerFactory)
//                .build();
//    }
//}