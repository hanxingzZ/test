package com.hx.test.question.offer;

import java.util.ArrayList;
import java.util.Comparator;

public class PrintMinNumber {

	public static String printMinNumber(int[] numbers) {
		if (numbers.length == 0) {
			return "";
		}
		ArrayList<Integer> list = new ArrayList<>();
		for (int a : numbers) {
			list.add(a);
		}
		list.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				String str1 = o1.toString();
				String str2 = o2.toString();

				return (str1 + str2).compareTo(str2 + str1);
			}

		});
		StringBuilder sb = new StringBuilder();
		for (int a : list) {
			sb.append(a);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		int[] arr = { 3, 32, 321 };
		System.out.println(printMinNumber(arr));

	}

}
