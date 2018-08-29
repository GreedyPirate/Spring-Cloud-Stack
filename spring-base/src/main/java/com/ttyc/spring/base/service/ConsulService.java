package com.ttyc.spring.base.service;

import org.springframework.stereotype.Service;

@Service
public class ConsulService implements RegistryService{
    @Override
    public void registry() {
        System.out.println("consul");
    }
}
