package com.ttyc.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Middle {
    private static List<String> strs = new ArrayList<>();
    private static List<Integer> nums = new ArrayList<>();
    private static List<User> users = new ArrayList<>();

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

    @Test
    public void testFilter(){
        String str = "kimzra";
        strs.stream().filter(str::contains).forEach(System.out::println);
    }

    @Test
    public void testSort(){
        nums.stream().sorted(Comparator.comparingInt(Integer::valueOf)).forEach(System.out::println);
    }

    @Test
    public void testMap() {
        users.stream().map(user -> user.getName()).forEach(System.out::println);
    }
}
