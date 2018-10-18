package com.ttyc.skywalking.producer.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @GetMapping("ok")
    public ResponseEntity<String> ok(){
        return ResponseEntity.ok("ok ~");
    }
}
