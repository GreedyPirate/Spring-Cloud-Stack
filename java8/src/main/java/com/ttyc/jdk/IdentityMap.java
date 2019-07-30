package com.ttyc.jdk;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityMap {

    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        Map<String, Integer> identityMap = new IdentityHashMap<> ();

        hashMap.put(new String("A"),1);
        hashMap.put(new String("A"),2);
        System.out.println("hashMap = " + hashMap.size()); // 1

        identityMap.put(new String("A"),1);
        identityMap.put(new String("A"),2);
        System.out.println("identityMap = " + identityMap.size()); // 2
    }
}
