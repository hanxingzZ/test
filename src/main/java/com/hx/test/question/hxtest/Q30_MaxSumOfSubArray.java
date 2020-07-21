package com.hx.test.question.hxtest;

/**
 * 
 * @description: TODO
 * @author : 韩兴(xing.han@ucarinc.com)
 * @date 创建时间：2020年6月29日 上午10:17:36
 * @version 1.0
 */
public class Q30_MaxSumOfSubArray {
	public int FindGreatestSumOfSubArray(int[] array) {
		int sum = array[0];
		int tempSum = array[0];
		for (int i = 1; i < array.length; i++) {
			tempSum = Math.max(array[i] + tempSum, array[i]);
			sum = Math.max(sum, tempSum);
		}
		return sum;
	}
}
