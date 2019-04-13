package com.ttyc.stream;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMap {

    @Test
    public void testMapConvert() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 0);
        map.put("b", 3);
        map.put("c", 3);

        Map<String, Integer> newMap = map.entrySet().stream().collect(Collectors.toMap(entry -> entry.getKey(), entry -> {
            if (entry.getValue() > 1) {
                return 1;
            }
            return 0;
        }));

        newMap.forEach((k, v) -> {
            System.out.println(k + "----" + v);
        });
    }
}
