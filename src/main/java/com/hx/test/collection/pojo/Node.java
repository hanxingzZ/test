package com.hx.test.collection.pojo;

public class Node<T> {
	private T data;// 数据
	private Node<T> next;// 指针

	public Node() {
		this.data = null;
		this.next = null;
	}

	public Node(T data) {
		this.data = data;
		this.next = null;
	}

	public void setNext(Node<T> t) {
		this.next = t;
	}

	public T getData() {
		return this.data;
	}

	public Node<T> getNext() {
		return this.next;
	}

}