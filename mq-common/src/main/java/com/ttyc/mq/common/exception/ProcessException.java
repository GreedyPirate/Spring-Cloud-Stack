package com.ttyc.mq.common.exception;

import com.ttyc.mq.user.error.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;

public class ProcessException extends RuntimeException{
    private static final long serialVersionUID = -1362544102815925841L;
    private ErrorCode errorCode;

    public ProcessException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {

        this.errorCode = errorCode;
    }
}