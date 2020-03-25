package com.base;

import java.util.Random;

public class TestCase2 {
    public static void main(String[] args) {
        SkipList list = new SkipList();
        list.insert(450);
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            list.insert(random.nextInt(1000));
        }

        SkipList.Node node = list.find(450);
        System.out.println(node);
        System.out.println(list.getSearchCount());
    }
}
