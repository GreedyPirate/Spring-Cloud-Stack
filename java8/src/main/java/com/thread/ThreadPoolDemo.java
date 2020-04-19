package com.thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolDemo {

    private static AtomicInteger order = new AtomicInteger(0);

    private static AtomicInteger rejectCounter = new AtomicInteger(0);

    private static BlockingQueue<Runnable> blockingDeque = new ArrayBlockingQueue<Runnable>(10);

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 10, TimeUnit.SECONDS, blockingDeque, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r,"thread-pool-demo-" + order.getAndIncrement());
                return t;
            }
        }, (r, e) -> {
            rejectCounter.getAndIncrement();
            throw new RejectedExecutionException("Task " + r.toString() +
                    " rejected from " +
                    e.toString());
        });

        executor.allowCoreThreadTimeOut(false);

        executor.submit(() -> {
            System.out.println("executing ...");
            sleep(3);
        });

        int activeCount = executor.getActiveCount();
        long completedTaskCount = executor.getCompletedTaskCount();
        BlockingQueue<Runnable> queue = executor.getQueue();
        int size = queue.size();
        int remainingCapacity = queue.remainingCapacity();

    }

    public static void sleep(int num) {
        try {
            TimeUnit.SECONDS.sleep(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
