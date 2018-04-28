package com.ttyc.consumer.feign.controller;

import com.ttyc.consumer.feign.service.ProducerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FeignController {
    @Autowired
    ProducerClient producerClient;

    @GetMapping("feign")
    public String sayHi(){
        return this.producerClient.callProducer();
    }

    /**
     * consumers标识入参的content-type
     * produces标识出参的content-type
     * @param file
     * @return
     */
    @PostMapping(value = "consumer/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Boolean uploadFile(@RequestPart("file") MultipartFile file){
        return this.producerClient.upload(file);
    }
}
