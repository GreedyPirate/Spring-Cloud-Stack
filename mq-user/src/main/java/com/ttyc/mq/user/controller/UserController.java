package com.ttyc.mq.user.controller;

import com.ttyc.mq.user.service.wx.WxServiceClient;
import com.ttyc.mq.user.service.wx.request.LoginParam;
import com.ttyc.mq.user.service.wx.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private WxServiceClient wxServiceClient;



    @PostMapping("/wxLogin")
    public LoginResponse wxLogin(LoginParam loginParam){
        return wxServiceClient.login(loginParam);
    }
}
