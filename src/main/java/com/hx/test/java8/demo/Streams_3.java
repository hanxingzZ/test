package com.hx.test.java8.demo;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 使用一个终止操作来产生一个结果。该操作会强制它之前的延迟操作立刻执行
 * 。在这之后，该Stream就不会再被调用了
 * <p>
 * 简单的聚合方法
 * <p>
 */
public class Streams_3 {

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(10, 2, 5, 7, 24, 54, 25);

        System.out.println("----count 返回stream的元素总数");
        Stream<Integer> stream = intList.stream();

        //Error
        long count = stream.count();
        System.out.println(count);
        // 与 Collections.size 相等
        int size = intList.size();

        /* 原始类型流
         intStream 是原始类型的 stream 这个流中存放的是 int 型数据
         原始数据的流只有 IntStream LongStream DoubleStream 三种
         存放 short char byte boolean 数据使用 IntStream
         float 使用 DoubleStream
         */
        IntStream intStream = intList.stream().mapToInt(a -> a);
        System.out.println("intStream.sum() :" + intStream.sum());
//        System.out.println("intStream.max() :"+intStream.max()); //Exception
//        System.out.println("intStream.min() :"+intStream.min());

        // IntSummaryStatistics
        IntSummaryStatistics iss = intList.stream()
                .mapToInt(a -> a).summaryStatistics();
        System.out.println("iss.getAverage() :" + iss.getAverage());
        System.out.println("iss.getCount() :" + iss.getCount());
        System.out.println("iss.getMax() : " + iss.getMax());
        System.out.println("iss.getMin() : " + iss.getMin());
        System.out.println("iss.getSum() : " + iss.getSum());

        System.out.println("---- max min 返回集合内的最大值与最小值");
        // 聚合放发返回的是一个 Optional 对象
        // 这里的 max 和 min 可以传入一个lambda 表达式来对数据进行一些处理
        Optional<Integer> max = intList.stream().max(Integer::compareTo);
        System.out.println("max: " + max.get());
        Optional<Integer> min = intList.stream().min(Integer::compareTo);
        System.out.println("min: " + min.get());

        // findxxx
        System.out.println("---- findFirst 返回非空集合的第一个值 可以与filter结合使用");
        Optional<Integer> first = intList.stream().findFirst();
        System.out.println(first.get());
        System.out.println("---- findAny");

        // 这个方法在对流进行并行执行的时候很有效，
        // 在任何片段中发现了第一个匹配的元素都会直接返回，结束整个计算
        // 经常与filter 一起使用
        Optional<Integer> any = intList.stream()
                .filter(a -> a > 10).findAny();
        System.out.println(any.get());

        // anyMatch 判断流内是否包含匹配的元素
        boolean anyMatch = intList.stream().anyMatch(a -> a > 10 && a < 50);
        System.out.println("intList 中是否包含大于10小于50的数字：" + anyMatch);
//        List<String> strings;
//        for (String string : strings) {
//            System.out.println(string);
//        }
    }
}
