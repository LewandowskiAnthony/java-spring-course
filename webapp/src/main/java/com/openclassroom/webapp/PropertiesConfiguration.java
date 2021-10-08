package com.openclassroom.webapp;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "com.openclassroom.webapp")
public class PropertiesConfiguration{

    private String apiUrl;
}
