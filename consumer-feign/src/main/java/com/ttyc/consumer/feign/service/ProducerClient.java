package com.ttyc.consumer.feign.service;


import com.ttyc.consumer.feign.config.MultiPartConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "eureka-producer", configuration = {MultiPartConfig.class})
public interface ProducerClient {
    @GetMapping("producer/hi")
    public String callProducer();

    @PostMapping(value = "producer/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Boolean upload(MultipartFile file);
}
