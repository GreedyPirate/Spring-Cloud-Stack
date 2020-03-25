package com.ttyc.spring.base.config;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

@ControllerAdvice("com.ttyc.spring.base.controller")
public class RequestParamParser implements RequestBodyAdvice {

    @Override
    public boolean supports(MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        return methodParameter.hasParameterAnnotation(RequestBody.class);
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) throws IOException {
        return null;
    }

    @Override
    public Object afterBodyRead(Object o, HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {

        return new HttpInputMessage() {
            @Override
            public InputStream getBody() throws IOException {
                InputStream body = httpInputMessage.getBody();

                return httpInputMessage.getBody();
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = httpInputMessage.getHeaders();
                String userId = headers.getFirst("userId");
                if(StringUtils.hasText(userId)) {
                    // 发请求获取
                    String username = "jason";
                    headers.add("username", username);
                }
                return headers;
            }
        };
    }

    @Override
    public Object handleEmptyBody(Object o, HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        return o;
    }

    class ParamsHttpInputMessage implements HttpInputMessage {

        @Override
        public InputStream getBody() throws IOException {

            return null;
        }

        @Override
        public HttpHeaders getHeaders() {
            return null;
        }
    }
}
