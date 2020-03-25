package com.ttyc.delay;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.DelayQueue;

public class TestCase {
    public static void main(String[] args) {
        DelayQueue<Task> queue = new DelayQueue<>();
        Random random = new Random();
        Date now = new Date();
        for (int i = 0; i < 10; i++) {
            Date execute = new Date(now.getTime() + random.nextInt(10000));
            Task task = new Task(execute);
            queue.add(task);
        }
        Task task;
        while (queue.size() > 0) {
            task = queue.poll();
            if (task != null)
                task.print();
        }
    }
}
