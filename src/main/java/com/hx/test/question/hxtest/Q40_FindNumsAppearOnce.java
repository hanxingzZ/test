package com.hx.test.question.hxtest;

/**
 * 
 * @description: TODO
 * @author : 韩兴(xing.han@ucarinc.com)
 * @date 创建时间：2020年6月29日 下午3:23:06
 * @version 1.0
 */
public class Q40_FindNumsAppearOnce {
	public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		int t = array[0];
		for (int i = 1; i < array.length - 1; i++) {
			t ^= array[i];
		}
		int count = t & (-t);
		for (int i = 0; i < array.length - 1; i++) {
			if ((count & array[i]) == 1) {
				num1[0] ^= array[i];
			} else {
				num2[0] ^= array[i];
			}
		}

	}
}
