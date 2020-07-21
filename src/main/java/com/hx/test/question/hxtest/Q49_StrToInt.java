package com.hx.test.question.hxtest;

/**
 * 
 * @description: TODO
 * @author : 韩兴(xing.han@ucarinc.com)
 * @date 创建时间：2020年7月7日 下午3:38:04
 * @version 1.0
 */
public class Q49_StrToInt {
	public int StrToInt(String str) {
		if (str == null || str.isEmpty()) {
			return 0;
		}
		char[] arr = str.toCharArray();
		int x = 1;
		int num = 0;
		for (int i = arr.length - 1; i > 0; i--) {
			if (!isNum(arr[i])) {
				return 0;
			}
			num += x * (arr[i] - '0');
			x *= 10;
		}
		if (arr[0] == '+') {
			return num;
		} else if (arr[0] == '-') {
			return ~num + 1;
		} else if (isNum(arr[0])) {
			return num + x * (arr[0] - '0');
		}
		
		return 0;

	}

	public boolean isNum(char c) {
		return c >= '0' && c <= '9';
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
