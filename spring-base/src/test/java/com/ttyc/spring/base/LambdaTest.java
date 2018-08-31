package com.ttyc.spring.base;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaTest {
    @Test
    public void test(){
        List<String> names = new ArrayList<>();
        names.add("d");
        names.add("r");
        names.add("a");
        Collections.sort(names,(a,b)-> a.compareTo(b));
        System.out.println(names);
    }
}
