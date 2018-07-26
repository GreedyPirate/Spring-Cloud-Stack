package com.ttyc.sleuth.feign.producer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {


    @GetMapping("trace")
    public String trace(){
        return "trace";
    }
}
