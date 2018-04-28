package com.ttyc.producer.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.TimeUnit;

@RestController
public class ProducerController {
    private Logger logger = LoggerFactory.getLogger(ProducerController.class);

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/producer/hi")
    public String clientInfo(){
        System.out.println("be consumed");
        /*try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return discoveryClient.getServices().toString();
    }

    @PostMapping(value = "producer/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Boolean upload(@RequestPart(value = "file")MultipartFile file){
        logger.debug(file.getOriginalFilename());
        System.out.println(file.getName());
        return Boolean.TRUE;
    }
}
