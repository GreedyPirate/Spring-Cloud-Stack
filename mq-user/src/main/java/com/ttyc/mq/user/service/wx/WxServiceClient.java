package com.ttyc.mq.user.service.wx;

import com.ttyc.mq.user.service.wx.request.LoginParam;
import com.ttyc.mq.user.service.wx.response.LoginResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url = "${wx.api.base-url}", name = "wx")
public interface WxServiceClient {
    @RequestMapping(value = "sns/jscode2session", method = RequestMethod.GET)
    public LoginResponse login(LoginParam loginParam);
}
