package com.ttyc.mq.user.error;

public enum ErrorCode {
    ;
    private final Integer FACTOR = 100;
    private Integer code;
    private String message;

    ErrorCode(Integer code, String message) {
        //this.code = code * FACTOR;
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
