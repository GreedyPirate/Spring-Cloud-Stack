package com.ttyc.producer.client;

import com.ttyc.producer.client.utils.ClassUtils;
import org.junit.Test;

public class UtilsTest {

    @Test
    public void testClass(){
        String s = ClassUtils.printLocation("org.springframework.boot.test.context.runner.ApplicationContextRunner");
        System.out.println(s);
    }
}