package com.ttyc.mq.user.service.wx.response;

import lombok.Data;

/**
 * @author yangjie
 * @description
 * openid	用户唯一标识
session_key	会话密钥
unionid	用户在开放平台的唯一标识符
 * @createTime 2018/6/1
 */
@Data
public class LoginResponse {
    private String openid;
    private String sessionKey;
    private String unionid;
}
