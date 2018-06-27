package com.ttyc.mq.common.exception;

public class ServiceException extends RuntimeException{
    private static final long serialVersionUID = -1362544102815925841L;
    private ExceptionEnums errorCode;

    public ServiceException(ExceptionEnums errorCode) {
        this.errorCode = errorCode;
    }

    public ExceptionEnums getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ExceptionEnums errorCode) {

        this.errorCode = errorCode;
    }
}