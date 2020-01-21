package com.hx.test.question.leetcode;

/**
 * 
 * @description: 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * @author : 韩兴(13039997950@163.com)
 * @date 创建时间：2020年1月13日 下午3:39:06
 * @version 1.0
 */
public class IsPowerOfTwo {
	public boolean isPowerOfTwo(int n) {

		return n > 0 && (n & (n - 1)) == 0;
	}

	public static void main(String[] args) {
		IsPowerOfTwo i = new IsPowerOfTwo();
		System.out.println(i.isPowerOfTwo(6));

	}

}
