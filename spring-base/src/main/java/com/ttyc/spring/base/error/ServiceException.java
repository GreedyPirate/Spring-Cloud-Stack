package com.ttyc.spring.base.error;

public class ServiceException extends RuntimeException{

    private ExceptionEnum exceptionEnum;

    public ServiceException(ExceptionEnum exceptionEnum) {
        this.exceptionEnum = exceptionEnum;
    }


}
