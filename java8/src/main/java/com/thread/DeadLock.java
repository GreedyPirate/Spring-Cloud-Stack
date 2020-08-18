package com.thread;

public class DeadLock {
    private Object lockA;
    private Object lockB;

    public DeadLock(Object lockA, Object lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    public void add() {
        synchronized (lockA) {
            synchronized (lockB) {
                System.out.println("add");
            }
        }
    }

    public void put() {
        synchronized (lockA) {
            synchronized (lockB) {
                System.out.println("put");
            }
        }
    }

    public static void main(String[] args) {
        Object lockA = new Object();
        Object lockB = new Object();
        new Thread(() -> {
            DeadLock deadLock = new DeadLock(lockA, lockB);
            while (true) {
                deadLock.add();
            }
        }).start();
        new Thread(() -> {
            DeadLock deadLock = new DeadLock(lockA, lockB);
            while (true) {
                deadLock.put();
            }
        }).start();
    }
}