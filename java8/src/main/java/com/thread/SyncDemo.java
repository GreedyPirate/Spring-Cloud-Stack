package com.thread;

public class SyncDemo {

    private int count;

    private void add() {
        // 有100个线程都执行add，都去获取类锁，变成串行的了
        synchronized (SyncDemo.class) {
            count++;
        }
    }
}
