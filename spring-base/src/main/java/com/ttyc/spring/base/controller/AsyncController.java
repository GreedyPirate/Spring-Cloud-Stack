package com.ttyc.spring.base.controller;

import com.ttyc.spring.base.model.User;
import com.ttyc.spring.base.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 异步简单版
 */
@RestController
public class AsyncController {

    @Autowired
    AsyncService asyncService;


    @GetMapping("callable")
    public Callable<User> callable(){
        ExecutorService service = Executors.newFixedThreadPool(2);

        Callable<User> callable = ()->{
            User user = new User(100L,"tone", "231");
            return user;
        };
        service.submit(callable);

        return callable;
    }
}
