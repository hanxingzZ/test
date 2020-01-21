package com.hx.test.question.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
	public static int lengthOfLongestSubstring(String s) {
		char[] c = s.toCharArray();
		int sum = 0;
		int start = 0;
		int end = 0;
		Map<Character, Integer> map = new HashMap<>();
		while (end < c.length) {
			if (map.containsKey(c[end])) {
				start = Math.max(start, map.get(c[end]));
			}
			sum = Math.max(sum, end - start + 1);
			map.put(c[end], end + 1);
			end++;
		}
		return sum;
	}

	public int lengthOfLongestSubstring1(String s) {
		int n = s.length(), ans = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int end = 0, start = 0; end < n; end++) {
			char alpha = s.charAt(end);
			if (map.containsKey(alpha)) {
				start = Math.max(map.get(alpha), start);
			}
			ans = Math.max(ans, end - start + 1);
			map.put(s.charAt(end), end + 1);
		}
		return ans;
	}

	public static void main(String[] args) {
		String s = "asdasd1";
		String s1 = "dvdf";
		System.out.println(lengthOfLongestSubstring(s));
		System.out.println(lengthOfLongestSubstring(s1));

	}
}
