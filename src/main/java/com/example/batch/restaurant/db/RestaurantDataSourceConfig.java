package com.example.batch.restaurant.db;

import com.example.batch.restaurant.db.properties.RestaurantDBProperties;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(RestaurantDBProperties.class)
public class RestaurantDataSourceConfig {

    @Bean(name = "restaurantDataSource")
    public DataSource restaurantDataSource(RestaurantDBProperties properties) {
        return DataSourceBuilder.create()
                .driverClassName(properties.getDriverClassName())
                .url(properties.getUrl())
                .username(properties.getUsername())
                .password(properties.getPassword())
                .build();
    }

    @Bean(name = "restaurantTransactionManager")
    public PlatformTransactionManager restaurantTransactionManager(
            @Qualifier("restaurantDataSource") DataSource restaurantDataSource) {
        return new DataSourceTransactionManager(restaurantDataSource);
    }

}