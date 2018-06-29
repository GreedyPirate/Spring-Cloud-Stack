package com.ttyc.producer.client.controller;

import com.ttyc.mq.common.exception.BaseError;
import com.ttyc.mq.common.exception.ServiceException;
import com.ttyc.producer.client.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
public class ProducerController {
    private Logger logger = LoggerFactory.getLogger(ProducerController.class);

    @Autowired
    DiscoveryClient discoveryClient;

    @PostMapping(value = "status")
    public String health(){
        return "OK";
    }

    @PostMapping(value = "producer/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Boolean upload(@RequestPart(value = "file") MultipartFile file) {
        logger.debug(file.getOriginalFilename());
        System.out.println(file.getName());
        return Boolean.TRUE;
    }

    @PostMapping(value = "user")
    public String vaild(@Valid User user){
        throw new ServiceException(BaseError.INTERNAL_SERVER_ERROR);
    }
}
