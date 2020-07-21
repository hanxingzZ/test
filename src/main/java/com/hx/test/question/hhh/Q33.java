package com.hx.test.question.hhh;

/**
 * 
 * @description: TODO
 * @author : 韩兴(xing.han@ucarinc.com)
 * @date 创建时间：2020年7月9日 下午6:15:04
 * @version 1.0
 */
public class Q33 {

	public int uglyNum(int index) {
		int[] arr = new int[index];
		int p2 = 0;
		int p3 = 0;
		int p5 = 0;
		int l = 0;
		arr[0] = 0;
		int num = 0;
		while (l < index - 1) {
			num = Math.min(arr[p2] * 2, Math.min(arr[p3] * 3, arr[p5] * 5));
			if (num == arr[p2] * 2) {
				p2++;
			}
			if (num == arr[p3] * 3) {
				p3++;
			}
			if (num == arr[p5] * 5) {
				p5++;
			}
			arr[l++] = num;
		}
		return arr[index - 1];
	}
}
