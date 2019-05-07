package com.ttyc.juc.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Main {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, ()->{
            System.out.println("5 thread execute completed");
        });

        for (int i=0; i<100; i++){
            new Thread(()->{
                try {
                    System.out.println("waiting thread");
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
