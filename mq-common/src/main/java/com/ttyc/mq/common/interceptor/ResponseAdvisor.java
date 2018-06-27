package com.ttyc.mq.common.interceptor;

import com.ttyc.mq.common.annotations.NoWrapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 响应体封装
 *
 * @author yangjie
 * @since 1.0.0
 * @createTime 2018/6/26
 */
public class ResponseAdvisor implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    /**
     * 响应消息拦截，不对#{@link NoWrapper}拦截
     * @param body
     * @param methodParameter
     * @param mediaType
     * @param aClass
     * @param serverHttpRequest
     * @param serverHttpResponse
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        NoWrapper annotation = methodParameter.getMethod().getAnnotation(NoWrapper.class);
        if(annotation == null){
            ResponseModel model = new ResponseModel();
            model.setCode(200);
            model.setData(body);
            model.setMsg(null);
            return model;
        }
        return body;
    }
}
