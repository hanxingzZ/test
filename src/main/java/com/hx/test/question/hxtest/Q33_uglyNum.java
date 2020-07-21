package com.hx.test.question.hxtest;

/**
 * 
 * @description: TODO
 * @author : 韩兴(xing.han@ucarinc.com)
 * @date 创建时间：2020年6月29日 上午10:38:52
 * @version 1.0
 */
public class Q33_uglyNum {
	public int GetUglyNumber_Solution(int index) {
		int[] arr = new int[index];
		int p2 = 0;
		int p3 = 0;
		int p5 = 0;
		int t = 0;
		arr[0] = 0;
		int num = 0;
		while (t < index - 1) {
			 num = Math.min(arr[p2] * 2, Math.min(arr[p3] * 3, arr[p5] * 5));
			if (arr[p2] * 2 == num) {
				p2++;
			}
			if (arr[p3] * 3 == num) {
				p3++;
			}
			if (arr[p5] * 5 == num) {
				p5++;
			}
			arr[t++] = num;
		}
		return num;
	}
}
