package com.ttyc.consul.producer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsulProducerController {

    @GetMapping("cp")
    public String test(){
       return "consul producer";
    }
}
