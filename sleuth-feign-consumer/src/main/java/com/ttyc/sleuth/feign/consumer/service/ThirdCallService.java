package com.ttyc.sleuth.feign.consumer.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value="sleuth-feign-producer")
public interface ThirdCallService {
    @GetMapping("/trace")
    public String getInfo();
}
