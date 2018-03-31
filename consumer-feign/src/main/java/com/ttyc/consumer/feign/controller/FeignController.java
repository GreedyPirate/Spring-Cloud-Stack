package com.ttyc.consumer.feign.controller;

import com.ttyc.consumer.feign.service.ProducerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {
    @Autowired
    ProducerClient producerClient;

    @GetMapping("feign")
    public String sayHi(){
        return this.producerClient.callProducer();
    }
}
