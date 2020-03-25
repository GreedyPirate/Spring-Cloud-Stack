package com.net.mytimer;


import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TimeScheduler {

    private TimeWheel timeWheel;

    private DelayQueue<TaskList> queue = new DelayQueue<>();

    private ExecutorService workPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);

    private static final int DEFAULT_WHEEL_SIZE = 60;

    public TimeScheduler() {
        timeWheel = new TimeWheel();
    }
}
