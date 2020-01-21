package com.hx.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;

public class TestListSort {

	public static void main(String[] args) {
		List<Person> list = new ArrayList<>();
		list.add(new Person(20, 1, 1));
		list.add(new Person(21, 2, 1));
		list.add(new Person(19, 3, 2));
		list.add(new Person(18, 6, 2));
		list.add(new Person(16, 7, 1));
		list.add(new Person(23, 4, 3));
		list.add(new Person(17, 8, 3));
		System.out.println("list" + list.toString());
		List<Person> list1 = list
				.stream()
				.sorted(Comparator.comparing(Person::getType).reversed().thenComparing(Person::getAge)
						.thenComparing(Person::getId).reversed()).collect(Collectors.toList());
		System.out.println("result" + list.toString());
		list.sort(Comparator.comparing(Person::getType).reversed().thenComparing(Person::getAge)
				.thenComparing(Person::getId).reversed());
		System.out.println("result1" + list.toString());
		list.sort(Comparator.comparing(Person::getType).reversed().thenComparing(Person::getAge)
				.thenComparing(Comparator.comparing(Person::getId).reversed()));
		System.out.println("result2" + list.toString());

	}

}

@Data
@AllArgsConstructor
class Person {
	Integer age;
	Integer id;
	Integer type;

}