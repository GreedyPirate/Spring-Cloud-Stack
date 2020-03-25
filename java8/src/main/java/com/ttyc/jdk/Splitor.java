package com.ttyc.jdk;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class Splitor {
    public static void main(String[] args) {
        List<String> arrs = new ArrayList<>();
        arrs.add("a");
        arrs.add("b");
        arrs.add("c");
        arrs.add("d");
        arrs.add("e");
        arrs.add("f");
        arrs.add("h");
        arrs.add("i");
        arrs.add("j");
        Spliterator<String> a = arrs.spliterator();
        System.out.println(a);

        Spliterator<String> b = a.trySplit();
        System.out.println(b.toString());

        Spliterator<String> c = a.trySplit();
        System.out.println(c.toString());

        Spliterator<String> d = a.trySplit();
        System.out.println(d.toString());


    }


}
