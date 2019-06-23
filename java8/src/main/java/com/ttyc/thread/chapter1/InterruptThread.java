package com.ttyc.thread.chapter1;

public class InterruptThread {

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(() -> {
            Thread curr = Thread.currentThread();
            while (true) {
                if(curr.isInterrupted()) {
                    System.out.println(curr.getName() + " is interrupted");
                    return;
                }
                System.out.println("线程运行中 ...");
            }
        }, "测试线程");
        t.start();

        Thread.sleep(2000);

        t.interrupt();
    }
}
