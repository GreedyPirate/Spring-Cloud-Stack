package com.ttyc.thread.chapter1;

import java.util.concurrent.TimeUnit;

public class JoinCase {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                System.out.println("thread running");
                TimeUnit.SECONDS.sleep(3);
                System.out.println("thread over");
            } catch (InterruptedException e) {
                System.out.println("interrupted while running");
                e.printStackTrace();
            }
        });
        t1.start();
        // 等待t1执行期间，可以中断t1
//        t1.interrupt();
        // 等待t1执行完
//        t1.join();
        // 假设不知道t1需要执行多久，我就等2s
        t1.join(2000L);


        System.out.println("all over");
    }
}
