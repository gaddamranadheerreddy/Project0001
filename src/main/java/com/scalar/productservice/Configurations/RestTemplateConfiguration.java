package com.scalar.productservice.Configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
public class RestTemplateConfiguration {

    @Bean
    public RestTemplate restTemplate() {
//        RestTemplate restTemplate = new RestTemplate();
//        // Add ByteArrayHttpMessageConverter to handle application/octet-stream
//        restTemplate.setMessageConverters(Collections.singletonList(new ByteArrayHttpMessageConverter()));
//
//        return new RestTemplate();

//        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
//        messageConverters.add(new ByteArrayHttpMessageConverter());
        // Add other converters if needed

        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.setMessageConverters(messageConverters);
        return restTemplate;
    }
}
