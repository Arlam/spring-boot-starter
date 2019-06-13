package com.aa.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ServiceConfiguration {

    @Autowired
    @Qualifier(value = "correlationIdPropagationInterceptor")
    private ClientHttpRequestInterceptor correlationIdPropagationInterceptor;

    @Bean
    public RestTemplate secondServiceRestTemplate(){
        return new RestTemplateBuilder()
                .additionalInterceptors(correlationIdPropagationInterceptor)
                .build();

    }
}
