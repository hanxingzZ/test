package com.hx.test.question.hxtest;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * 
 * @description: TODO
 * @author : 韩兴(xing.han@ucarinc.com)
 * @date 创建时间：2020年6月29日 上午9:58:54
 * @version 1.0
 */
public class Q29_MinKthNum {

	public static ArrayList<Integer> fun(int[] arr, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();

		for (int a : arr) {
			if (queue.size() < k) {
				queue.offer(a);
			} else if (queue.peek() > a) {
				queue.poll();
				queue.offer(a);
			}
		}
		return (ArrayList<Integer>) queue.stream().collect(Collectors.toList());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
