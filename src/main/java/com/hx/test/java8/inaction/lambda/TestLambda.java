package com.hx.test.java8.inaction.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;

public class TestLambda {

	public static void main(String[] args) {

		List list = new ArrayList<>();
		Comparator<Person> byWeight = (Person p1, Person p2) -> p1.getName().compareTo(p2.getName());
		Runnable r1 = () -> {
		};
		Lambda l = () -> 42;
		System.out.println(l);
		System.out.println(r1);
		TestLambda t = new TestLambda();
		System.out.println(t.fetch());
		List<String> str = Arrays.asList("a", "b", "A", "B");
		List<Person> list1 = Arrays.asList(new Person("g1", "1"), new Person("g2", "2"));
		str.sort(String::compareToIgnoreCase);
		str.forEach(System.out::println);
	}

	public Callable<String> fetch() {
		return () -> "Tricky example ;-)";
	}

}

interface Lambda {
	Integer haha();
}
