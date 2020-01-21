package com.hx.test.question.leetcode;

/**
 * 
 * @description: 幂函数
 * @author : 韩兴(13039997950@163.com)
 * @date 创建时间：2019年12月7日 下午4:13:04
 * @version 1.0
 */
public class MyPower {

	public static double power(double x, int n) {
		if (n == 0) {
			return 1;
		}
		if (x == 1) {
			return 1;
		}
		long n1 = n;
		if (n1 < 0) {
			x = 1 / x;
			n1 = -n1;
		}
		double sum = 1;

		while (n1 != 0) {
			if ((n1 & 1) == 1) {
				sum *= x;
			}
			x *= x;
			n1 >>= 1;
		}
		return sum;
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(power(2, 11));
		long end = System.currentTimeMillis();
		System.out.println(start - end);

	}

	public static double power1(double x, int n) {
		int n1 = n;
		if (n < 0) {
			n1 = -n1;
			x = 1 / x;
		}
		double sum = 1;
		while (n1 != 0) {
			if ((n1 & 1) == 1) {
				sum *= x;
			}
			x *= x;
			n1 <<= 1;
		}
		return sum;
	}

}
