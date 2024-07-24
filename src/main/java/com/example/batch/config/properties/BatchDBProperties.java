package com.example.batch.config.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

@Getter
@AllArgsConstructor
@ConfigurationProperties(prefix = "spring.datasource")
public class BatchDBProperties {
    private String driverClassName;

    private String url;

    private String username;

    private String password;
}
