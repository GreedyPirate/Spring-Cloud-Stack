package com.ttyc.spring.base.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class NotifyService {
    @Async
    public void sendMail(String message){
        System.out.println(message);
    }
}
