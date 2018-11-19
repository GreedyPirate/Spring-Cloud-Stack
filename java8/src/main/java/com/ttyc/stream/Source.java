package com.ttyc.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

public class Source {
    public static List<String> strs = new ArrayList<>();
    public static List<Integer> nums = new ArrayList<>();
    public static List<User> users = new ArrayList<>();
    public static int[] arr = {1,4,2,3,5};
    public static String str = "ac.bf.eg.hk";

    @Data
    @AllArgsConstructor
    class User{
        private String name;
    }

    @Before
    public void init() {
        strs.add("kim");
        strs.add("qua");
        strs.add("zra");
        nums.add(-1);
        nums.add(0);
        nums.add(-5);
        users.add(new User("jay"));
        users.add(new User("uber"));
    }
}
