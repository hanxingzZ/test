package com.hx.test.java8.inaction.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.hx.test.java8.inaction.stream.pojo.Dish;

public class Test51And52 {

	public static void main(String[] args) {
		List<Dish> list = Utils.getDemoDishes();
		System.out.println("1.~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// 1.获取热量大于300的前三菜肴
		List<String> names1 = list.stream().filter(d -> {
			System.out.println("filter " + d.getName());
			return d.getCalories() > 600;
		}).limit(4).map(d -> {
			System.out.println("mapping " + d.getName());
			return d.getName();
		}).collect(Collectors.toList());

		names1.forEach(System.out::println);
		System.out.println("2.~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// 2.单词字母去重s
		String[] str = { "Goodbye", "World", "hey boy!", "you are very good." };
		Stream<String> s1 = Arrays.stream(str);
		List<String> code = s1.map(d -> d.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
		code.forEach(d -> {
			System.out.print(d + " ");
		});
		System.out.println("3.~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// 测试5.2 1 平方数
		Integer[] nums = { 1, 2, 3, 4, 5 };
		Stream<Integer> s2 = Arrays.stream(nums);
		List<Integer> nums2 = s2.map(d -> (d * d)).collect(Collectors.toList());
		nums2.forEach(System.out::println);
		System.out.println("4.~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// 测试5.2 2 两个集合的组合
		List<Integer> l1 = Arrays.asList(1, 2, 3);
		List<Integer> l2 = Arrays.asList(3, 4);
		List<Object> arrl = l1.stream().flatMap(i -> l2.stream().map(j -> new int[] { i, j }))
				.collect(Collectors.toList());
		arrl.forEach(d -> {
			for (int a : (int[]) d) {
				System.out.print(a + " ");
			}
			System.out.println();
		});
		arrl.forEach(d -> {
			Arrays.stream((int[]) d).forEach(System.out::print);

			System.out.println();
		});
		System.out.println("5.~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// 测试5.2 3 两个集合的组合进阶，必须是两个数相加为3的倍数
		List<Object> arr2 = l1.stream()
				.flatMap(i -> l2.stream().filter(j -> (i + j) % 3 == 0).map(j -> new int[] { i, j }))
				.collect(Collectors.toList());
		arr2.forEach(d -> {
			for (int a : (int[]) d) {
				System.out.print(a + " ");
			}
			System.out.println();
		});
		System.out.println("6.~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

	}
}
