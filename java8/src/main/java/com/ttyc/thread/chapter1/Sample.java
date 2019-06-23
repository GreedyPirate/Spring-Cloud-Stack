package com.ttyc.thread.chapter1;

public class Sample {
    public static void main(String[] args) {
        new Thread(() -> {
            boil();
        }).start();

        new Thread(() -> {
            sweep();
        }).start();
    }

    public static void boil() {
        for (int i = 0; i < 10; i++) {
            System.out.println("boiling " + 10 * i + "%");
        }
    }

    public static void sweep() {
        for (int i = 0; i < 10; i++) {
            System.out.println("sweep " + 10 * i + "%");
        }
    }
}
