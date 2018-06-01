package com.ttyc.sleuth.feign.consumer.controller;

import com.ttyc.sleuth.feign.consumer.Service.ThirdCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    ThirdCallService thirdCallService;

    @GetMapping("feign/hi")
    public String hi(){
        return this.thirdCallService.getInfo();
    }
}
