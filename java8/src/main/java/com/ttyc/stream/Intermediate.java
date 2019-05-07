package com.ttyc.stream;

import org.junit.Test;

import java.util.Optional;
import java.util.stream.Stream;

import static com.ttyc.stream.Source.users;
import static java.lang.System.out;

public class Intermediate {

    @Test
    public void testMap() {
        Stream<String> stringStream = users.stream().map(Source.User::getName);
        stringStream.forEach(out::println);

        users.stream().forEach(out::println);
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
}
