package com.ttyc.jdk;

import java.util.HashMap;
import java.util.Map;

public class MapForeach {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("k1","v1");
        map.forEach((key, value) -> {
            System.out.println(key);
            System.out.println(value);
        });
    }
}
