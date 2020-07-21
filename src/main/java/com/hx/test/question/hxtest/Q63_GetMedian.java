package com.hx.test.question.hxtest;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * @description: TODO
 * @author : 韩兴(xing.han@ucarinc.com)
 * @date 创建时间：2020年7月8日 下午5:47:42
 * @version 1.0
 */
public class Q63_GetMedian {
	/** 较小的一组数 用大顶堆 */
	PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
	/** 较大的一组数 用小顶堆 */
	PriorityQueue<Integer> min = new PriorityQueue<>();
	int count = 0;

	public void Insert(Integer num) {
		if ((count & 1) == 0) {
			max.offer(num);
			min.offer(max.poll());
		} else {
			min.offer(num);
			max.offer(min.poll());
		}
		count++;
	}

	public Double GetMedian() {
		if ((count & 1) == 0) {
			return (max.peek() + min.peek()) / 2.0;
		}
		return (double) min.peek();
	}
}
