package com.hx.test.question.offer;

import java.util.Stack;

/**
 * 
 * @description: 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * @author : 韩兴(13039997950@163.com)
 * @date 创建时间：2019年12月5日 下午7:04:59
 * @version 1.0
 */
public class TwoStack2Queue {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public void push(int node) {
		stack1.add(node);
	}

	public int pop() {
		if (stack1.size() < 1) {
			throw new RuntimeException("queue为空！");
		}
		while (stack1.size() > 0) {
			stack2.push(stack1.pop());
		}
		int t = stack2.pop();
		while (stack2.size() > 0) {
			stack1.push(stack2.pop());
		}
		return t;
	}

	public static void main(String[] args) {
		TwoStack2Queue queue = new TwoStack2Queue();
		queue.push(1);
		queue.push(2);
		System.out.println(queue.pop());
		queue.push(3);
		queue.push(4);
		queue.push(5);
		for (int i = 0; i < 5; i++) {
			System.out.println(queue.pop());
		}

	}

}
