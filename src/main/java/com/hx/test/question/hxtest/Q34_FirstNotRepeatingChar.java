package com.hx.test.question.hxtest;

import java.util.HashMap;

/**
 * 
 * @description: TODO
 * @author : 韩兴(xing.han@ucarinc.com)
 * @date 创建时间：2020年6月29日 下午2:11:44
 * @version 1.0
 */
public class Q34_FirstNotRepeatingChar {
	public int FirstNotRepeatingChar(String str) {
		char[] arr = str.toCharArray();
		HashMap<Character, Integer> map = new HashMap<>();
		for (char c : arr) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		for (int i = 0; i < arr.length; i++) {
			if (map.get(arr[i]) == 1) {
				return i;
			}
		}
		return -1;
	}
}
