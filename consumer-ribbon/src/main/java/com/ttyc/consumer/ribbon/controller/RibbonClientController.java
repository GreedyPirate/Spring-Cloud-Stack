package com.ttyc.consumer.ribbon.controller;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Api("消费者Ribbon测试")
@RestController
public class RibbonClientController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    SpringClientFactory factory;

    @ApiOperation("ribbon测试接口")
    @GetMapping("ribbon")
    public String callProducer(){
        String result = restTemplate.getForObject("http://eureka-producer/producer/hi", String.class);
        System.out.println(result);
        return result;
    }

    @ApiOperation("存活判断")
    @GetMapping("alive")
    public String keepAlive(){
        return "OK";
    }

    @GetMapping("ribbon/cache")
    public String ribbonCache() {
        ILoadBalancer loadBalancer = factory.getLoadBalancer("eureka-producer");
        List<Server> allServers = loadBalancer.getAllServers();
        List<Server> reachableServers = loadBalancer.getReachableServers();

        System.out.println("所有服务：");
        allServers.forEach(t -> {
            String host = t.getHost();
            int port = t.getPort();
            System.out.println(host + ":" + port);
        });

        System.out.println("所有可用服务：");
        reachableServers.forEach(t -> {
            String host = t.getHost();
            int port = t.getPort();
            System.out.println(host + ":" + port);
        });

        System.out.println("eureka client中的生产者列表");
        List<ServiceInstance> instances = discoveryClient.getInstances("eureka-producer");
        instances.forEach(t -> {
            String host = t.getHost();
            int port = t.getPort();
            System.out.println(host + ":" + port);
        });
        return restTemplate.getForObject("http://eureka-producer/ribbon/test", String.class);
    }
}
