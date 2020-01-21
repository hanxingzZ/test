package com.hx.test.question.util;

/**
 * node
 *
 */
public class Node<T> {

	/**
	 * 数据域
	 */
	private T val;

	/**
	 * 指针域
	 */
	private Node<T> next;

	public Node() {

	}

	public Node(T a) {
		this.val = a;
	}

	public T getVal() {
		return val;
	}

	public void setVal(T val) {
		this.val = val;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}
}
