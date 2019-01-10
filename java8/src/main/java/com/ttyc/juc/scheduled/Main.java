package com.ttyc.juc.scheduled;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ParseException, ExecutionException, InterruptedException {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(5);

        long delay = getDelay("2018-12-28 16:39:20");
        System.out.println("delay time: " + delay);
        executor.schedule(() -> {
            System.out.println("ho ho");
        }, delay, TimeUnit.MILLISECONDS);

        ScheduledFuture<String> future = executor.schedule(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("call");
                return "burn";
            }
        }, delay + 5000, TimeUnit.MILLISECONDS);
        String s = future.get();
        System.out.println(s);

    }


    public static long getDelay(String s) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.parse(s).getTime() - System.currentTimeMillis();
    }
}
