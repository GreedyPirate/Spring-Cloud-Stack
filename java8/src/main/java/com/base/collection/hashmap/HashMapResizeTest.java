package com.base.collection.hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapResizeTest {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < 1000; i++) {
            map.put(i+"x", i);
        }
    }
}
