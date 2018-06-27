package com.ttyc.mq.common.interceptor;

import com.ttyc.mq.common.annotations.NoWrapper;
import com.ttyc.mq.common.exception.BaseError;
import com.ttyc.mq.common.exception.ServiceException;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * Controller类的错误拦截，以及响应体封装
 *
 * @author yangjie
 * @since 1.0.0
 * @createTime 2018/6/26
 */
@ControllerAdvice(basePackages="com.ttyc",annotations={RestController.class})
public class ExceptionAdvisor{
    /**
     * 针对ServiceException拦截
     * @param e
     * @return
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseModel handleServiceExpcetion(ServiceException e){
        ResponseModel model = new ResponseModel();
        model.setData(null);
        model.setCode(e.getErrorCode().getCode());
        model.setMsg(e.getErrorCode().getMessage());
        return model;
    }

    /**
     * 其他错误
     * @param ex
     * @return
     */
    @ExceptionHandler({Exception.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseModel exception(Exception ex) {
        ResponseModel model = new ResponseModel();
        model.setData(null);
        model.setCode(BaseError.INTERNAL_SERVER_ERROR.getCode());
        model.setMsg(BaseError.INTERNAL_SERVER_ERROR.getMessage());
        return model;
    }


}
