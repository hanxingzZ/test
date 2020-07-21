package com.hx.test.question.hxtest;

/**
 * 
 * @description: TODO
 * @author : 韩兴(xing.han@ucarinc.com)
 * @date 创建时间：2020年7月7日 上午10:18:58
 * @version 1.0
 */
public class Q43_LeftRotateString {
	public static String LeftRotateString(String str, int n) {
		if (str == null || str.isEmpty() || n < 0) {
			return str;
		}
		char[] arr = str.toCharArray();
		n %= arr.length;
		// xy=abcdef x=abc y=def
		// x'=cba y'=fed x'y' = cdafed
		// (x'y')' = defadc 即 yx
		reverse(arr, 0, n - 1);
		reverse(arr, n, arr.length - 1);
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
		System.out.println(LeftRotateString("abc2dfsdA2131234def", 12));
	}

}
