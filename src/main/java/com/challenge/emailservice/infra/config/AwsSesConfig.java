package com.challenge.emailservice.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;

@Configuration
public class AwsSesConfig {
    
    @Bean
    public AmazonSimpleEmailService amazonSimpleEmailService() {
        return AmazonSimpleEmailServiceClientBuilder
            .standard()
            .withCredentials(new MyAWSCredentialsProvider("YOUR_AWS_ACCESS_KEY_ID", "YOUR_AWS_SECRET_ACCESS_KEY"))
            .withRegion("sa-east-1")
            .build();
    }
}
