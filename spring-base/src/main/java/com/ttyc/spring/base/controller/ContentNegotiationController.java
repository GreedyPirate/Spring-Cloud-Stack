package com.ttyc.spring.base.controller;

import com.ttyc.spring.base.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 内容协商
 */
@RestController
public class ContentNegotiationController {

    @PostMapping("user")
    public User user(){
        User user = User.builder().id(1L).name("jay").phone("183").build();
        return user;
    }
}
