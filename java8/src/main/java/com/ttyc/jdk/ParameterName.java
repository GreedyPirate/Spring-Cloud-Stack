package com.ttyc.jdk;

import com.ttyc.time.DateUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * 获取方法参数名
 * javac -parameters
 */
public class ParameterName {
    public static void main(String[] args) throws NoSuchMethodException {
        Method isToday = DateUtils.class.getDeclaredMethod("isToday", long.class);
        Parameter[] parameters = isToday.getParameters();
        String name = parameters[0].getName();
        System.out.println("name = " + name);
    }
}
