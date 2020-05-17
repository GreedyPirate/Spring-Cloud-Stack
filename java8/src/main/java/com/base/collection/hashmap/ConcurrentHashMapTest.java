package com.base.collection.hashmap;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        map.put("s1", 1);

        Integer s1 = map.get("s1");
    }


}
