package com.ttyc.spring.base.controller;

import com.ttyc.spring.base.model.User;
import com.ttyc.spring.base.service.WhiteService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("query")
    public User query(Long id){
        return User.builder().id(id).name("...").phone("...").build();
    }

}
