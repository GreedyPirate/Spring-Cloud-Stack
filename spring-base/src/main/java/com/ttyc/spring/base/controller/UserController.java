package com.ttyc.spring.base.controller;

import com.ttyc.spring.base.model.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @PostMapping("create")
    public Boolean create(@Validated @RequestBody User user){
        System.out.println(user);
        return true;
    }

    @GetMapping
    public User query(Long id){
        return User.builder().id(id).name("...").phone("...").build();
    }
}
