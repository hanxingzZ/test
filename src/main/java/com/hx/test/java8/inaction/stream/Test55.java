package com.hx.test.java8.inaction.stream;

import static java.util.Comparator.comparing;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.joining;

import com.hx.test.java8.inaction.stream.pojo.Trader;
import com.hx.test.java8.inaction.stream.pojo.Transaction;

public class Test55 {

	public void Test55() {
		System.out.println("A");
	}

	public static void main(String[] args) {
		List<Transaction> list = Utils.getTrabsactions();
		System.out.println("1.~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// 1.找出2011年发生的所有交易，并按交易额排序
		list.stream().filter(d -> d.getYear() == 2011).sorted(comparing(Transaction::getValue)).collect(toList())
				.forEach(System.out::println);

		System.out.println("2.~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// 2.交易员都在哪些不同的城市工作过
		list.stream().map(d -> d.getTrader().getCity()).distinct().collect(toList()).forEach(System.out::println);

		System.out.println("3.~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// 3.查找所有来自于剑桥的交易员，并按姓名排序。
		list.stream().map(Transaction::getTrader).filter(d -> "Cambridge".equals(d.getCity()))
				.sorted(comparing(Trader::getName)).distinct().collect(toList()).forEach(System.out::println);

		System.out.println("4.~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// 4.返回所有交易员的姓名字符串，按字母顺序排序
		String str = list.stream().map(d -> d.getTrader().getName()).distinct().sorted(String::compareToIgnoreCase)
				.collect(joining());
		System.out.println(str);

		System.out.println("5.~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// 5.有没有交易员是在米兰工作的
		boolean isExist = list.stream().map(d -> d.getTrader().getCity()).anyMatch(d -> "Milan".equals(d));
		System.out.println(isExist);

		System.out.println("6.1~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// 6.1打印生活在剑桥的交易员的所有交易额
		list.stream().filter(d -> "Cambridge".equals(d.getTrader().getCity())).map(Transaction::getValue)
				.forEach(System.out::println);

		System.out.println("6.2~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// 6.2扩展:打印生活在剑桥的交易员交易总额
		Optional<Integer> countValue = list.stream().filter(d -> "Cambridge".equals(d.getTrader().getCity()))
				.map(Transaction::getValue).reduce(Integer::sum);
		System.out.println(countValue.get());

		System.out.println("7.~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// 7.所有交易中，最高的交易额是多少
		Optional<Integer> max1 = list.stream().map(Transaction::getValue).reduce(Integer::max);
		Optional<Transaction> max2 = list.stream().max(comparing(Transaction::getValue));
		System.out.println(max1.get());
		System.out.println(max2.get());

		System.out.println("8.~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		// 8.所有交易中，最少的交易
		list.stream().sorted(comparing(Transaction::getValue)).limit(1).collect(toList()).forEach(System.out::println);
		Optional<Transaction> min1 = list.stream().reduce((d1, d2) -> d1.getValue() < d2.getValue() ? d1 : d2);
		Optional<Transaction> min2 = list.stream().min(comparing(Transaction::getValue));
		System.out.println(min1.get());
		System.out.println(min2.get());

		Integer i = 128;
		Integer j = 20;
		if (j++ <= j && i == i++) {
			System.out.println(i);
			System.out.println(j);
		}
		me(i);
		System.out.println(i);
	}

	public static void me(Integer i) {
		i = i + 10;
	}
}
