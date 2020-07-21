package com.hx.test.question.hhh;

import java.util.HashSet;

/**
 * 
 * @description: TODO
 * @author : 韩兴(xing.han@ucarinc.com)
 * @date 创建时间：2020年7月9日 下午3:43:48
 * @version 1.0
 */
public class Q45 {
	public boolean isC(int[] arr) {
		if (arr.length != 5) {
			return false;
		}
		HashSet<Integer> set = new HashSet<>();
		int max = -1;
		int min = 14;
		for (int i = 0; i < 5; i++) {
			int t = arr[i];
			if (t != 0) {
				if (set.contains(t)) {
					return false;
				}
				set.add(t);
				if (t > max) {
					max = t;
				}
				if (t < min) {
					min = t;
				}
			}
		}
		return max - min < 5;
	}
}
