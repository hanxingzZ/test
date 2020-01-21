package com.hx.test.question.leetcode;

/**
 * 
 * @description: 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * @author : 韩兴(13039997950@163.com)
 * @date 创建时间：2019年12月7日 下午2:11:39
 * @version 1.0
 */
public class Count1 {

	public static int count(int n) {

		int count = 0;
		while (n != 0) {
			count++;
			n = n & (n - 1);
		}

		return count;
	}

	public static int count1(int n) {
		int count = 0;
		while (n != 0) {
			if ((n & 1) == 1) {
				count++;
			}
			n = n >> 1;
		}
		return count;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			System.out.println(count(i) + "~~~~~~~~~" + count1(i));
		}

	}

}
