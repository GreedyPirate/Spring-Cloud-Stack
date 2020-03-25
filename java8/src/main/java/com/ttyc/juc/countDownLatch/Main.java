package com.ttyc.juc.countDownLatch;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
        for (int i = 0; i < 10; i++) {
            queue.offer("ele " + i);
        }
        CountDownLatch latch = new CountDownLatch(10);
        while (queue.size() > 0) {
            System.out.println(queue.poll());
            latch.countDown();
        }
        latch.await();
        System.out.println("over");
    }
}
