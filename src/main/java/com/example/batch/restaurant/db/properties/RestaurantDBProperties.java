package com.example.batch.restaurant.db.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@AllArgsConstructor
@ConfigurationProperties(prefix = "restaurant.datasource")
public class RestaurantDBProperties {

    private String driverClassName;

    private String url;

    private String username;

    private String password;

}
