package com.ttyc.consumer.hystrix.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "eureka-producer")
public interface ProducerFeignClient {
    @GetMapping("producer/hi")
    public String callProducer();
}
