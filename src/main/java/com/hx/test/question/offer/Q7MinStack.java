package com.hx.test.question.offer;

import java.util.ArrayList;
import java.util.Stack;

public class Q7MinStack {

	private int min = Integer.MAX_VALUE;

	private ArrayList<Integer> list = new ArrayList<>();

	private Stack<Integer> stack = new Stack<>();

	public void push(int node) {
		stack.push(node);
		if (node < min) {
			list.add(node);
			min = node;
		} else {
			list.add(min);
		}

	}

	public void pop() {
		if (!stack.isEmpty()) {
			stack.pop();
			list.remove(list.size()-1);
			min = list.get(list.size()-1);
		}
	}

	public int top() {
		return stack.peek();

	}

	public int min() {
		return min;
	}

	public static void main(String[] args) {
		Q7MinStack stack = new Q7MinStack();
		stack.push(3);
		System.out.println(stack.min());
		stack.push(-1);
		stack.push(1);
		stack.push(-3);
		stack.push(4);
		stack.push(-7);
		stack.push(-1);
		System.out.println(stack.list.toString());
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.list.toString());
		System.out.println(stack.min());
		
	}

}
