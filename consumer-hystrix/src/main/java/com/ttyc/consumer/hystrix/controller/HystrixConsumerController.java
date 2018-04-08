package com.ttyc.consumer.hystrix.controller;

import com.ttyc.consumer.hystrix.service.HystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixConsumerController {
    @Autowired
    HystrixService hystrixService;

    @GetMapping("hystrix")
    public String hystrix(){
        return this.hystrixService.callProducer();
    }
}
