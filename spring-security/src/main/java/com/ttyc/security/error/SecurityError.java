package com.ttyc.security.error;

import com.ttyc.mq.common.exception.ExceptionEnums;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor()
@AllArgsConstructor
public enum  SecurityError implements ExceptionEnums{
    INVALID_USERNAME(1,"无效的用户名");

    private final Integer module = 100;
    private Integer code;
    private String message;

    @Override
    public Integer getCode() {
        return module * 100 + code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
