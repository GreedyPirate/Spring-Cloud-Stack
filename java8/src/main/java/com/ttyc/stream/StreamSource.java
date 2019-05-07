package com.ttyc.stream;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.ttyc.stream.Source.*;
import static java.lang.System.out;
/**
 *
 * 生成stream source
 * @author yangjie
 * @since 1.0.0
 * @createTime 2018/11/19
 */
public class StreamSource {
    public static final Pattern pattern = Pattern.compile("\\.");

    @Test
    public void testInit() throws FileNotFoundException {
        //集合
        IntStream stream = Arrays.stream(arr);
        Stream<Integer> streamNum = nums.stream();

        //BufferedReader
        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/com/ttyc/stream/test.txt"));
        Stream<String> streamFile = reader.lines();
        streamFile.forEach(out::println);

        IntStream intStream = IntStream.rangeClosed(0,10);
        intStream.forEach(out::println);

        Random random = new Random();
        IntStream randomStream = random.ints(10,0,10);
        randomStream.forEach(out::println);

        // 转换回Stream
        int[] ints = stream.toArray();
        List<Integer> collect = streamNum.collect(Collectors.toList());
//        ArrayList<Integer> arrayList = streamNum.collect(Collectors.toCollection(ArrayList::new));
    }

    @Test
    public void testInit2(){

        Stream<String> patternStream = pattern.splitAsStream(str);
        patternStream.forEach(out::println);

        patternStream = pattern.splitAsStream(str);
        String origin = patternStream.collect(Collectors.joining(","));
        System.out.println(origin);

        // IntStream等同于Stream<Integer>，但是装箱拆箱的耗时，所以选择IntStream
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);
        Stream<int[]> arr = Stream.of(Source.arr);
    }

}
