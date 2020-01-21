package com.hx.test.question.offer;

/**
 * 
 * @description: 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * @author : 韩兴(13039997950@163.com)
 * @date 创建时间：2019年12月5日 下午7:34:14
 * @version 1.0
 */
public class Fibonacci {

	public static int fib1(int n) {
		if (n <= 2) {
			return n == 0 ? n : 1;
		}
		int one = 1;
		int two = 1;
		int temp = 0;
		for (int i = 3; i <= n; i++) {
			temp = one + two;
			one = two;
			two = temp;
		}
		return temp;
	}

	public static int fib2(int n) {
		if (n <= 2) {
			return n == 0 ? n : 1;
		}
		return fib2(n - 1) + fib2(n - 2);
	}

	public static int fib3(int n) {
		return fib3(1, 1, n);
	}

	private static int fib3(int i, int j, int n) {
		if (n <= 2) {
			return n == 0 ? n : 1;
		}
		if (n == 3) {
			return i + j;
		}

		return fib3(j, j + i, n - 1);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(fib1(i) + "~~~" + fib2(i) + "~~~~~~" + fib3(i));
		}

	}

}
