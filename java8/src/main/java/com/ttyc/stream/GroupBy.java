package com.ttyc.stream;

import com.sun.tools.javac.util.List;
import org.junit.Test;

import java.util.Map;
import java.util.TreeSet;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toCollection;

public class GroupBy {

    @Test
    public void test(){
        List<String> strings = List.of("a", "bb", "cc", "ddd");
        Map<Integer, TreeSet<String>> result = strings.stream()
                .collect(groupingBy(String::length, toCollection(TreeSet::new)));
        System.out.println(result); // {1=[a], 2=[bb, cc], 3=[ddd]}
    }
}
