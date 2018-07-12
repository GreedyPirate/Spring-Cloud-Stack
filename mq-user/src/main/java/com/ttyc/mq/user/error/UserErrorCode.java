package com.ttyc.mq.user.error;

import com.ttyc.mq.common.exception.ExceptionEnums;

public enum UserErrorCode implements ExceptionEnums{

    INVAILD_IDENTITY("用户名或密码错误",1);

    private Integer module = 100;
    private Integer code;
    private String message;

    UserErrorCode(String message, Integer code) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return this.module*100 + this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
