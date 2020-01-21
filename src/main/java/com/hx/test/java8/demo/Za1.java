package com.hx.test.java8.demo;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.hx.test.java8.demo.pojo.Person;


public class Za1 {
    public static void main(String[] args) {
        // String 类  只增加了一个 join 方法
        String joined = String.join("/", "join", "us", "have", "fun");
        System.out.println(joined);
        // join 还有一个重写
        // String join(CharSequence delimiter,Iterable<? extends CharSequence> elements)

        // 原始类的包装类
        // Sort Integer Long Float Double 这5类分别提供了 sum、max、min 的静态方法，供stream 来使用
        // 同样原因 Boolean 类新加 logicalAnd logicalOr logicalXor
        // Float 和 Double 增加静态方法 isFinite 如果x不是正负无穷，NaN 则返回true

        // 集合
        // 所有集合类放发都新增了 stream、parellelStream、spliterator 来生成stream
        // Collection 新增 removeIf  和filter 相反
        List<Integer> intList = Arrays.asList(6, 1, 12, 3, 15, 6, 7, 8, 22);
        // intList.removeIf(a -> a > 8); //Error
        List<Integer> integerList = new ArrayList<>(intList);
        integerList.removeIf(a -> a > 8);

        // Iterable 新增 forEach  接受一个 Consumer<? super T> action 接口
        System.out.println(" forEach sout:");
        intList.forEach(System.out::println);

        // List 新增 replaceAll ， sort
        System.out.println(" sout after sort:");
        intList.sort(Integer::compareTo);
        intList.forEach(System.out::println);

        // Map forEach replace,replaceAll,remove(key,value)，putIfAbsent,compute,computeIf,merge
        Map<String, Integer> integerMap = intList.stream()
                .collect(Collectors.toMap(a -> "s" + a, a -> a, (a, aNew) -> a));
        //forEach
        System.out.println("map forEach:");
        integerMap.forEach((key, value) -> {
            System.out.println("key:" + key);
            System.out.println("value:" + value);
        });
        //remove 只有当key value 映射成立时才会删除
        integerMap.remove("s1", 1);
        // 如果key值对应的value不存在时插入value 否则什么也不做，放发返回key值对应的value
        // 即 ： 使得我们不用写是否为null值的检测语句
        Integer s100 = integerMap.putIfAbsent("s100", 100);
        //compute 计算  一般我们很可能会有这样的计算，从map中取出值计算后再放进去，新加的compute 就是为了简化这一操作的
        integerMap.compute("s100", (key, value) -> value * 100);
        System.out.println("s100 现在的值为：" + integerMap.get("s100"));
        integerMap.computeIfAbsent("s100", key -> 1020);
        integerMap.computeIfPresent("s100", (key, value) -> value * 100);

        // merge 就不介绍了，貌似不是通常可以用到的
//        integerMap.merge("s100", 666, (a, b) -> a + b);


        //比较器  Comparator 和 thenComparing  这2中方法都可以避免原始类型的拆装箱
        List<Person> people = new ArrayList<>();
        people.sort(Comparator.comparing(Person::getGroup) //人的列表先按小组分组
                        .thenComparing(Person::getGender) // 每个小组内的人再按照性别人组
                        .thenComparing(Person::getName)); // 男人或女人内再按名字分组
        Person[] people1 = new Person[]{};
        Arrays.sort(people1,
                Comparator.comparing(Person::getGroup)
                .thenComparing(Person::getGender)
                .thenComparing(Person::getName));
        // Comparator 还有一个 nullsFirst和nullsLast 的方法
        // 如果集合内有null值不会报错而是把null当成大于或者小于正常值的值
        // 上述例子中 如果某人没有小组 或者没有性别或者没有名字 那么nullsFirst 的排序它会排在最前面
        // nullFirst 可以接受一个 naturalOrder() 反自然排序 reverseOrder()

        // java8 官方支持 Base64编码/解码 的方法了

        //读取文件
        // Files.lines 返回一个包含字符串的stream
        Path path = Paths.get("D:/test.txt");
        try {
            Stream<String> stream = Files.lines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Files.list 返回指定目录中项目的 Stream<Path> 对象

        // java8 支持重复注解，并且注解的位置放宽，可以注解类，方法，变量，甚至泛型内

        // Objects 类新增2个静态的 predicate 放发 isNull 和 nonNull
        // 在使用stream的时候很好用
        boolean aNull = Objects.isNull(1);
        boolean b = Objects.nonNull(1);

        // 延迟消息
        // logger.info(xxx)
        // 在输出日志的时候之前的做法是即使日志级别不足时也会先对消息进行格式化
        // 如果使用 lambda 表达式的话则会实现延迟的效果
        // 判断级别如果不够的话就不执行，如果够的话再执行lambda表达式，这也是lambda的特性之一

        // 正则表达式
        // java8中新加了 Matcher类下的 start、end 和group方法
    }
}
