package com.hx.test.java8.inaction.stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Math.sqrt;

import com.hx.test.java8.inaction.stream.pojo.Dish;

public class Test56And57 {

	public static void main(String[] args) {
		List<Dish> list = Utils.getDemoDishes();
		System.out.println("1.~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// 1.获取总卡路里（验证intStream）
		int sum = list.stream().mapToInt(Dish::getCalories).sum();
		System.out.println(sum);

		System.out.println("2.1~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// 2.勾股数1
		Stream<int[]> stream = IntStream
				.rangeClosed(1, 100)
				.boxed()
				.flatMap(
						a -> IntStream.rangeClosed(a, 100).filter(b -> sqrt(a * a + b * b) % 1 == 0)
								.mapToObj(b -> new int[] { a, b, (int) sqrt(a * a + b * b) }));
		stream.limit(5).forEach(d -> {
			for (int a : d) {
				System.out.print(a + " ");
			}
			System.out.println();
		});

		System.out.println("2.2~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// 2.勾股数2
		Stream<double[]> stream1 = IntStream
				.rangeClosed(1, 100)
				.boxed()
				.flatMap(
						a -> IntStream.rangeClosed(a, 100).mapToObj(b -> new double[] { a, b, sqrt(a * a + b * b) })
								.filter(d -> d[2] % 1 == 0));
		stream1.limit(5).forEach(d -> {
			for (double a : d) {
				System.out.print((a / 1) + " ");
			}
			System.out.println();
		});

		System.out.println("3.~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// 3.数组和值创建流
		Stream<String> str1 = Stream.of("java8", "in", "Action");
		str1.map(String::toUpperCase).forEach((a) -> {
			System.out.println(a);
		});
		int sum1 = Arrays.stream(new int[] { 1, 2, 3, 546, 2323, 547657 }).sum();
		System.out.println(sum1);
		Stream<Object> str2 = Stream.empty();
		str2.forEach(System.out::println);

		System.out.println("4.1~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// 4.创建无限流1
		Stream<Integer> str41 = Stream.iterate(0, t -> t + 2);
		str41.limit(10).forEach(d -> {
			System.out.print(d + " ");
		});

		System.out.println();
		System.out.println("4.2~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// 4.无限流2 斐波那契
		Stream.iterate(new int[] { 0, 1 }, t -> new int[] { t[1], t[0] + t[1] }).limit(20).map(d -> d[1])
				.forEach(d -> {
					System.out.print(d + " ");
				});

		System.out.println();
		System.out.println("4.3~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// 4.无限流3 generate （前两个为iterate）
		Stream.generate(Math::random).limit(5).forEach(System.out::println);
		Random r = new Random();
		Supplier<Integer> random = new Supplier<Integer>() {
			@Override
			public Integer get() {
				int i = r.nextInt(100);
				System.out.println(i);
				return i;
			}
		};
		Set<Integer> set = Stream.generate(random).collect(Collectors.toSet());
		System.out.println(set);
	}
}
