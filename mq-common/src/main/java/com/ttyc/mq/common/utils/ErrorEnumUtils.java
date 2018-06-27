package com.ttyc.mq.common.utils;

import com.ttyc.mq.common.exception.ExceptionEnums;

public class ErrorEnumUtils {

    /**
     * 根据错误码获取枚举值
     * @param clazz
     * @param code
     * @param <T>
     * @return
     */
    public static <T extends ExceptionEnums> T getMessage(Class<T> clazz, String code){
        T[] enums = clazz.getEnumConstants();
        if (enums.length > 0){
            for (T t : enums){
                if(t.getCode().equals(code)){
                    return t;
                }
            }
        }
        return null;
    }
}
