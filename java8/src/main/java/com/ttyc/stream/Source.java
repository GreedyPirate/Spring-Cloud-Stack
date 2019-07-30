package com.ttyc.stream;

import com.ttyc.stream.obj.Group;
import com.ttyc.stream.obj.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Source {
    public static List<String> strs = new ArrayList<>();
    public static List<Integer> nums = new ArrayList<>();
    public static List<User> users = new ArrayList<>();
    public static int[] arr = {1, 4, 2, 3, 5};
    public static String str = "ac.bf.eg.hk";
    public static List<Group> groups = new ArrayList<>();


    static {
        strs.add("kim");
        strs.add("qua");
        strs.add("zra");
        strs.add("qaq");
        strs.add("set");
        strs.add("wrt");
        nums.add(-1);
        nums.add(0);
        nums.add(-5);
        User user0 = new User("jay", "male", 1, 12L);
        User user1 = new User("kim", "female", 2, 10L);
        User user2 = new User("jay", "male", 1, 24L);
        User user3 = new User("kim", "female", 2, 180L);
        User user4 = new User("kim", "female", 2, 30L);
        User user5 = new User("kim", "female", 3, 20L);

        users = Arrays.asList(user0, user1, user2, user3, user4, user5);

        List<User> group1 = Arrays.asList(user0, user1, user2);
        List<User> group2 = Arrays.asList(user3, user4, user5);

        groups.add(Group.of("group1", group1));
        groups.add(Group.of("group2", group2));

    }
}
