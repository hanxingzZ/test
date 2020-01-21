package com.hx.test.question.offer;

import java.util.HashSet;

public class Continuous {
	public static boolean isContinuous(int[] numbers) {
		if (numbers.length < 5) {
			return false;
		}
		int max = -1;
		int min = 14;
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < 5; i++) {
			if (set.contains(numbers[i]) && numbers[i] != 0) {
				return false;
			}
			set.add(numbers[i]);
			if (min > numbers[i] && numbers[i] != 0) {
				min = numbers[i];
			}
			if (max < numbers[i] && numbers[i] != 0) {
				max = numbers[i];
			}
		}
		if ((max - min) > 5) {
			return false;
		}
		return true;

	}

	public static int Sum_Solution(int n) {
		int res = 0;
		boolean b = n > 0 && (res += Sum_Solution(n - 1) + n) > 0;

		return res;
	}

	public static int multi(int a, int b) {
		int res = 0;
		boolean boo = ((a & 1) == 1) && (res += b) > 0;
		a >>= 1;
		b <<= 1;
		boolean boo1 = (a > 0) && (res += multi(a, b)) > 0;
		return res;
	}

	public static int add(int num1, int num2) {
		while (num1 != 0) {
			int temp = num1 ^ num2;
			num1 = (num1 & num2) << 1;
			num2 = temp;
		}
		return num2;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 7, 0 };
		// System.out.println(isContinuous(arr));
		// System.out.println(Sum_Solution(5));
		System.out.println(multi(5, 5));
		System.out.println(add(522, 2));

	}

}
