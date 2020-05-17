package com.base.collection.hashmap;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("s1", 1);

        Integer s1 = map.get("s1");
        System.out.println("s1 = " + s1);
    }
}

@Data
class Bean {
    private int no;

    private String name;
}
