package com.ttyc.consumer.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "sidecar-go", decode404 = true)
public interface SideCarService {

    @RequestMapping(value = "/helloWorld")
    String health();
}
