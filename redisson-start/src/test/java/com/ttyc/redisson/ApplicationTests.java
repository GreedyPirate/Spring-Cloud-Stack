package com.ttyc.redisson;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=RedissonStartApplication.class)
public class ApplicationTests {

    @Autowired
    private RedissonClient rClient;

    @Test
    public void testLock() {
        RLock monitor = rClient.getLock("monitor");
        try {
            monitor.lock(5, TimeUnit.SECONDS);
            System.out.println("test...");
        }finally {
            monitor.unlock();
        }
    }
}
