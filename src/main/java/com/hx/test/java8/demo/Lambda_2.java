package com.hx.test.java8.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 方法引用
 */
public class Lambda_2 {
    /*
    * java8 新增一个运算符号 ‘::’ 双冒号
    * */

    public Lambda_2() {
        System.out.println("I'm constructor!");
    }

    public static void main(String[] args) {
        Lambda_2 lam = new Lambda_2();

        //第一种 Class::static_method
        Runnable bar = Lambda_2::bar;
        bar.run();

        //第二种 Class::new
        Runnable aNew = Lambda_2::new;
        aNew.run();
        //第二种也叫构造器引用，不限于一般的类例如
        List<Integer> ints = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9));
        ints.stream().map(int[]::new); // Stream<int[]>

        //第三种 Class::method  class 为特殊类（静态类） 且方法无参数
        /*Runnable foo = Lambda_2::foo;
        foo.run();*/

        //第四种 instance::method  实例调用的方法可以有参数，也可以没有
        List<String> strings = new ArrayList<>(Arrays.asList("I ", "like ", "work"));
        strings.forEach(lam::baz);

    }

    public static void bar() {
        System.out.println("I'm bar! I'm static.");
    }

    public void foo() {
        System.out.println("I'm foo! I'm not static.");
    }

    public void baz(String str) {
        System.out.println("I'm baz! I'm not static.I say " + str);
    }

}
