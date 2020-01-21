package com.hx.test.java8.inaction.stream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.summingInt;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;

import com.hx.test.java8.inaction.stream.pojo.Dish;

public class Test62And63And64 {

	public static void main(String[] args) {
		List<Dish> list = Utils.getDemoDishes();
		System.out.println("1.~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// 1.总热量
		int calories = list.stream().collect(summingInt(Dish::getCalories));
		System.out.println(calories);
		// 工厂方法
		IntSummaryStatistics caloriess = list.stream().collect(summarizingInt(Dish::getCalories));
		// IntSummaryStatistics{count=9, sum=4200, min=120, average=466.666667,
		// max=800}
		System.out.println(caloriess);
		System.out.println(caloriess.getMax());

		System.out.println("2.~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// 2.连接菜单名
		String shortMenu = list.stream().map(Dish::getName).collect(joining(", "));
		System.out.println(shortMenu);
		// String shortMenu1 = list.stream().collect(joining());

		System.out.println("3.1~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// 3.1根据type分组
		Map<Dish.Type, List<Dish>> a = list.stream().collect(groupingBy(Dish::getType));
		a.forEach((d, t) -> {
			System.out.print(d + ": ");
			System.out.println(t);
		});

		System.out.println("3.2~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// 3.2根据热量分组
		Map<CaloricLevel, List<Dish>> a1 = list.stream().collect(groupingBy(Dish::groupByCalories));
		System.out.println("~~");
		a1.forEach((d, t) -> {
			System.out.print(d + ": ");
			System.out.println(t);
		});

		System.out.println("4~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// 4.根据type和热量多级分组分组
		Map<Dish.Type, Map<CaloricLevel, List<Dish>>> m = list.stream().collect(
				groupingBy(Dish::getType, groupingBy(Dish::groupByCalories)));
		m.forEach((d, t) -> {
			System.out.print(d + ": ");
			System.out.println(t);
		});

		System.out.println("5~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// 5. 查找每个type最高热量
		Map<Dish.Type, Dish> a5 = list.stream().collect(
				groupingBy(Dish::getType, collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));

		a5.forEach((d, t) -> {
			System.out.print(d + ": ");
			System.out.println(t);
		});

		System.out.println("6~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// 6.素菜分区，二级用type
		Map<Boolean, Map<Dish.Type, List<Dish>>> a6 = list.stream().collect(
				partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));
		a6.forEach((d, t) -> {
			System.out.print(d + ": ");
			System.out.println(t);
		});

		System.out.println("7~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// 7.质数流
		Map<Boolean, List<Integer>> a7 = IntStream.rangeClosed(2, 100).boxed()
				.collect(partitioningBy(Test62And63And64::isPrime));

		a7.forEach((d, t) -> {
			System.out.print(d + ": ");
			System.out.println(t);
			System.out.println(t.stream().count());
		});
	}

	public static boolean isPrime(int candidate) {
		int candidateRoot = (int) Math.sqrt((double) candidate);
		return IntStream.rangeClosed(2, candidateRoot).noneMatch(i -> candidate % i == 0);
	}

	public enum CaloricLevel {
		DIET, NORMAL, FAT
	}
}
