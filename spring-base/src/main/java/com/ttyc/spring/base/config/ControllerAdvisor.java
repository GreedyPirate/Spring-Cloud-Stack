package com.ttyc.spring.base.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * Created by Jaynnay on 2018/4/16
 **/
@RestControllerAdvice(basePackages="com.ttyc.spring.base",annotations={RestController.class})
@Slf4j
public class ControllerAdvisor{

    private static final String PREFIX_ERROR = "请求失败，原因：";

    /**
     * 其他错误
     * @param ex
     * @return
     */
    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseModel exception(Exception ex) {
        return ResponseModel.of(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseModel exception(MethodArgumentNotValidException ex) {
        return ResponseModel.of(HttpStatus.BAD_REQUEST, buildErrorMessage(ex));
    }

    /**
     * 构建错误信息
     */
    private String buildErrorMessage(MethodArgumentNotValidException ex){
        return buildObjectErrorMessage(ex.getBindingResult().getAllErrors());
    }

    private String buildObjectErrorMessage(List<ObjectError> objectErrors){
        StringBuilder message = new StringBuilder(PREFIX_ERROR);
        objectErrors.stream().forEach(error -> {
            if(error instanceof FieldError){
                FieldError fieldError = (FieldError) error;
                message.append(fieldError.getDefaultMessage()).append(",");
            }
        });
        return message.deleteCharAt(message.length()-1).toString();
    }
}
