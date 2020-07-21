package com.hx.test.question.hhh;

/**
 * 
 * @description: TODO
 * @author : 韩兴(xing.han@ucarinc.com)
 * @date 创建时间：2020年7月9日 下午3:29:39
 * @version 1.0
 */
public class Q50 {
	public static boolean duplicate(int numbers[], int length, int[] duplication) {
		if (numbers == null || length == 0) {
			return false;
		}
		for (int i = 0; i < numbers.length; i++) {
			int index = numbers[i] % length;
			if (numbers[index] >= length) {
				duplication[0] = index;
				return true;
			} else {
				numbers[index] += length;
			}
		}

		return false;
	}
}
