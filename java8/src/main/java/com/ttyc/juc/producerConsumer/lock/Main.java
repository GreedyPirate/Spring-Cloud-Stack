package com.ttyc.juc.producerConsumer.lock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    private static BlockingQueue<String> pool = new ArrayBlockingQueue<String>(10);

    private static Lock lock = new ReentrantLock();
    private Condition isFull = lock.newCondition();
    private Condition isEmpty = lock.newCondition();

    private AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        Main main = new Main();
        new Thread(() -> {
            while (true) {
                main.put();
            }
        }).start();
        new Thread(() -> {
            while (true) {
                main.task();
            }
        }).start();
    }

    public void put() {
        lock.lock();
        try {
            while (pool.size() == 10) {
                isFull.await();
            }
            TimeUnit.MICROSECONDS.sleep(500);
            String info = "product " + count.getAndIncrement();
            pool.put(info);
            System.out.println(info);
            isEmpty.signalAll();
        }catch (Exception e) {

        }finally {
            lock.unlock();
        }
    }

    public void task() {
        lock.lock();
        try {
            while (pool.size() == 0) {
                isEmpty.await();
            }
            TimeUnit.SECONDS.sleep(1);
            String take = pool.take();
            System.out.println("consumer : " + take);
            isFull.signalAll();
        }catch (Exception e) {

        }finally {
            lock.unlock();
        }
    }
}
