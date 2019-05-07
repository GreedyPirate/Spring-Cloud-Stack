package com.ttyc.juc.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5,false);

        new Resource(semaphore,3).start();
        new Resource(semaphore,2).start();
        new Resource(semaphore,4).start();
    }
}

class Resource extends Thread{
    private Semaphore semaphore;

    private int count;

    public Resource(Semaphore semaphore, int count) {
        this.semaphore = semaphore;
        this.count = count;
    }

    @Override
    public void run() {
        try {
            System.out.println("apply");
            semaphore.acquire(count);
            TimeUnit.SECONDS.sleep(1);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("release");
            semaphore.release(count);
        }
    }
}














class Pool {
    private static final int MAX_AVAILABLE = 100;
    private final Semaphore available = new Semaphore(MAX_AVAILABLE, true);

    public Object getItem() throws InterruptedException {
        available.acquire();
        return getNextAvailableItem();
    }

    public void putItem(Object x) {
        if (markAsUnused(x)){
            available.release();
        }

    }

    // Not a particularly efficient data structure; just for demo

    protected Resource[] items = {};
    protected boolean[] used = new boolean[MAX_AVAILABLE];

    protected synchronized Object getNextAvailableItem() {
        for (int i = 0; i < MAX_AVAILABLE; ++i) {
            if (!used[i]) {
                used[i] = true;
                return items[i];
            }
        }
        return null; // not reached
    }

    protected synchronized boolean markAsUnused(Object item) {
        for (int i = 0; i < MAX_AVAILABLE; ++i) {
            if (item == items[i]) {
                if (used[i]) {
                    used[i] = false;
                    return true;
                } else{
                    return false;
                }

            }
        }
        return false;
    }
}
