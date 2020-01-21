package com.hx.test.question.offer;

import java.util.HashSet;
import java.util.Iterator;

public class FindNumsAppearOnce {

	public static void findNumsAppearOnce(int[] array, int num1[], int num2[]) {
		HashSet<Integer> set = new HashSet<>();
		for (int a : array) {
			if (!set.contains(a)) {
				set.add(a);
			} else {
				set.remove(a);
			}
		}
		Iterator<Integer> iterator = set.iterator();
		int index = 0;
		while (iterator.hasNext()) {
			if (index == 0) {
				num1[0] = iterator.next();
			} else {
				num2[0] = iterator.next();
			}
			index++;

		}
		System.out.println(num1[0]);
		System.out.println(num2[0]);
	}

	public static void findNumsAppearOnce1(int[] array, int num1[], int num2[]) {
		int t = array[0];
		for (int i = 1; i < array.length; i++) {
			t ^= array[i];
		}
		// 获取最后一位1
		// t &= -t;
		t &= ~(t - 1);
		System.out.println(t);
		for (int i = 0; i < array.length; i++) {
			if ((t & array[i]) == 0) {
				num1[0] ^= array[i];
			} else {
				num2[0] ^= array[i];
			}
		}
		System.out.println(num1[0]);
		System.out.println(num2[0]);
	}

	public static void main(String[] args) {
		int[] array = { 1, 1, 2, 3, 5, 3 };
		int[] num1 = new int[1];
		int[] num2 = new int[1];
		// findNumsAppearOnce(array, num1, num2);
		findNumsAppearOnce1(array, num1, num2);

	}

}
