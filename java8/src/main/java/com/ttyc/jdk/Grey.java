package com.ttyc.jdk;

import java.util.Random;

public class Grey {
    public static void main(String[] args) {
        String bikeSn = "8001";
        Random random = new Random();
        int count = 0;
        for (int i = 0; i < 1000; i++) {
            int num = random.nextInt(99999) + 10000;
            String sn = bikeSn + num;
            if(Long.parseLong(sn) % 10 == 0) {
                count ++;
            }
        }
        System.out.println("count = " + count);
    }
}
