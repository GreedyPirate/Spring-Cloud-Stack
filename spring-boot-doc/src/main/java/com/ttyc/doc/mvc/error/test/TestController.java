package com.ttyc.doc.mvc.error.test;

import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("test/error")
    public String errorTest(String param){
        Assert.notNull(param,"请求参数不能为空");
        return "OK";
    }
}
