package com.ttyc.consumer.ribbon.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Api("消费者Ribbon测试")
@RestController
public class RibbonClientController {

    @Autowired
    RestTemplate restTemplate;

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

}
