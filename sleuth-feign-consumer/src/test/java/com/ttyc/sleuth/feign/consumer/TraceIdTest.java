package com.ttyc.sleuth.feign.consumer;

import org.junit.Test;

public class TraceIdTest {

    @Test
    public void testId(){
        String id = "4b8cbc9b8de0e563";
        System.out.println(id.length());
        validateHex(id);
    }
    void validateHex(String id) {
        int i = 0;

        for(int length = id.length(); i < length; ++i) {
            char c = id.charAt(i);
            if ((c < '0' || c > '9') && (c < 'a' || c > 'f')) {
                throw new IllegalArgumentException(id + " should be lower-hex encoded with no prefix");
            }
        }

    }
}
