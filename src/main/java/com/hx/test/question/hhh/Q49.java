package com.hx.test.question.hhh;

/**
 * 
 * @description: TODO
 * @author : 韩兴(xing.han@ucarinc.com)
 * @date 创建时间：2020年7月9日 下午3:33:09
 * @version 1.0
 */
public class Q49 {
	public int strToInt(String str) {
		char[] arr = str.toCharArray();
		int x = 1;
		int count = 0;
		for (int i = arr.length - 1; i > 0; i++) {
			if (!isNum(arr[i])) {
				return 0;
			}
			count += (arr[i] - '0') * x;
			x *= 10;
		}
		if (arr[0] == '+') {
			return count;
		} else if (arr[0] == '-') {
			return ~count + 1;
		} else if (!isNum(arr[0])) {
			return 0;
		} else {
			return count + (arr[0] - '0') * x;
		}
	}

	public boolean isNum(char c) {

		return c >= '0' && c <= '9';
	}
}
