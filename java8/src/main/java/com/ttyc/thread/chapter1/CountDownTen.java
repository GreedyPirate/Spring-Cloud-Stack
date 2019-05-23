package com.ttyc.thread.chapter1;

import java.util.concurrent.TimeUnit;

public class CountDownTen {
    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 10; i > 0; i--) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("倒计时: " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
