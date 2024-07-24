package com.example.batch.restaurant.step;

import com.example.batch.restaurant.dto.RestaurantDto;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class RestaurantItemReader {

    @Bean
    @StepScope
    public FlatFileItemReader<RestaurantDto> reader() {

        return new FlatFileItemReaderBuilder<RestaurantDto>()
                .name("personItemReader")
                .resource(new ClassPathResource("restaurants.csv"))
                .strict(true) // strict 모드 설정
                .linesToSkip(1)
                .delimited()
                .names(new String[]{"id", "serviceName", "serviceId", "localCode", "managementNumber", "permitDate", "cancelPermitDate", "businessStatusCode", "businessStatusName", "detailedBusinessStatusCode", "detailedBusinessStatusName", "closeDate", "suspendStartDate", "suspendEndDate", "reopenDate", "phone", "area", "postalCode", "fullAddress", "roadAddress", "roadPostalCode", "businessName", "lastModified", "dataUpdateType", "dataUpdateDate", "businessTypeName", "coordinateX", "coordinateY", "hygieneBusinessTypeName", "maleEmployeeCount", "femaleEmployeeCount", "businessAreaTypeName", "gradeTypeName", "waterSupplyTypeName", "totalEmployeeCount", "headOfficeEmployeeCount", "factoryOfficeEmployeeCount", "factorySalesEmployeeCount", "factoryProductionEmployeeCount", "buildingOwnershipTypeName", "guaranteeAmount", "monthlyRentAmount", "multiUseFacilityYn", "totalFacilitySize", "traditionalBusinessNumber", "traditionalBusinessMainFood", "homepage"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<RestaurantDto>() {{
                    setTargetType(RestaurantDto.class);
                }})
                .targetType(RestaurantDto.class)
                .build();
    }
}