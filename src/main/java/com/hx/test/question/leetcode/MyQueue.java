package com.hx.test.question.leetcode;

import java.util.Stack;

/**
 * 
 * @description: 用栈实现队列
 * @author : 韩兴(13039997950@163.com)
 * @date 创建时间：2019年12月30日 下午5:48:05
 * @version 1.0
 */
public class MyQueue {

	private Stack<Integer> input;
	private Stack<Integer> output;

	/** Initialize your data structure here. */
	public MyQueue() {
		input = new Stack<>();
		output = new Stack<>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		input.push(Integer.valueOf(x));
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		if (output.isEmpty()) {
			while (!input.isEmpty()) {
				output.push(input.pop());
			}
		}
		return (int) output.pop();

	}

	/** Get the front element. */
	public int peek() {
		if (output.isEmpty()) {
			while (!input.isEmpty()) {
				output.push(input.pop());
			}
		}
		return (int) output.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return input.isEmpty() && output.isEmpty();
	}

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();

		queue.push(1);
		queue.push(2);
		System.out.println(queue.peek());// 返回 1
		System.out.println(queue.pop());// 返回 1
		System.out.println(queue.empty());// 返回 false

	}

}
