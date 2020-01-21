package com.hx.test.question.offer;

import java.util.HashMap;

public class FirstNotRepeatingChar {
	public static int firstNotRepeatingChar(String str) {
		char[] arr = str.toCharArray();
		HashMap<Character, Integer> map = new HashMap<>(arr.length);
		for (char c : arr) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}

		}
		for (int i = 0; i < arr.length; i++) {
			if (map.get(arr[i]) == 1) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		String str = "12242552214";
		System.out.println(firstNotRepeatingChar(str));

	}

}
