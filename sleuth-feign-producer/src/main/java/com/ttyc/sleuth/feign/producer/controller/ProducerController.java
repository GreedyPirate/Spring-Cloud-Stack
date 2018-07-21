package com.ttyc.sleuth.feign.producer.controller;

import com.ttyc.sleuth.feign.producer.model.User;
import com.ttyc.sleuth.feign.producer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("hi")
    public User hi(){
        return this.userRepository.findById(1L).get();
    }
}
