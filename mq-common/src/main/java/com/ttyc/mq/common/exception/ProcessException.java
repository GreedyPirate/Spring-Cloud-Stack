package com.ttyc.mq.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

public class ProcessException extends RuntimeException{
    private static final long serialVersionUID = -1362544102815925841L;
    private ExceptionEnums errorCode;

    public ProcessException(ExceptionEnums errorCode) {
        this.errorCode = errorCode;
    }

    public ExceptionEnums getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ExceptionEnums errorCode) {

        this.errorCode = errorCode;
    }
}