package com.ttyc.sleuth.feign.consumer.sleuth;

import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ErrorSpanAspect {

    private Logger logger = LoggerFactory.getLogger(ErrorSpanAspect.class);

    @Pointcut("(execution(* *..service..*.*(..))) && (@within(org.springframework.stereotype.Service))")
    public void errorSpan(){
    }

}