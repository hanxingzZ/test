package com.hx.test.question.hxtest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * @description: TODO
 * @author : 韩兴(xing.han@ucarinc.com)
 * @date 创建时间：2020年7月8日 上午10:15:32
 * @version 1.0
 */
public class Q54_FirstAppearingOnce {

	HashMap<Character, Integer> map = new HashMap<>();
	List<Character> list = new ArrayList<>();

	// Insert one char from stringstream
	public void Insert(char ch) {
		map.put(ch, map.getOrDefault(ch, 0) + 1);
		list.add(ch);
	}

	// return the first appearence once char in current stringstream
	public char FirstAppearingOnce() {
		for (char ch : list) {
			if (map.get(ch) == 1) {
				return ch;
			}
		}
		return '#';
	}
}
