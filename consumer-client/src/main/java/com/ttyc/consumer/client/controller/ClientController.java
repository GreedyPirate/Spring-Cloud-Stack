package com.ttyc.consumer.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;

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

    @GetMapping("gateway")
    public String gateway(HttpServletResponse response){
        ServiceInstance serviceInstance = loadBalancerClient.choose("spring-cloud-gateway");
        String url = "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/consumer-api/feign";
        Object result = this.restTemplate.getForObject(url,String.class);
        String header = response.getHeader("X-B3-TraceId");
        System.out.println("X-B3-TraceId --> "+header);
        return result.toString();
    }
}
