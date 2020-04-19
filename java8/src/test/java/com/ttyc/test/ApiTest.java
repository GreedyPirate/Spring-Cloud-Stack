package com.ttyc.test;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ApiTest {
    @Test
    public void testHash() {
        System.out.println("test-group".hashCode());
        System.out.println("hrs".hashCode());
        System.out.println("hrs".hashCode() % 50);

        System.out.println();

        String s= "haha";
        System.out.println(s.getBytes().length);

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        queue.offer(1);
        queue.offer(2);

        String simpleName = queue.getClass().getSimpleName();
        System.out.println("simpleName = " + simpleName);

        System.out.println("queue.size() = " + queue.size());
        System.out.println("queue.remainingCapacity() = " + queue.remainingCapacity());
    }
}
