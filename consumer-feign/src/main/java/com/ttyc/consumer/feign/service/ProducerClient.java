package com.ttyc.consumer.feign.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("eureka-producer")
public interface ProducerClient {
    @GetMapping("producer/hi")
    public String callProducer();
}
