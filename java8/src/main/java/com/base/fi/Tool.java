package com.base.fi;

import java.util.function.Consumer;

public class Tool {
    public static void print(Integer i) {
        System.out.println(i);
    }

    public static void consume(Consumer<Integer> t) {
        int i = 10;
        t.accept(i);
    }

    public static void main(String[] args) {
        Tool tool = new Tool();
        tool.consume(Tool::print);
    }
}
