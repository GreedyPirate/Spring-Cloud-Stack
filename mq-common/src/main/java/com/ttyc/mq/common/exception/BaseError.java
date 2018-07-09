package com.ttyc.mq.common.exception;

/**
 * 常见的错误类型
 *
 * @author yangjie
 * @since 1.0.0
 * @createTime 2018/6/26
 */
public enum  BaseError implements ExceptionEnums{
    INTERNAL_SERVER_ERROR(500, "服务器内部错误");

    private final Integer module = 0;
    private Integer code;
    private String message;

    BaseError(Integer code, String message) {
        this.code = this.module + code;
        this.message = message;
    }

    public Integer getModule() {
        return module;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
