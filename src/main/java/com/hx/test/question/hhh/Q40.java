package com.hx.test.question.hhh;

/**
 * 
 * @description: TODO
 * @author : 韩兴(xing.han@ucarinc.com)
 * @date 创建时间：2020年7月9日 下午4:12:33
 * @version 1.0
 */
public class Q40 {
	public int[] findNum(int[] arr) {
		int t = arr[0];
		for (int i = 1; i < arr.length; i++) {
			t ^= arr[i];
		}
		t &= -t;
		int[] res = new int[2];
		for (int i = 0; i < arr.length; i++) {
			if ((t & arr[i]) == 1) {
				res[0] ^= arr[i];
			} else {
				res[1] ^= arr[i];
			}
		}
		return res;
	}
}
