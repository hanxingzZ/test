package com.hx.test.question.hxtest;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @description: TODO
 * @author : 韩兴(xing.han@ucarinc.com)
 * @date 创建时间：2020年6月29日 下午5:46:47
 * @version 1.0
 */
public class Q42_FindNumbersWithSum {
	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		ArrayList<Integer> list = new ArrayList<>();
		int start = 0;
		int end = array.length - 1;
		while (start < end) {
			int s = array[start] + array[end];
			if (s == sum) {
				list.add(array[start]);
				list.add(array[end]);
				return list;
			} else if (s > sum) {
				end--;
			} else {
				start++;
			}
		}

		return list;
	}

	public static int lengthOfLongestSubstring(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		int temp = 0;
		int res = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			int index = map.getOrDefault(s.charAt(i), -1);
			map.put(s.charAt(i), i);
			temp = temp < i - index ? temp + 1 : i - index;
			res = Math.max(temp, res);
		}

		return res;
		
	
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcaa"));
	}
}
