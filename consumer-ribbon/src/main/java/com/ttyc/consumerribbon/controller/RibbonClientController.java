package com.ttyc.consumerribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonClientController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("ribbon")
    public String callProducer(){
        String result = restTemplate.getForObject("http://eureka-producer/producer/hi", String.class);
        System.out.println(result);
        return result;
    }
}
        // java.lang.IllegalStateException: No instances available for eureka-server
