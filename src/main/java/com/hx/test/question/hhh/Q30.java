package com.hx.test.question.hhh;

/**
 * 
 * @description: TODO
 * @author : 韩兴(xing.han@ucarinc.com)
 * @date 创建时间：2020年7月9日 下午6:22:50
 * @version 1.0
 */
public class Q30 {
	public int sumSubArray(int[] arr) {

		int temp = arr[0];
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			temp = Math.max(temp + arr[i], arr[i]);
			max = Math.max(temp, max);
		}
		return max;
	}
}
