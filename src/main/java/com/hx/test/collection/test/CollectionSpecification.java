package com.hx.test.collection.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class CollectionSpecification {

	public static void main(String[] args) {
		// 1. ArrayList的subList结果不可强转成ArrayList，否则会抛出ClassCastException
		List<Integer> q1list1 = new ArrayList<>();
		q1list1.add(1);
		q1list1.add(1);
		q1list1.add(2);
		System.out.println("q1~~1:" + q1list1.subList(0, 2).get(1));
		System.out.println(q1list1.size());
		q1list1.remove(1);
		System.out.println(q1list1.size());
		/*
		// System.out.println("q1~~2:" + ((ArrayList<Integer>)
		// q1list1.subList(0, 2)).get(1));// 此处抛出异常

		// 2. 使用集合转数组的方法，必须使用集合的 toArray(T[] array)，传入的是类型完全一样的数组，大小就是
		// list.size()。直接使用 toArray 无参方法存在问题，此方法返回值只能是 Object[]类，若强转其它类型数组将出现
		// ClassCastException 错误。
		List<String> q2list1 = new ArrayList<>(2);
		q2list1.add("hx1");
		q2list1.add("hx2");
		String[] array = new String[q2list1.size()];// 长度大于list的部分为null
		array = q2list1.toArray(array);
		for (String s : array) {
			System.out.println("q2~~" + s);
		}
		// String[] q2array= (String[]) q2list1.toArray();//此处抛出异常

		// 3.使用工具类 Arrays.asList()把数组转换成集合时，不能使用其修改集合相关的方法，它的 add/remove/clear
		// 方法会抛出 UnsupportedOperationException 异常。asList 的返回对象是一个 Arrays内部类，
		// 并没有实现集合的修改方法。Arrays.asList体现的是适配器模式，只是转换接口，后台的数据仍是数组
//		Integer[] q3arr = new Integer[10];
//		for (int i = 0; i < q3arr.length; i++) {
//			q3arr[i] = i;
//		}
		List<Integer> q3list1 = Arrays.asList(q3arr);
//		System.out.println("qqqq~" + q3list1.get(9));
//		q3arr[9] = 100;
		System.out.println("qqqq~~" + q3list1.get(9));// 此处变为100
		// q3list1.add(1); 此处会抛出异常
		// 4.不要在 foreach 循环里进行元素的 remove/add 操作。remove 元素请使用
		// Iterator方式，如果并发操作，需要对 Iterator 对象加锁。
		List<String> q4list1 = new ArrayList<>();
		q4list1.add("1");
		q4list1.add("1");
		q4list1.add("2");
		Iterator<String> iterator = q4list1.iterator();
		synchronized (iterator) {
			
		}
		while (iterator.hasNext()) {
			String item = iterator.next();
			if ("1".equals(item)) {
				iterator.remove();
			}
		} // ~~~正确使用方式

		// System.out.println("q4~~1:" + q4list1.size());
		// for (String item : q4list1) {
		// if ("2".equals(item)) {
		// System.out.println(item);
		// q4list1.remove(item);
		// }
		// } // ~~~错误使用方式 java.util.ConcurrentModificationException
		// 迭代器方式也不能用list.remove
		// System.out.println("q4~~2:" + q4list1.size());

		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			System.out.println("math" + Math.round(Math.random() * 100));
			System.out.println("Random" + r.nextInt(100));
		}*/
	}
}
