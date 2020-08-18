package com.ttyc.redisson.delay.consistentHash;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DefaultHashFunction implements HashFunction {

    @Override
    public int hash(String key) {
        byte[] digest = md5(key);
        int h = 0;
        for (int i = 0; i < 4; i++) {
            h <<= 8;
            h |= ((int) digest[i]) & 0xFF;
        }
        return h;
    }


    private byte[] md5(String value) {
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
        md5.reset();
        byte[] bytes = value.getBytes(StandardCharsets.UTF_8);
        md5.update(bytes);
        return md5.digest();
    }
}
