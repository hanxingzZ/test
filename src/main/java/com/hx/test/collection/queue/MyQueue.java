package com.hx.test.collection.queue;

import com.hx.test.collection.pojo.Node;



/**
 * Description: 用单链表实现队列
 *
 * @author xing.han
 * 
 */
public class MyQueue<T> {

	private Node<T> head;
	private Node<T> tail;

	public MyQueue() {
		head = null;
		tail = null;
	}

	//入队
	public boolean inQueue(T t) {
		Node<T> p = new Node<T>(t);
		if (head == null) {
			head = p;
			tail = p;
		} else {
			tail.setNext(p);
			tail = p;
		}
		return true;
	}

	//出队
	public T outQueue() {
		if (head == null) {
			return null;
		} else {
			T t = head.getData();
			head = head.getNext();
			return t;
		}
	}

	//查队头
	public T peek() {
		if (head == null)
			return null;
		else
			return head.getData();
	}

	// 判空
	public boolean isEmpty() {
		return head == null;
	}

}
