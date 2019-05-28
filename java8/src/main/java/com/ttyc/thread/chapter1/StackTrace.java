package com.ttyc.thread.chapter1;

public class StackTrace {

    public static void main(String[] args) {
        a();
    }

    public static void a() {
        b();
    }

    public static void b() {
        StackTraceElement[] stackTraces = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTrace :stackTraces) {
            System.out.println("stackTrace = " + stackTrace);
        }
        new Thread(() -> {
            c();
        }).start();
    }

    public static void c() {
        System.out.println("this is c");
        StackTraceElement[] stackTraces = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTrace :stackTraces) {
            System.out.println("stackTrace = " + stackTrace);
        }
        int i = 1/0;
    }
}
