package com.hx.test.question.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class LargestNumber {
	public static String largestNumber(int[] nums) {

		// 慎用该方法 leetCode上的执行时间为100ms左右 上边的遍历为20ms左右
		// List<Integer> list =
		// Arrays.stream(nums).boxed().collect(Collectors.toList());
		// 自定义了一个比较器，并且直接用了list的sort方法 相当于自定义排序
		String str = Arrays.stream(nums).boxed().sorted(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				StringBuilder sb1 = new StringBuilder();
				StringBuilder sb2 = new StringBuilder();
				sb1.append(o1).append(o2);
				sb2.append(o2).append(o1);
				return sb2.toString().compareTo(sb1.toString());
			}
		}).map(String::valueOf).collect(Collectors.joining());
		return str.charAt(0) == '0' ? "0" : str;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 30, 34, 5, 9 };
		int[] arr1 = { 0, 0, 0, 0, 0 };
		System.out.println(largestNumber(arr));
		System.out.println(largestNumber(arr1));

		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		sb1.append(1).append(121);
		sb2.append(1);
		sb2.append(121);
		System.out.println(sb1);
		System.out.println(sb2);
		System.out.println(sb1.toString());
		System.out.println(sb2.toString());
	}

}
