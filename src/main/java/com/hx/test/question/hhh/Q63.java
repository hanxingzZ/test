package com.hx.test.question.hhh;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * @description: TODO
 * @author : 韩兴(xing.han@ucarinc.com)
 * @date 创建时间：2020年7月9日 下午2:07:37
 * @version 1.0
 */
public class Q63 {
	// 小顶堆 存较大一堆数
	PriorityQueue<Integer> max = new PriorityQueue<>();
	// 大顶堆 较小的数
	PriorityQueue<Integer> min = new PriorityQueue<>(Comparator.reverseOrder());
	int count = 0;

	public void insert(int num) {
		if ((count & 1) == 0) {
			min.offer(num);
			max.offer(min.poll());
		} else {
			max.offer(num);
			min.offer(max.poll());
		}
		count++;
	}

	public double getMid() {
		if ((count & 1) == 0) {
			return (max.peek() + min.peek()) / 2.0;
		}
		return max.peek();
	}
}
