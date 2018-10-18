package com.ttyc.spring.base.controller;

import com.ttyc.spring.base.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController {

    @PostMapping("create")
    public Boolean create(@Valid @RequestBody User user){
        System.out.println(user);
        return true;
    }
}
