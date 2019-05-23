package com.ttyc.thread.interview;

/**
 * 如何让两个线程按顺序执行
 * 1 join
 * 2 yield
 */
public class OrderExecuteThread {
    public static void main(String[] args) throws Exception {
        joinOrder();
    }

    public static void joinOrder() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("t1: " + i);
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("t2: " + i);
            }
        });
        t1.join();
        t2.start();
    }

    @Deprecated
    public static void yieldOrder() {
        ThreadA threadA = new ThreadA();
        Thread t1 = new Thread(new ThreadA());
        Thread t2 = new Thread(new ThreadB(t1));
        t1.start();
        t2.start();
    }
}

class ThreadA extends Thread {

    private boolean isFinished = false;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("t1: " + i);
        }
        this.isFinished = true;
        System.out.println("finished");
    }

    public boolean isFinished() {
        return isFinished;
    }
}

class ThreadB extends Thread {

    private Thread threadA;

    public ThreadB(Thread threadA) {
        this.threadA = threadA;
    }

    @Override
    public void run() {
        while (!threadA.isAlive()) {
            Thread.yield();
        }
        for (int i = 0; i < 100; i++) {
            System.out.println("t2: " + i);
        }
    }
}


