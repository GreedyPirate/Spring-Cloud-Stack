package com.base.collection.hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapNullTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put(null , 1);

        map.put("s1", 0);

        Integer s1 = map.get("s1");
        System.out.println("s1 = " + s1);
    }
}
