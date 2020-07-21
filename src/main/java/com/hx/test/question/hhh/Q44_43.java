package com.hx.test.question.hhh;

/**
 * 
 * @description: TODO
 * @author : 韩兴(xing.han@ucarinc.com)
 * @date 创建时间：2020年7月9日 下午3:48:35
 * @version 1.0
 */
public class Q44_43 {
	public static String ReverseSentence(String str) {
		if (str == null || str.isEmpty()) {
			return str;
		}
		char[] arr = str.toCharArray();
		reverse(arr, 0, arr.length - 1);
		int last = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == ' ') {
				reverse(arr, last, i - 1);
				last = i + 1;
			}
		}
		reverse(arr, last, arr.length - 1);

		return new String(arr);
	}

	private static void reverse(char[] arr, int start, int end) {
		while (start < end) {
			arr[start] ^= arr[end];
			arr[end] ^= arr[start];
			arr[start] ^= arr[end];
		}
	}

	public static String leftStr(String str, int k) {
		if (str == null || str.isEmpty() || k < 0) {
			return str;
		}
		k = k % str.length();
		char[] arr = str.toCharArray();
		reverse(arr, 0, k - 1);
		reverse(arr, k, arr.length - 1);
		reverse(arr, 0, arr.length - 1);
		return new String(arr);
	}
}
