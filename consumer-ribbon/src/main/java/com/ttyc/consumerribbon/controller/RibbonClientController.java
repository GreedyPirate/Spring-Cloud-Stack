package com.ttyc.consumerribbon.controller;

import com.netflix.discovery.DiscoveryClient;
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
