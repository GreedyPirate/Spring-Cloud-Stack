package com.ttyc.spring.base.config;

import com.ttyc.spring.base.model.ResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
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
@RestControllerAdvice(basePackages="com.chamc.process.controller",annotations={RestController.class})
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
        ResponseModel model = new ResponseModel();
        model.setData(null);
        model.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.setMsg(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        String classname = ex.getClass().getSimpleName();
        log.error("{} is occured, message is {}",classname, ex.getMessage());
        return model;
    }

    @ExceptionHandler({BindException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseModel exception(BindException ex) {
        ResponseModel model = new ResponseModel();
        model.setData(null);
        model.setCode(HttpStatus.BAD_REQUEST.value());
        model.setMsg(buildErrorMessage(ex));
        String classname = ex.getClass().getSimpleName();
        log.error("{} is occured, message is {}",classname, ex.getMessage());
        return model;
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseModel exception(MethodArgumentNotValidException ex) {
        ResponseModel model = new ResponseModel();
        model.setData(null);
        model.setCode(HttpStatus.BAD_REQUEST.value());
        model.setMsg(buildErrorMessage(ex));
        String classname = ex.getClass().getSimpleName();
        log.error("{} is occured, message is {}",classname, ex.getMessage());
        return model;
    }


    private String buildErrorMessage(BindException ex){
        return buildObjectErrorMessage(ex.getAllErrors());
    }

    private String buildErrorMessage(MethodArgumentNotValidException ex){
        return buildObjectErrorMessage(ex.getBindingResult().getAllErrors());
    }

    /**
     * 构建错误信息
     * @param objectErrors
     * @return
     */
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
