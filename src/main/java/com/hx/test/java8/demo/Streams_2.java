package com.hx.test.java8.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * 在一个或多个步骤中，指定将初始Stream转换为另一个Stream的中间操作
 * http://ifeve.com/stream/
 */
public class Streams_2 {

    public static void main(String[] args) {

        List<String> stringList = Arrays.asList("小明","小红");

        System.out.println("----filter  接收一个 Predicate<T> 接收T 返回 boolean");
        stringList.stream().filter(s -> s.contains("红"))
                .forEach(System.out::println);

        List<String> intList = Arrays.asList("100","3","45","54","45");
        System.out.println("----map 操作 转换");
        intList.stream().map(Integer::parseInt) // Stream<Integer>
                .forEach(System.out::println);

        List<String> words = Arrays.asList("hello","stream");
        System.out.println("----flatMap Stream<Stream<T>> to Stream<T>");
        Stream<Stream<Character>> streamStream
                = words.stream().map(Streams_2::characterStream);
        streamStream.forEach(System.out::println);
        Stream<Character> stream
                = words.stream().flatMap(Streams_2::characterStream);
        stream.forEach(System.out::println);

        System.out.println("---提取子流和组合流---");
        System.out.println("----limit 返回一个包含n个元素的新的stream 少于长度返回原始的stream");
        Stream<String> limit = intList.stream().limit(2);
        limit.forEach(System.out::println);

        System.out.println("----skip 丢弃掉前n个元素");
        Stream<String> skip = intList.stream().skip(1);
        skip.forEach(System.out::println);

        System.out.println("----concat 组合2个stream");
        Stream<String> concat = Stream.concat(intList.stream(), words.stream());

        System.out.println("----peek  每次的获取一个元素的时候都可以指定调用一个方法，便于调试");
        intList.stream().map(Integer::parseInt) // Stream<Integer>
                .peek(integer -> System.out.println("peek ->"+integer))
                .forEach(System.out::println);

        System.out.println("----distinct");
        intList.stream().distinct().forEach(System.out::println);

        System.out.println("----sorted 排序");
        intList.stream().sorted(Comparator.comparing(Integer::parseInt))
        .forEach(System.out::println);

    }

    private static Stream<Character> characterStream(String s){
        List<Character> result = new ArrayList<>();
        for (char c : s.toCharArray()) {
            result.add(c);
        }
        return result.stream();
    }
}
