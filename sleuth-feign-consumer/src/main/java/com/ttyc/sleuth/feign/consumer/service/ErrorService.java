package com.ttyc.sleuth.feign.consumer.service;

import org.springframework.stereotype.Service;

@Service
public class ErrorService {

    public void error(){
        String msg = null;
        try {
            String substring = msg.substring(0);
            System.out.println(substring);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
