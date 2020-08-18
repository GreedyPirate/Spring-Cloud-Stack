package com.base.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);

        Map<String, Integer> map = new HashMap<>();
        map.put("key", 1);

        ConcurrentMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put("k1", 1);
        concurrentMap.put("k1", 2);
    }
}
