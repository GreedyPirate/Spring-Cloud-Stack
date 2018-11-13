package com.ttyc.jdk;

import com.ttyc.jdk.assist.SuperUser;
import com.ttyc.jdk.assist.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListArray {
    public static void main(String[] args) {
        String[] arr = {"a","b"};
        List<String> list = Arrays.asList(arr);
        arr[0] = "xx";
        System.out.println(list.get(0));

        try {
            list.add("c");
        } catch (UnsupportedOperationException e) {
            List<String> copy = new ArrayList<>(list);
            copy.add("c");
            copy.stream().forEach(System.out::println);
        }

        List<? extends User> users = new ArrayList<>();
        SuperUser superUser = new SuperUser();
//        users.add(superUser);
    }
}
