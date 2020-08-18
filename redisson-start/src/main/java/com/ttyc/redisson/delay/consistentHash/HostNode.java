package com.ttyc.redisson.delay.consistentHash;

public class HostNode implements Node {

    private String ip;

    private int port;

    @Override
    public String getKey() {
        return ip + ":" + port;
    }
}
