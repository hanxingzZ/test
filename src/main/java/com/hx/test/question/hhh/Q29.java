package com.hx.test.question.hhh;

import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 
 * @description: TODO
 * @author : 韩兴(xing.han@ucarinc.com)
 * @date 创建时间：2020年7月9日 下午6:26:08
 * @version 1.0
 */
public class Q29 {

	public List<Integer> minKthNum(int[] arr, int k) {
		PriorityQueue<Integer> list = new PriorityQueue<>();
		for (int i = 0; i < arr.length; i++) {
			if (list.size() < k) {
				list.offer(arr[i]);
			} else if (list.peek() > arr[i]) {
				list.poll();
				list.offer(k);
			}
		}
		return list.stream().collect(Collectors.toList());
	}
}
