package com.hx.test.java8.demo;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

/**
 * 创建 Stream 的方法
 */
public class Streams_1 {

    public static void main(String[] args) {

        // Collection接口中新添加了 stream 放发，可以将任何集合转化为一个Stream
        // list to stream
        List<String> list = Arrays.asList("list","String");
        Stream<String> listStream = list.stream();
        // set to stream
        Set<String> set = new HashSet<>();
        Stream<String> setStream = set.stream();

         //数组类型  可以通过静态的 Stream.of() 放发来创建
        String[] strings = new String[]{"1","2"};
        Stream<String> strings1 = Stream.of(strings);
        // 或者
        Stream<String> stringStream = Stream.of("1", "2");
        Stream<? extends Serializable> stream = Stream.of(1, 2, 3, "2", 100L);

        //创建一个空的 Stream
        Stream<Object> empty = Stream.empty();

        //创建无限stream
        // generate  接收一个 Supplier<T>
        Stream<String> generate = Stream.generate(() -> "supplier");
        Stream<Double> generate1 = Stream.generate(Math::random);
        // iterate  接收一个 UnaryOperator<T>
        Stream<Integer> iterate = Stream.iterate(0, n -> n);

        // 还有很多其他很多方法来创建 Stream ...

        Path path = Paths.get("D:/test.txt");
        try {
            // 读取文件后可以直接转化为 Stream 流
            Stream<String> lines = Files.lines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
