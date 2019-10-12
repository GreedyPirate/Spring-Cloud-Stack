package com.ttyc.spring.base.config;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ResponseModel<T> {
    private T data;
    private Integer code;
    private String msg;

    public static ResponseModel of(HttpStatus httpStatus){
        return of(httpStatus, httpStatus.getReasonPhrase());
    }

    public static ResponseModel of(HttpStatus httpStatus,String message){
        ResponseModel model = new ResponseModel();
        model.setData(null);
        model.setCode(httpStatus.value());
        model.setMsg(message);
        return model;
    }
}
