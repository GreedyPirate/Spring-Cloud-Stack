package com.base.thread;

import java.util.function.Supplier;

public class ThreadLocalTest {


    public static void main(String[] args) {
        ThreadLocal<Integer> holder = new ThreadLocal<>();

        holder.set(2);

        Integer value = holder.get();

        holder.remove();
    }
}
