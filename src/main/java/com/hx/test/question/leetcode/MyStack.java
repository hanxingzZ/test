package com.hx.test.question.leetcode;

import java.util.ArrayList;

public class MyStack {

	private ArrayList<Integer> list;

	/** Initialize your data structure here. */
	public MyStack() {
		this.list = new ArrayList<Integer>();
	}

	/** Push element x onto stack. */
	public void push(int x) {
		list.add(x);
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		if (!isIndex()) {
			throw new RuntimeException("stack is empty");
		}
		int result = list.remove(list.size() - 1);
		return result;

	}

	/** Get the top element. */
	public int top() {
		if (!isIndex()) {
			throw new RuntimeException("stack is empty");
		}
		return list.get(list.size() - 1);
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return list.isEmpty();
	}

	private boolean isIndex() {
		if (list.size() <= 0) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {

	}
}
