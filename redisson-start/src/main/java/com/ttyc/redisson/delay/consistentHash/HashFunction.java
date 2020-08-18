package com.ttyc.redisson.delay.consistentHash;

public interface HashFunction {

    int hash(String key);
}
