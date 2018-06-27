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

    private Integer module = 0;
    private Integer code;
    private String message;

    BaseError(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getModule() {
        return null;
    }

    @Override
    public Integer getCode() {
        return null;
    }

    @Override
    public String getMessage() {
        return null;
    }
}
