package com.ttyc.spring.base.controller;

import com.ttyc.spring.base.model.User;
import com.ttyc.spring.base.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.ConcurrentLinkedDeque;

@RestController
public class AsyncController {

    @Autowired
    AsyncService asyncService;

    private ConcurrentLinkedDeque<DeferredResult<User>> deferredResults =
            new ConcurrentLinkedDeque<DeferredResult<User>>();

    public DeferredResult<User> deferredResult(){
        DeferredResult<User> result = new DeferredResult<User>(1000L);
        deferredResults.add(result);
        return null;
    }
}
