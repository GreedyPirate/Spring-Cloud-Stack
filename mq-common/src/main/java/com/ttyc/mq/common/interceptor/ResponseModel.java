package com.ttyc.mq.common.interceptor;

import lombok.Data;

/**
 * 响应体
 *
 * @author yangjie
 * @since 1.0.0
 * @createTime 2018/6/26
 */
@Data
public class ResponseModel<T> {
    private T data;
    private Integer code;
    private String msg;
}
