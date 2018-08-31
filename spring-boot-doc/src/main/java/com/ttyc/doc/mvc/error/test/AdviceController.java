package com.ttyc.doc.mvc.error.test;

import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdviceController {
    @GetMapping("/advice")
    public String advice(String content){
        Assert.notNull(content,"content can not be null !");
        return "advice";
    }
}
