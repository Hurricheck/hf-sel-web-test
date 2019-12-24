package com.hellofresh.challenge.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Slf4j
@Configuration
@PropertySource("classpath:properties/user.properties")
public class UserConfig {
    @Value("${user.email}")
    private String userEmail;

    @Value("${user.password}")
    private String userPassword;

    @Bean
    public String userEmail() {
        return userEmail;
    }

    @Bean
    public String userPassword() {
        return userPassword;
    }
}
