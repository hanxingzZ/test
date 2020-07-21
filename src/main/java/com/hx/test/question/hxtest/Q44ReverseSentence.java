package com.hx.test.question.hxtest;

/**
 * 
 * @description: TODO
 * @author : 韩兴(xing.han@ucarinc.com)
 * @date 创建时间：2020年7月7日 上午10:46:35
 * @version 1.0
 */
public class Q44ReverseSentence {
	public static String ReverseSentence(String str) {
		if (str == null || str.isEmpty()) {
			return str;
		}
		char[] arr = str.toCharArray();
		int index = 0;
		int end = 0;
		for (int i = 0; i < str.length(); i++) {
			if (arr[i] == ' ') {
				reverse(arr, index, i - 1);
				index = i + 1;
			}
			end++;
		}
		reverse(arr, index, end - 1);
		reverse(arr, 0, arr.length - 1);

		return new String(arr);
	}

	private static void reverse(char[] arr, int s, int e) {
		while (s < e) {
			arr[s] ^= arr[e];
			arr[e] ^= arr[s];
			arr[s] ^= arr[e];
			s++;
			e--;
		}
	}

	public static void main(String[] args) {
		System.out.println(ReverseSentence("student. a am I"));

	}

}
