package com.hx.test.question.hhh;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @description: TODO
 * @author : 韩兴(xing.han@ucarinc.com)
 * @date 创建时间：2020年7月9日 下午4:02:23
 * @version 1.0
 */
public class Q42 {
	public List<Integer> findSum(int[] arr, int sum) {
		List<Integer> list = new ArrayList<Integer>();
		int start = 0;
		int end = arr.length - 1;
		while (start < end) {
			if (sum == arr[start] + arr[end]) {
				list.add(arr[start]);
				list.add(arr[end]);
				return list;
			} else if (sum > arr[start] + arr[end]) {
				end--;
			} else {
				start++;
			}
		}
		return list;
	}
}
