package com.ttyc.consul.consumer.controller;

import com.ttyc.consul.consumer.service.ConsulProducerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@AllArgsConstructor
public class ConsulConsumerController {

    ConsulProducerService consulProducerService;

    LoadBalancerClient loadBalancerClient;

    RestTemplate restTemplate;

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    PhpClient phpClient;

    @Autowired
    MirrorClient mirrorClient;

    @GetMapping("test/consul")
    public String ping(){
        return consulProducerService.ping();
    }

    @GetMapping("all-services")
    public String getAll(){
        discoveryClient.getServices().forEach(item->{
            System.out.println(item);
        });
        return "SUCCESS";
    }

    @GetMapping("loadbalancer")
    public String test(){
        ServiceInstance instance = loadBalancerClient.choose("producer-service");
        String host = instance.getHost();
        if(host.equals("10.9.117.128")){
            System.out.println(instance);
        }
        int port = instance.getPort();
        String url = "http://producer-service/cp";
        return this.restTemplate.getForObject(url,String.class);
    }

    @GetMapping("ip")
    public String callProducer(String id){
        ServiceInstance serviceInstance = loadBalancerClient.choose(id);
        return serviceInstance.getHost()+":"+serviceInstance.getPort();
    }

    @GetMapping("php")
    public String php(){
        return this.phpClient.getHealth();
    }

    @GetMapping("mirror")
    public String mirror(){
        return this.mirrorClient.getHealth();
    }

    @FeignClient("demoPhp")
    public interface PhpClient{
        @RequestMapping("/")
        String getHealth();
    }

    @FeignClient("aicar-mirror")
    @RequestMapping("/aicar-mirror")
    public interface MirrorClient{
        @RequestMapping("/actuator/health")
        String getHealth();
    }
}
