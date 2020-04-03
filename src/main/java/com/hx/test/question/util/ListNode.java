package com.hx.test.question.util;

/**
 * 
 * @description: 工具类
 * @author : 韩兴(xing.han@ucarinc.com)
 * @date 创建时间：2020年1月20日 上午11:00:55
 * @version 1.0
 */
public class ListNode<T> {
	public T val;
	public ListNode<T> next;

	public ListNode(T x) {
		this.val = x;
	}

	/**
	 * 是一个静态util方法，用来打印非当前链表，由于目前方法较少未单独成包
	 */
	public static void printListNode(ListNode<?> node) {
		if (node == null) {
			return;
		}
		ListNode<?> temp = node;
		System.out.print("打印链表：");
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
	}

	/**
	 * 打印当前链表
	 */
	public void printListNode() {

		ListNode<T> temp = this;
		System.out.print("打印链表：");
		while (temp.next != null) {
			System.out.print(temp.next.val + " ");
			temp = temp.next;
		}
	}
}
