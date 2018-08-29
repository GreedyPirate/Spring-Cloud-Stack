package com.ttyc.spring.base.service;

import org.springframework.stereotype.Service;

@Service
public class EurekaService implements RegistryService{
    @Override
    public void registry() {
        System.out.println("eureka");
    }
}
