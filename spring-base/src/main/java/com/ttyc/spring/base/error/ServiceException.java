package com.ttyc.spring.base.error;

public class ServiceException extends RuntimeException{
    public ServiceException(String message) {
        super(message);
    }
}
