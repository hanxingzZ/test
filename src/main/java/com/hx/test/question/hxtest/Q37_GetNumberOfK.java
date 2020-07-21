package com.hx.test.question.hxtest;

/**
 * 
 * @description: TODO
 * @author : 韩兴(xing.han@ucarinc.com)
 * @date 创建时间：2020年6月29日 下午2:56:59
 * @version 1.0
 */
public class Q37_GetNumberOfK {
	public int GetNumberOfK(int[] array, int k) {

		int l = 0;
		int r = array.length - 1;
		int temp = -88;

		while (l <= r) {
			int mid = (l + r) / 2;
			if (array[mid] == k) {
				temp = mid;
				break;
			} else if (array[mid] > k) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}

		if (temp == -88) {
			return 0;
		}

		int count = 1;
		int lt = temp;
		while (lt > 0) {
			if (array[--lt] != k) {
				break;
			}
			count++;
		}

		int rt = temp;
		while (rt < array.length - 1) {
			if (array[++rt] != k) {
				break;
			}
			count++;
		}

		return count;
	}
}
