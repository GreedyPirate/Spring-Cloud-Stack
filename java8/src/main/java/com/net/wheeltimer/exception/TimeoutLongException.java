package com.net.wheeltimer.exception;

/**
 * @author zhangp
 * @version 创建时间: 2018/4/21
 * @description 超时时间太长异常
 */
public class TimeoutLongException extends Exception{
    public TimeoutLongException(String message){
        super(message);
    }
}
