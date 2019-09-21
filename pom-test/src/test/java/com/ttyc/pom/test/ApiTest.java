package com.ttyc.pom.test;

import org.junit.Test;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ApiTest {

    @Test
    public void testJSONArray() {
        User jay = User.builder().name("jay").build();
        Field[] fields = User.class.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            try {
                if(field.getGenericType().equals(Integer.class) && field.get(jay) == null ) {
                    field.set(jay, 0);
                }
            } catch (IllegalAccessException e) {

            }
        }
        System.out.println(jay);
    }

    @Test
    public void testStrip() {
        String path = "";
        String newPath = Arrays.stream(StringUtils.tokenizeToStringArray(path, "/"))
                .skip(2).collect(Collectors.joining("/"));

        int bucketIndex = (int) ((7234 / 1000) % 60000);
        System.out.println("bucketIndex = " + bucketIndex);

        int i = (int) ((System.currentTimeMillis() / 1000) % 60);
        System.out.println("i = " + i);
    }
}
