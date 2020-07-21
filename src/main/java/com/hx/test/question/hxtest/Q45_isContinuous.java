package com.hx.test.question.hxtest;

import java.util.HashSet;

/**
 * 
 * @description: TODO
 * @author : 韩兴(xing.han@ucarinc.com)
 * @date 创建时间：2020年7月7日 上午11:24:38
 * @version 1.0
 */
public class Q45_isContinuous {
	public boolean isContinuous(int[] numbers) {
		if (numbers.length < 5) {
			return false;
		}
		HashSet<Integer> set = new HashSet<>();
		int min = 14;
		int max = -1;
		for (int i = 0; i < numbers.length - 1; i++) {
			if (numbers[i] != 0) {
				// 不能重复
				if (set.contains(numbers[i])) {
					return false;
				}
				set.add(numbers[i]);
				if (max < numbers[i]) {
					max = numbers[i];
				}
				if (min > numbers[i]) {
					min = numbers[i];
				}
			}
		}
		return max - min < 5;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
