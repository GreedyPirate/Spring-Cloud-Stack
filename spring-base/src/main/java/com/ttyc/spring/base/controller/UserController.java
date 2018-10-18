package com.ttyc.spring.base.controller;

import com.ttyc.spring.base.model.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController {

    @PostMapping("create")
    public Boolean create(@Valid @RequestBody User user){
        System.out.println(user);
        return true;
    }

    @GetMapping
    public User query(Long id){
        return User.builder().id(id).name("...").phone("...").build();
    }
}
