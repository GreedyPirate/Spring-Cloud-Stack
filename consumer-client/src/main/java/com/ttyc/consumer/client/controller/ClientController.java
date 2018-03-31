package com.ttyc.consumer.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @GetMapping("consumer")
    public String callProducer(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-producer");
        String url = "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/producer/hi";
        Object result = this.restTemplate.getForObject(url,String.class);
        return result.toString();
    }
}
