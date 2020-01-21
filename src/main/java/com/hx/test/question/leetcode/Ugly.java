package com.hx.test.question.leetcode;

public class Ugly {
	public static boolean isUgly(int num) {
		if (num <= 0 || num == 1) {
			return num == 1;
		}
		while (num % 2 == 0 || num % 3 == 0 || num % 5 == 0) {
			if (num % 2 == 0) {
				num /= 2;
			}
			if (num % 3 == 0) {
				num /= 3;
			}
			if (num % 5 == 0) {
				num /= 5;
			}
		}
		return num == 1;
	}

	public static void main(String[] args) {
		System.out.println(isUgly(-1000));

	}

}
