package com.hx.test.java8.inaction.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.hx.test.java8.inaction.stream.pojo.Dish;

public class Test53And54 {

	public static void main(String[] args) {
		List<Dish> list = Utils.getDemoDishes();

		System.out.println("1.~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// 1.匹配一个素菜
		if (list.stream().anyMatch(Dish::isVegetarian)) {
			System.out.println("有素菜！");
		}

		System.out.println("2.~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// 2.是否匹配所有低卡路里
		boolean isLow1 = list.stream().allMatch(d -> d.getCalories() < 800);
		System.out.println(isLow1);
		boolean isLow2 = list.stream().noneMatch(d -> d.getCalories() >= 800);
		System.out.println(isLow2);

		System.out.println("3.~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// 3.查找任意一个素菜
		Optional<Dish> dish1 = list.stream().filter(Dish::isVegetarian).findAny();
		System.out.println(dish1.get());

		System.out.println("4.~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// 4.查找第一个素菜 （与findAny类似，找到第一个元素的在并行上限制更多，如不关心返回哪个元素，用findAny）
		Optional<Dish> dish2 = list.stream().filter(Dish::isVegetarian).findFirst();
		System.out.println(dish2.get());

		System.out.println("5.~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// 5.求素菜的卡路里总和
		Integer i = list.stream().filter(Dish::isVegetarian).map(Dish::getCalories).reduce(0, Integer::sum);
		Optional<Integer> oi = list.stream().filter(Dish::isVegetarian).map(Dish::getCalories).reduce(Integer::sum);
		System.out.println(i);
		System.out.println(oi.get());

		System.out.println("6.~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// 6.求素菜的最大/最小卡路里
		Optional<Integer> max = list.stream().filter(Dish::isVegetarian).map(Dish::getCalories).reduce(Integer::max);
		Optional<Integer> min = list.stream().filter(Dish::isVegetarian).map(Dish::getCalories).reduce(Integer::min);
		System.out.println(max.get());
		System.out.println(min.get());

		System.out.println("7.~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// 7.求菜单上的总数
		Optional<Integer> count1 = list.stream().map(d -> 1).reduce(Integer::sum);
		long count2 = list.stream().count();
		System.out.println(count1.get());
		System.out.println(count2);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		List<Integer> list1 = Arrays.asList(1, 2, 5, 8);
		List<Integer> list2 = Arrays.asList(2, 5, 6, 7);
		list1.stream().filter(d -> list2.contains(d)).collect(Collectors.toList()).forEach(System.out::println);

	}

}
