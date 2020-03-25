package com.net.timer;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Timer timer = Timer.getInstance();
        System.out.println("date = " + LocalDateTime.now());
        timer.addTask(new TimedTask(3000, ()->{
            System.out.println("task executed " + LocalDateTime.now());
        }));

        timer.addTask(new TimedTask(5000, ()->{
            System.out.println("task executed " + LocalDateTime.now());
        }));

        timer.addTask(new TimedTask(4000, ()->{
            System.out.println("task executed " + LocalDateTime.now());
        }));
    }
}
