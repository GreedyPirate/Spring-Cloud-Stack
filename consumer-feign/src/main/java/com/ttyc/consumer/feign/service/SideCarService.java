package com.ttyc.consumer.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "sidecar-php", decode404 = true)
public interface SideCarService {

    @GetMapping(value = "/side-car")
    String health();
}
