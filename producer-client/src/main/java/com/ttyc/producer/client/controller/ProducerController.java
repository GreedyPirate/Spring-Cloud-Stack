package com.ttyc.producer.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/producer/hi")
    public String clientInfo(){
        return discoveryClient.getServices().toString();
    }
}
