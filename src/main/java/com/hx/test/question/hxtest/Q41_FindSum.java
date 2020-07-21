package com.hx.test.question.hxtest;

import java.util.ArrayList;

/**
 * 
 * @description: TODO
 * @author : 韩兴(xing.han@ucarinc.com)
 * @date 创建时间：2020年6月29日 下午4:56:43
 * @version 1.0
 */
public class Q41_FindSum {
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		int start = 1;
		int end = 2;
		while (start < end) {
			int temp = (start + end) * (end - start + 1) / 2;
			if (temp == sum) {
				ArrayList<Integer> list = new ArrayList<>();
				for (int i = start; i <= end; i++) {
					list.add(i);
				}
				result.add(list);
				start++;
			} else if (temp < sum) {
				end++;
			} else {
				start++;
			}
		}
		return result;
	}
}
