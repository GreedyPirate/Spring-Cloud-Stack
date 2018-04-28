package com.ttyc.config.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ClientConfigController {
    @Autowired
    Environment environment;

    @Value("${info.profile}")
    String name;

    @GetMapping("config")
    public String getMode(){
        System.out.println(environment.getProperty("info.profile"));
        return this.environment.getProperty("info.profile");
    }

}
