package com.ttyc.jol;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;
import org.openjdk.jol.vm.VM;

import java.util.HashMap;

public class Main {
    L lock = new L();
    public static void main(String[] args) {
        Main main = new Main();
//        System.out.println(VM.current().details());
        main.objectHeader();
//        main.lock();
    }

    private void objectHeader() {
        L l = new L();
        System.out.println(Integer.toHexString(l.hashCode()));
        System.out.println(ClassLayout.parseInstance(l).toPrintable());
        System.out.println("========================================");
        System.out.println(GraphLayout.parseInstance(l).toPrintable());
        System.out.println(GraphLayout.parseInstance(l).totalSize());

        System.out.println(ClassLayout.parseInstance(new HashMap<Integer, String>()).toPrintable());

    }

    public void lock() {
        System.out.println(Integer.toHexString(lock.hashCode()));
        System.out.println(ClassLayout.parseInstance(lock).toPrintable());

        synchronized (lock) {
            System.out.println("1");
        }

        System.out.println(ClassLayout.parseInstance(lock).toPrintable());

        synchronized (lock) {
            System.out.println("2");
        }

        System.out.println(ClassLayout.parseInstance(lock).toPrintable());

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (lock) {
                    System.out.println("t");
                }
            }
        }).start();

        for (int i = 0; i < 10; i++) {
            synchronized (lock) {
                System.out.println("3");
            }

        }
        System.out.println(ClassLayout.parseInstance(lock).toPrintable());
    }

}


class L {

}

