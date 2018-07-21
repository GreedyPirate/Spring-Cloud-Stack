package com.ttyc.consumer.ribbon.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

@Configuration
public class RetryConfig {
    @Bean
    @ConfigurationProperties(prefix = "eureka-consumer-ribbon")
    public HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory(){
        HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory=new HttpComponentsClientHttpRequestFactory();

        return httpComponentsClientHttpRequestFactory;
    }
}
