package com.ttyc.consul.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "producer-service", decode404 = true)
public interface ConsulProducerService {
    @GetMapping("cp")
    String ping();
}