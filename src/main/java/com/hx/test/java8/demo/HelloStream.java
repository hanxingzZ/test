package com.hx.test.java8.demo;




import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import com.hx.test.java8.demo.pojo.User;
import com.hx.test.java8.demo.pojo.UserDao;

/**
 * 一个初步的印象
 */
public class HelloStream {

    public static void main(String[] args) {
        UserDao userDao = getUserDao();
        List<Long> ids = Arrays.asList(1L, 2L, 3L, 4L);

        ids.stream()// Stream<Long>
                .map(userDao::getById) // Stream<User>
                .map(User::getName) // Stream<String>
                .forEach(System.out::println);
        System.out.println("--------------------------");

        List<Integer> nums = Arrays.asList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);
        System.out.println("sum is:" +
                nums.stream().filter(Objects::nonNull).
                distinct().mapToInt(num -> num * 2).
                peek(System.out::println).skip(2).limit(4).sum());


    }

    private static UserDao getUserDao() {
        List<User> users = Arrays.asList(
                new User(1L, "小红"),
                new User(2L, "小明"),
                new User(3L, "小刚"),
                new User(4L, "小林")
        );
        // List to Map
        Map<Long, User> userMap = users.stream()
                .collect(Collectors.toMap(User::getId, u -> u));
        return new UserDao(userMap);
    }
}
