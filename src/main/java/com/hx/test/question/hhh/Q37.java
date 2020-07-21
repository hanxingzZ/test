package com.hx.test.question.hhh;

/**
 * 
 * @description: TODO
 * @author : 韩兴(xing.han@ucarinc.com)
 * @date 创建时间：2020年7月9日 下午5:41:12
 * @version 1.0
 */
public class Q37 {
	public int countK(int[] arr, int k) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int index = -1;
		int s = 0;
		int e = arr.length - 1;
		while (s < e) {
			int mid = s + (s + e) / 2;
			if (k == arr[mid]) {
				index = mid;
				break;
			} else if (k > arr[mid]) {
				s = mid;
			} else {
				e = mid;
			}

		}
		if (index == -1) {
			return 0;
		}
		int count = 1;
		int l1 = index - 1;
		while (l1 >= 0) {
			if (arr[l1] != arr[index]) {
				break;
			}
			count++;
			l1--;
		}
		int l2 = index + 1;
		while (l2 < arr.length) {
			if (arr[l2] != arr[index]) {
				break;
			}
			count++;
			l2++;
		}
		return count;

	}
}
