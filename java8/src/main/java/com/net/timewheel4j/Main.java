package com.net.timewheel4j;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Timer timer = new Timer(1, 10);
        timer.addTask(new TimerTask(10000, () -> {
            System.out.println("task\t" + new Date());
        }));
    }
}
