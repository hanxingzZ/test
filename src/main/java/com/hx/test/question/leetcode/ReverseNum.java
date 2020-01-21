package com.hx.test.question.leetcode;

public class ReverseNum {

	public static int reverse(int x) {
		long result = 0;
		while (x != 0) {
			result = result * 10 + x % 10;
			x /= 10;
		}
		if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
			return 0;
		}
		return (int) result;
	}

	public static void main(String[] args) {

		char c = '1';

		System.out.println((int) c);

	}
}
