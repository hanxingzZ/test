package com.hx.test.java8.demo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

/**
 * 使用一个终止操作来产生一个结果。该操作会强制它之前的延迟操作立刻执行
 * 。在这之后，该Stream就不会再被调用了
 * <p>
 * 收集结果
 */
public class Streams_4 {

    public static void main(String[] args) {
        // toArray()  默认为Object[] 可以传入构造器
        String[] strs = new String[]{"小明", "小红", "大明", "大红", "老明", "老红"};
        String[] strings = Stream.of(strs).filter(s -> s.contains("大"))
                .filter(s -> s.contains("明")).toArray(String[]::new);
        System.out.println(Arrays.toString(strings));

        // 通过collect 方法转换成
        List<String> stringList = Arrays.stream(strs).collect(Collectors.toList());
        Set<String> stringSet = Arrays.stream(strs).collect(toSet());
        Map<String, Integer> map = Arrays.stream(strs).collect(Collectors.toMap(s -> s, String::length));
        //如果想指定类型还可以通过传入构造器来指定类型
        ArrayList<String> collect = Arrays.stream(strs).collect(Collectors.toCollection(ArrayList::new));
        TreeSet<String> treeSet = Arrays.stream(strs).collect(Collectors.toCollection(TreeSet::new));
        //可以转化成一个String对象
        String string1 = Arrays.stream(strs).collect(Collectors.joining());
        //或者传入一个分隔符
        String string2 = Arrays.stream(strs).collect(Collectors.joining(","));

        //还有我们用的最多的for循环，这里可以直接使用forEach
        Arrays.stream(strs).forEach(s -> {
            s += "是个好学生";
            System.out.println(s);
        });
        Arrays.stream(strs).forEachOrdered(s -> {
            s += "是个好学生";
            System.out.println(s);
        });

        //groupingBy 分组  《写给大忙人的JAVA8》里的例子
        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        // 保留map 中重复key值的第一个值
        Map<String, String> localMap = locales.collect(Collectors.toMap(
                Locale::getDisplayLanguage,
                locale -> locale.getDisplayLanguage(locale),
                // 如果key值有重复的时候value只保留第一个
                // existingValue 上一个key值对应的value，newValue 本次执行方法时的value值
                // 比如求和 所有重复key对应的value    (existingValue,newValue)-> existingValue + newValue
                (existingValue, newValue) -> existingValue
        ));
        // 保留map 中重复key值所有的value
        Map<String, Set<String>> countryLanguageSets = Stream.of(Locale.getAvailableLocales()).collect(Collectors.toMap(
                Locale::getDisplayCountry,
                locale -> Collections.singleton(locale.getDisplayLanguage()),
                (a, b) -> {
                    Set<String> r = new HashSet<>(a);
                    r.addAll(b);
                    return r;
                }
//                , TreeMap::new   //如果要指定map的具体实现可以在第四个参数传入构造器
        ));

        // 分组  groupingBy
        Map<String, List<Locale>> countryToLocales
                = Stream.of(Locale.getAvailableLocales()).collect(Collectors.groupingBy(
                Locale::getCountry
                //      ，toSet()    如果想让返回的 value值类型是Set 默认是List
                //      counting()  value 的类型为 Long 返回收集元素的总个数
                //      summingInt(函数) 统计 value 的总和
                //      maxBy(比较器)  minBy(比较器)  比如可以返回人口最多的城市
        ));
        // partitioningBy 布尔型的分组 true 为一组 false 一组 如果可以通过真假条件来分组的话这个方法更有效率

        //mapping  这里的map1 == countryLanguageSets
        // mapping 方法会将一个函数应用到downstream结果上，并且需要另一个收集器来处理结果
        Map<String, Set<String>> map1 = Stream.of(Locale.getAvailableLocales())
                .collect(Collectors.groupingBy(
                        Locale::getDisplayCountry, //key
                        Collectors.mapping(Locale::getDisplayLanguage, Collectors.toSet())) //value
                );

        // 举例一个应用场景
        // 全国的码农按照每个省来分组 这就是第一个 groupingBy
        // 这时需要按照省内的每个城市来分组  就可以用 groupingBy 内的 mapping 来完成

        //--------------------------------------------------------------------

        // reducing 方法是个很有用的方法  以前看到的 max min cout sum 等 底层都是通过这个方法来实现
        // 只是那些方法比较常用被提到了类库中
        // 包含三种形式
        //1   reducing(binaryOperator)
        //2   reducing(identity,binaryOperator)
        //3   reducing(identity,BiFunction,binaryOperator)

        //BinaryOperator<T> 接收一个 T,T 返回 T 即二元操作
        // strs 数组以 “-” 连接  第一种 由于没有传入 identity 所以返回的是一个 Optional
        Optional<String> reduce = Stream.of(strs).reduce((a, b) -> a + "-" + b);
        // 第二种 传入了初始的 identity 返回不可能为null 所以 返回一个拼接好的 String
        String reduce1 = Stream.of(strs).reduce("", (a, b) -> a + "-" + b);
        System.out.println(reduce.get());

        List<Integer> intList = Arrays.asList(10, 2, 5, 7, 24, 54, 25);
        // sum 的实现
        Integer reduce2 = intList.stream().reduce(0, (a, b) -> a + b);
        System.out.println(reduce2);

        //第三种
        String reduce3 = Stream.of(strs).reduce(
                "",
                (s,s2) -> "[" + s + "," + s2 + "]",
                (s, s2) -> s
        );
        System.out.println(reduce3);

    }
}
