package com.ttyc.jdk;

import java.util.function.Consumer;

public class Lambda {

    private static Consumer<Grey> consumer = (t) -> System.out.println(t.toString());

    public static void main(String[] args) {
        System.out.println("=====");
        testConsumer();
    }

    public static void testConsumer() {
        consumer.accept(new Grey());
    }
}
