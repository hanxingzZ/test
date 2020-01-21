package com.hx.test.question.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * @description: 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * @author : 韩兴(13039997950@163.com)
 * @date 创建时间：2019年12月31日 下午5:09:51
 * @version 1.0
 */
public class FindKthLargest {
	public static int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int a : nums) {
			if (queue.size() < k) {
				queue.offer(a);
			} else if (queue.peek() < a) {
				queue.poll();
				queue.offer(a);
			}
		}

		return queue.peek();
	}

	public static int findKthS(int[] nums, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
		});
		for (int a : nums) {
			if (queue.size() < k) {
				queue.offer(a);
			} else if (queue.peek() > a) {
				queue.poll();
				queue.offer(a);
			}
		}

		return queue.peek();
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 10, 5, 6, 7 };
		System.out.println(findKthLargest(arr, 8));
		System.out.println(findKthS(arr, 8));

	}

}
