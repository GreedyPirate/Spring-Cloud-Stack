package com.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FutureTest {

    public static Executor executor =
            new ThreadPoolExecutor(3, 5, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<>(100), (r) -> {
                Thread thread = new Thread(r);
                thread.setName("test");
                return thread;
            }, new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        List<String> main = new ArrayList<>();
  /*      for (int i = 0; i < 100; i++) {
            main.add("main task" + i);
        }*/

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            return "aaa";
        }, executor);

        future.thenApply((t) -> {
            return t.length();
        }).thenAccept((t) -> {
            System.out.println("t = " + t);
        }).whenComplete((v, e) -> {
            System.out.println("result = " + v);
        });
    }
}
