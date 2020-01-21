package com.hx.test.java8.demo;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 函数式接口
 */
public class Lambda_1 {

	/*
	 * 等同于 private Comparator<Integer> comparator2 = (a,b)->{
	 * Integer.compare(a,b); }; 其中 Comparator.comparingInt(a -> a) 中的 a -> a
	 * 为lambda的函数表达式 而此时接收这个表达式的方法就叫做函数式接口
	 */
	private Comparator<Integer> comparator2 = Comparator.comparingInt(a -> a);

	// Function<T,R> T为接收参数类型，R为返回类型
	public String functionMethod(Integer num, Function<Integer, String> function) {
		return function.apply(num);
	}

	// Consumer<T> T为接收参数类型，无返回
	public void consumerMethod(Integer num, Consumer<Integer> consumer) {
		consumer.accept(num);
	}

	public static void main(String[] args) {
		Lambda_1 lam = new Lambda_1();

		Function<Integer, String> function = (Integer num) -> "this is function ! return " + num;
		System.out.println(lam.functionMethod(100, function));

		Consumer<Integer> consumer = (Integer num) -> System.out.println("this is consumer! return " + num);
		lam.consumerMethod(200, consumer);
	}

}
