package com.ttyc.consumer.hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ttyc.consumer.hystrix.feign.ProducerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HystrixService {

    @Autowired
    ProducerFeignClient producerFeignClient;

    @HystrixCommand(fallbackMethod = "failMethod")
    public String callProducer(){
        return this.producerFeignClient.callProducer();
    }

    public String failMethod(){
        return "exception";
    }
}
