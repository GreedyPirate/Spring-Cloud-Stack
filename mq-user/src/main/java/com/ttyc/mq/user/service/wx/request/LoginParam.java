package com.ttyc.mq.user.service.wx.request;

import lombok.Data;

/**
 * appid	是	小程序唯一标识
 secret	是	小程序的 app secret
 js_code	是	登录时获取的 code
 grant_type	是	填写为 authorization_code
 */
@Data
public class LoginParam {
    private String appid;
    private String secret;
    private String jsCode;
    private String grantType;
}
