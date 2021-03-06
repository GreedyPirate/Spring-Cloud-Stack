package com.ttyc.producer.client.controller;

import com.ttyc.producer.client.utils.ClassUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Enumeration;

@RestController
public class ProducerController {
    private Logger logger = LoggerFactory.getLogger(ProducerController.class);

    @Autowired
    private Environment env;

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("producer/hi")
    public String hi(HttpServletRequest request, HttpServletResponse response){
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String header = headerNames.nextElement();
            String val = request.getHeader(header);
            System.out.println(header + "==>" + val);
        }
        Collection<String> respHeaders = response.getHeaderNames();
        for (String header:respHeaders){
            System.out.println(response.getHeader(header));
        }
        System.out.println("execute");
        return "hi, consumer";
    }

    @GetMapping(value = "status")
    public String health(){
        return "OK";
    }

    @PostMapping(value = "producer/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Boolean upload(@RequestPart(value = "file") MultipartFile file) {
        logger.debug(file.getOriginalFilename());
        System.out.println(file.getName());
        return Boolean.TRUE;
    }

    @GetMapping("class/location")
    public String getClassLocal(String className){
        return ClassUtils.printLocation(className);
    }

    @GetMapping("ribbon/test")
    public String ribbon() {
        return env.getActiveProfiles()[0];
    }
}
