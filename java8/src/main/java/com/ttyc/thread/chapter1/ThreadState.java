package com.ttyc.thread.chapter1;

public class ThreadState {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("i = " + i);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        });

        Thread.State state1 = t.getState();
        System.out.println("state1 = " + state1);

        t.start();

        Thread.State state = null;
        while( (state = t.getState()) != Thread.State.TERMINATED) {
            System.out.println("state = " + state);
        }

    }
}
