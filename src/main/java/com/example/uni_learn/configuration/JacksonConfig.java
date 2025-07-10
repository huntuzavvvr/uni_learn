package com.example.uni_learn.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class JacksonConfig {
    @Bean
    public Jackson2ObjectMapperBuilder mapperBuilder() {
        return new Jackson2ObjectMapperBuilder().failOnUnknownProperties(true);
    }
}
