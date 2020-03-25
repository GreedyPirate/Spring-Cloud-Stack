package com.ttyc.juc.producerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Main {
    private static BlockingQueue<String> pool = new ArrayBlockingQueue<String>(10);


    public static void main(String[] args) {
        Producer producer = new Producer(pool);
        Consumer consumer = new Consumer(pool);

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);

        t1.start();
        t2.start();
    }
}


class Producer implements Runnable{

    private BlockingQueue<String> pool;

    public Producer(BlockingQueue<String> pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            synchronized (pool){
                while (pool.size() == 10){
                    try {
                        System.out.println("pool is full");
                        pool.wait();
                    } catch (InterruptedException e) {

                    }
                }
                try {
                    TimeUnit.MICROSECONDS.sleep(500);
                    pool.put("product " + count);
                    System.out.println("product " + count);
                    count++;
                    pool.notifyAll();
                } catch (InterruptedException e) {

                }
            }
        }
    }
}

class Consumer implements Runnable{

    private BlockingQueue<String> pool;

    public Consumer(BlockingQueue<String> pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (pool) {
                while (pool.isEmpty()) {
                    try {
                        System.out.println("pool is empty");
                        pool.wait();
                    } catch (InterruptedException e) {
                    }
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                    String poll = pool.poll();
                    System.out.println("consumer = " + poll);
                    pool.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}