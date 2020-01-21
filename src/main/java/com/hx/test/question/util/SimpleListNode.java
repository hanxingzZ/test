package com.hx.test.question.util;

/**
 * 链表
 *
 */
public class SimpleListNode<T> {

	/**
	 * 数据域
	 */
	private T val;

	/**
	 * 指针域
	 */
	private SimpleListNode<T> next;

	/**
	 * 头结点
	 */
	private SimpleListNode<T> head;

	public SimpleListNode() {

	}

	public SimpleListNode(T a) {
		this();
		head = new SimpleListNode<T>();
		val = a;
		head.next = this;
	}

	/**
	 * 在链表尾端插入节点
	 * 
	 * @param
	 */
	public void add(T a) {
		SimpleListNode<T> node = new SimpleListNode<T>(a);

		if (head == null) {
			head = new SimpleListNode<T>();
			head.next = node.head.next;
			return;
		} else {
			SimpleListNode<T> temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = node.head.next;
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
		SimpleListNode<T> node = new SimpleListNode<T>(a);
		SimpleListNode<T> temp = head;
		while (index > 0) {
			temp = temp.next;
			index--;
		}
		SimpleListNode<T> t = new SimpleListNode<>();
		t = temp.next;
		temp.next = node;
		node.next = t;

	}

	/**
	 * 在链表尾端添加链表
	 * 
	 * @param node
	 */
	public void add(SimpleListNode<T> node) {
		if (node.head.next != null) {
			if (head == null) {
				head = new SimpleListNode<T>();
				head.next = node.head.next;

			} else {
				SimpleListNode<T> temp = head;
				while (temp.next != null) {
					temp = temp.next;
				}
				temp.next = node.head.next;
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
		SimpleListNode<T> temp = head;
		while (index >= 0) {
			temp = temp.next;
			index--;
		}
		temp.next = temp.next.next;
		return temp.val;
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
		SimpleListNode<T> temp = head;
		while (temp.next != null) {
			if (o == null) {
				if (o == temp.next.val) {
					temp.next = temp.next.next;
					return true;
				}
			} else {
				if (o.equals(temp.next.val)) {
					temp.next = temp.next.next;
					return true;
				}
			}
			temp = temp.next;
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
		return this.getListNode(index).val;
	}

	/**
	 * 修改下标的元素
	 * 
	 * @param index
	 * @param o
	 * @return
	 */
	public T set(int index, T o) {
		SimpleListNode<T> node = this.getListNode(index);
		T oldVal = node.val;
		node.val = o;
		return oldVal;
	}

	/**
	 * 返回下标的节点
	 * 
	 * @param index
	 * @return
	 */
	private SimpleListNode<T> getListNode(int index) {
		if (!isPositionIndex(index)) {
			throw new IndexOutOfBoundsException(String.valueOf(index));
		}
		SimpleListNode<T> temp = head;
		while (index >= 0) {
			temp = temp.next;
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
		SimpleListNode<T> temp = head;
		while (temp.next != null) {

			if (o == null) {
				if (o == temp.next.val) {
					return index;
				}
			} else {
				if (o.equals(temp.next.val)) {
					return index;
				}
			}
			temp = temp.next;
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
		SimpleListNode<T> temp = head;
		System.out.print("打印链表：");
		while (temp.next != null) {
			System.out.print(temp.next.val + " ");
			temp = temp.next;
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
		SimpleListNode<T> temp = head;
		while (temp.next != null) {
			temp = temp.next;
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
		SimpleListNode<T> temp = head;
		while (temp.next != null) {
			SimpleListNode<T> node = temp.next;
			temp.head = null;
			temp.val = null;
			temp.next = null;
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
	public static void printListNode(SimpleListNode<?> node) {
		if (node.head == null) {
			return;
		}
		SimpleListNode<?> temp = node.head;
		System.out.print("打印链表：");
		while (temp.next != null) {
			System.out.print(temp.next.val + " ");
			temp = temp.next;
		}
	}
}
