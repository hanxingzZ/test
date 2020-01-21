package com.hx.test.question.offer;

import com.hx.test.question.util.ListNode;

/**
 * 
 * @description: 输入一个链表，输出该链表中倒数第k个结点。
 * @author : 韩兴(13039997950@163.com)
 * @date 创建时间：2019年12月8日 下午2:27:39
 * @version 1.0
 */
public class FindKthToTail {
	public static ListNode<Integer> findKthToTail(ListNode<Integer> head, int k) {
		if (head == null || k <= 0) {
			return null;
		}
		ListNode<Integer> root = head;
		for (int i = 0; i < k; i++) {
			if (head != null) {
				head = head.next;
			} else {
				return null;
			}
		}
		while (head != null && root != null) {
			root = root.next;
			head = head.next;
		}
		return root;
	}

	public static ListNode<Integer> findKthToTail1(ListNode<Integer> head, int k) {
		if (head == null || k <= 0) {
			return null;
		}
		ListNode<Integer> root = head;
		int l = 0;
		while (head != null) {
			head = head.next;
			l++;
		}
		if (l < k) {
			return null;
		}
		for (int i = 0; i < l - k; i++) {

			root = root.next;
		}
		return root;
	}

	public static void main(String[] args) {
		ListNode<Integer> node = new ListNode<>(1);
		node.next = new ListNode<>(2);
		node.next.next = new ListNode<>(3);
		node.next.next.next = new ListNode<>(4);
		node.next.next.next.next = new ListNode<>(5);
		findKthToTail(node, 5).printListNode();
		findKthToTail1(node, 5).printListNode();

	}

}
