package com.ttyc.stream;

import com.ttyc.stream.obj.User;
import org.junit.Test;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.ttyc.stream.Source.users;
import static java.lang.System.out;

public class Intermediate {
    final Pattern pattern = Pattern.compile("/");

    /**
     * (User user)可增加可读性？
     */
    @Test
    public void testType() {
        users.stream().forEach((User user) -> {
            System.out.println(user.getName());
        });
    }

    @Test
    public void testMap() {
        Stream<String> stringStream = users.stream().map(User::getName);
        stringStream.forEach(out::println);
    }

    @Test
    public void testPeek() {
        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .forEach(out::println);

        String text = "xx";
        Optional.of(text).ifPresent(out::println);
    }

    @Test
    public void testSkip() {
        String url = "gateway/user/role-list";
        pattern.splitAsStream(url).forEach(item -> System.out.println(item));

        Long i = 200L;
        int j = 200;
        System.out.println(i.equals(j));
        System.out.println(i.equals((long)j));
        System.out.println(i == j);
        System.out.println(i.intValue() == j);
    }

    /**
     * 多字段分组求和
     */
    @Test
    public void testMultiGroup() {
        Map<User, LongSummaryStatistics> map = Source.users.stream().collect(Collectors
                .groupingBy(
                        user -> new User(user.getName(), user.getGender()),
                        Collectors.summarizingLong(user -> user.getAge())
                )
        );

        map.forEach((k,v) -> {
            k.setAge(v.getSum());
        });

        Set<User> users = map.keySet();
        users.stream().forEach(System.out::println);
    }

    /**
     * 按前缀分组
     */
    @Test
    public void testPrefixGroup() {
        List<String> list = new ArrayList<>();
        list.add("20190101_a1000123.log");
        list.add("20190101_a1020223.log");
        list.add("20190101_a1024123.log");

        list.add("20190102_a1000123.log");
        list.add("20190102_a1020223.log");

        list.add("20190103_a1024123.log");

        Map<String, List<String>> map = list.stream().collect(Collectors.groupingBy(s -> s.substring(0, s.indexOf('_')), Collectors.toList()));
        map.forEach((k, v) -> System.out.println(k + "----" + v));
    }

    /**
     * 按下标分组
     */
    @Test
    public void testIndexGroup() {
        List<String> names = Arrays.asList("Sam", "Pamela", "Dave", "Pascal", "Erik");
        List<String> list = IntStream.range(0, names.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> names.get(i))
                .collect(Collectors.toList());
        System.out.println(Arrays.toString(list.toArray(new String[list.size()])));
    }

    @Test
    public void testReduce() {
        Source.users.stream();
    }
}
