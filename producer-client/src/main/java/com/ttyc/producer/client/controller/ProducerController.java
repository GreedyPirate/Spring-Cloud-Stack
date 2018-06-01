package com.ttyc.producer.client.controller;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Transaction;
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
    public String clientInfo() {
        Transaction transaction = Cat.newTransaction("URL", "producer");
        try {
            System.out.println("be consumed");
            transaction.setStatus("0");
            return discoveryClient.getServices().toString();
        } catch (Exception e) {
            transaction.setStatus(e);
            e.printStackTrace();
        } finally {
            transaction.complete();
        }
        return "";
    }

    @PostMapping(value = "producer/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Boolean upload(@RequestPart(value = "file") MultipartFile file) {
        logger.debug(file.getOriginalFilename());
        System.out.println(file.getName());
        return Boolean.TRUE;
    }
}
