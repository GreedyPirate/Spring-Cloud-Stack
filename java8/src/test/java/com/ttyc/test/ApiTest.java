package com.ttyc.test;

import org.junit.Test;

public class ApiTest {
    @Test
    public void testHash() {
        System.out.println("test-group".hashCode());
        System.out.println("hrs".hashCode());
        System.out.println("hrs".hashCode() % 50);

        System.out.println();

        String s= "haha";
        System.out.println(s.getBytes().length);
    }
}
