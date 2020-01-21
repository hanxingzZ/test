package com.hx.test.thinkinjava.chapter4;

public class Practise9 {

	public static void fib(int n) {
		StringBuilder sb = new StringBuilder();
		if (n == 0) {
			return;
		}
		if (n == 1) {
			sb.append(1);
			System.out.println(sb.toString());
			return;
		}

		sb.append("1、1、");

		int temp = 0;
		int one = 1;
		int two = 1;
		for (int i = 3; i <= n; i++) {
			temp = two + one;
			one = two;
			two = temp;
			sb.append(temp);
			sb.append("、");
		}
		if (sb.charAt(sb.length() - 1) == '、')
			sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb.toString());

	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			fib(i);
		}
	}

}
