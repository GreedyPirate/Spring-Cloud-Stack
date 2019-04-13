package com.ttyc.stream;

import com.ttyc.stream.obj.User;

import java.util.ArrayList;
import java.util.List;

public class Source {
    public static List<String> strs = new ArrayList<>();
    public static List<Integer> nums = new ArrayList<>();
    public static List<User> users = new ArrayList<>();
    public static int[] arr = {1,4,2,3,5};
    public static String str = "ac.bf.eg.hk";


    static  {
        strs.add("kim");
        strs.add("qua");
        strs.add("zra");
        strs.add("qaq");
        strs.add("set");
        strs.add("wrt");
        nums.add(-1);
        nums.add(0);
        nums.add(-5);
        users.add(new User("jay","male",1,12L));
        users.add(new User("jay","male",1,24L));
        users.add(new User("kim","female",2,10L));
        users.add(new User("kim","female",2,20L));
        users.add(new User("kim","female",2,30L));
        users.add(new User("kim","female",3,40L));
    }
}
