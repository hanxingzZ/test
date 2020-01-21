package com.hx.test.question.leetcode;

import java.util.HashMap;

/**
 * 
 * @description: 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 
 *               示例 1:
 * 
 *               输入: s = "anagram", t = "nagaram" 输出: true
 * 
 * @author : 韩兴(13039997950@163.com)
 * @date 创建时间：2020年1月2日 上午11:32:23
 * @version 1.0
 */
public class IsAnagram {
	public static boolean isAnagram(String s, String t) {
		char[] cs = s.toCharArray();
		char[] ts = t.toCharArray();
		HashMap<Character, Integer> map1 = new HashMap<>();
		HashMap<Character, Integer> map2 = new HashMap<>();
		for (char c : cs) {
			map1.put(c, map1.getOrDefault(c, 0) + 1);
		}
		for (char c : ts) {
			map2.put(c, map2.getOrDefault(c, 0) + 1);
		}
		return map1.equals(map2);
	}

	public static boolean isAnagram1(String s, String t) {
		char[] cs = s.toCharArray();
		char[] ts = t.toCharArray();
		int[] is = new int[26];
		int[] it = new int[26];

		for (char c : cs) {
			is[c - 'a']++;
		}
		for (char c : ts) {
			it[c - 'a']++;
		}

		for (int i = 0; i < 26; i++) {
			if (is[i] != it[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isAnagram("abs", "sba"));
	}

}
