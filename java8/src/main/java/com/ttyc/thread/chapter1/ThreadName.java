package com.ttyc.thread.chapter1;

public class ThreadName {
    public static void main(String[] args) {
        new Thread(() -> {
            String name = Thread.currentThread().getName();
            System.out.println("name = " + name);
        }, "测试线程").start();
    }
}
