package com.base.delay;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.DelayQueue;

public class TestCase {
    public static void main(String[] args) throws InterruptedException {
        DelayQueue<Order> queue = new DelayQueue<>();

        Random random = new Random();
        long now = new Date().getTime();
        for (int i = 0; i < 10; i++) {
            Order order = new Order(new Date(now + random.nextInt(10000)), i);
            queue.add(order);
        }
        while (queue.size() > 0) {
            Order order = queue.take();
            order.print();
        }
    }
}
