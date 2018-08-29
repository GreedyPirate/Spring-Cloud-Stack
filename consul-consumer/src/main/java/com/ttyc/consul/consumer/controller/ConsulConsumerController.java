package com.ttyc.consul.consumer.controller;

import com.ttyc.consul.consumer.service.ConsulProducerService;
import lombok.AllArgsConstructor;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@AllArgsConstructor
public class ConsulConsumerController {

    ConsulProducerService consulProducerService;

    LoadBalancerClient loadBalancerClient;

    RestTemplate restTemplate;

    DiscoveryClient discoveryClient;

    @GetMapping("test/consul")
    public String ping(){
        return consulProducerService.ping();
    }

    @GetMapping("loadbalancer")
    public String test(){
/*        discoveryClient.getServices().forEach(item->{
            System.out.println(item);
        });
        ServiceInstance instance = loadBalancerClient.choose("consul-producer");
        String host = instance.getHost();
        int port = instance.getPort();*/
        String url = "http://consul-producer/cp";
        return this.restTemplate.getForObject(url,String.class);
    }
}
