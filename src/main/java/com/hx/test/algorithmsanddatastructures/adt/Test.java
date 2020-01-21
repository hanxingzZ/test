package com.hx.test.algorithmsanddatastructures.adt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Test {
	public static <T> void test(List<T> list) {
		T tmp;
		System.out.println(list.getClass().getName());
		long start = System.currentTimeMillis(); // ForEach
		for (T s : list) {
			tmp = s;
		}
		System.out.println("foreach 花费:" + (System.currentTimeMillis() - start));
		start = System.currentTimeMillis();
		for (Iterator<T> it = list.iterator(); it.hasNext();) {
			tmp = it.next();
		}
		System.out.println("Iterator 花费:" + (System.currentTimeMillis() - start));
		start = System.currentTimeMillis();
		int size = list.size();
		for (int i = 0; i < size; i++) {
			tmp = list.get(i);
		}
		System.out.println("for 花费:" + (System.currentTimeMillis() - start));
	}

	public static void main(String[] args) {
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new LinkedList<>();
		for (int i = 0; i < 100000; i++) {
			list1.add("字符串" + String.valueOf(i));
			list2.add("字符串" + String.valueOf(i));

		}
		test(list1);
		test(list2);

	}

}
