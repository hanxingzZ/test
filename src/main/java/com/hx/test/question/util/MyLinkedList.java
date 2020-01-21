package com.hx.test.question.util;

/**
 * 链表
 *
 */
public class MyLinkedList<T> {

	/**
	 * 头结点
	 */
	private Node<T> head;

	public MyLinkedList() {

	}

	public MyLinkedList(T a) {
		this();
		head = new Node<T>(a);
	}

	/**
	 * 在链表尾端插入节点
	 * 
	 * @param
	 */
	public void add(T a) {
		Node<T> node = new Node<T>(a);

		if (head == null) {
			head = new Node<T>();
			head.setNext(node.getNext());
			return;
		} else {
			Node<T> temp = head;
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(node.getNext());
		}

	}

	/**
	 * 在链表指定位置插入节点
	 * 
	 * @param
	 */
	public void add(int index, T a) {
		if (!isPositionIndex(index)) {
			throw new IndexOutOfBoundsException(String.valueOf(index));
		}
		Node<T> node = new Node<T>(a);
		Node<T> temp = head;
		while (index > 0) {
			temp = temp.getNext();
			index--;
		}
		Node<T> t = new Node<>();
		t = temp.getNext();
		temp.setNext(node);
		node.setNext(t);

	}

	/**
	 * 在链表尾端添加链表
	 * 
	 * @param node
	 */
	public void add(Node<T> node) {
		if (node.getNext() != null) {
			if (head == null) {
				head = new Node<T>();
				head.setNext(node.getNext());

			} else {
				Node<T> temp = head;
				while (temp.getNext() != null) {
					temp = temp.getNext();
				}
				temp.setNext(node.getNext());
			}
		}

	}

	/**
	 * 通过下标移除元素
	 * 
	 * @param index
	 * @return
	 */

	public T remove(int index) {
		if (!isPositionIndex(index)) {
			throw new IndexOutOfBoundsException(String.valueOf(index));
		}
		Node<T> temp = head;
		while (index >= 0) {
			temp = temp.getNext();
			index--;
		}
		temp.setNext(temp.getNext().getNext());
		return temp.getVal();
	}

	/**
	 * 移除链表中第一次出现的o
	 * 
	 * @param o
	 * @return
	 */
	public boolean remove(T o) {
		if (head == null) {
			return false;
		}
		Node<T> temp = head;
		while (temp.getNext() != null) {
			if (o == null) {
				if (o == temp.getNext().getVal()) {
					temp.setNext(temp.getNext().getNext());
					return true;
				}
			} else {
				if (o.equals(temp.getNext().getVal())) {
					temp.setNext(temp.getNext().getNext());
					return true;
				}
			}
			temp = temp.getNext();
		}

		return false;
	}

	/**
	 * 返回下标的元素
	 * 
	 * @param index
	 * @return
	 */
	public T get(int index) {
		return this.getListNode(index).getVal();
	}

	/**
	 * 修改下标的元素
	 * 
	 * @param index
	 * @param o
	 * @return
	 */
	public T set(int index, T o) {
		Node<T> node = this.getListNode(index);
		T oldVal = node.getVal();
		node.setVal(o);
		return oldVal;
	}

	/**
	 * 返回下标的节点
	 * 
	 * @param index
	 * @return
	 */
	private Node<T> getListNode(int index) {
		if (!isPositionIndex(index)) {
			throw new IndexOutOfBoundsException(String.valueOf(index));
		}
		Node<T> temp = head;
		while (index >= 0) {
			temp = temp.getNext();
			index--;
		}
		return temp;
	}

	/**
	 * 返回元素第一次出现的下标
	 * 
	 * @param index
	 * @return
	 */
	public int get(T o) {

		if (head == null) {
			return -1;
		}
		int index = 0;
		Node<T> temp = head;
		while (temp.getNext() != null) {

			if (o == null) {
				if (o == temp.getNext().getVal()) {
					return index;
				}
			} else {
				if (o.equals(temp.getNext().getVal())) {
					return index;
				}
			}
			temp = temp.getNext();
			index++;
		}
		return -1;
	}

	/**
	 * 打印当前链表
	 */
	public void printListNode() {
		if (head == null) {
			return;
		}
		Node<T> temp = head;
		System.out.print("打印链表：");
		while (temp.getNext() != null) {
			System.out.print(temp.getNext().getVal() + " ");
			temp = temp.getNext();
		}
	}

	/**
	 * 链表长度
	 * 
	 * @return
	 */
	public int length() {
		int count = 0;
		if (head == null) {
			return count;
		}
		Node<T> temp = head;
		while (temp.getNext() != null) {
			temp = temp.getNext();
			count++;
		}
		return count;
	}

	/**
	 * 清空链表
	 */
	public void clear() {
		if (head == null) {
			return;
		}
		Node<T> temp = head;
		this.head = null;
		while (temp.getNext() != null) {
			Node<T> node = temp.getNext();
			temp.setVal(null);
			temp.setNext(null);
			temp = node;
		}
	}

	/**
	 * 判断输入地址是否是有效的
	 * 
	 * @param index
	 * 
	 */
	private boolean isPositionIndex(int index) {
		if (index < 0 || index > this.length()) {
			return false;
		}
		return true;

	}

	/**
	 * 是一个静态util方法，用来打印非当前链表，由于目前方法较少未单独成包
	 */
	public static void printListNode(MyLinkedList<?> node) {
		if (node.head == null) {
			return;
		}
		Node<?> temp = node.head;
		System.out.print("打印链表：");
		while (temp.getNext() != null) {
			System.out.print(temp.getNext().getVal() + " ");
			temp = temp.getNext();
		}
	}

}
