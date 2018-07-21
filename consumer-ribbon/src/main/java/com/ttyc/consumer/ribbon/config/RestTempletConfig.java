package com.ttyc.consumer.ribbon.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTempletConfig {
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory){
        return new RestTemplate(httpComponentsClientHttpRequestFactory);
    }
}
