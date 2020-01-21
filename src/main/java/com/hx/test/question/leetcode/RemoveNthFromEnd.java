package com.hx.test.question.leetcode;

import com.hx.test.question.util.ListNode;

public class RemoveNthFromEnd {
	public static ListNode<Integer> removeNthFromEnd(ListNode<Integer> head, int n) {
		ListNode<Integer> list1 = head;

		// list2 记录head的头结点位置
		ListNode<Integer> list2 = head;

		// 先让list1走n步
		for (int i = 0; i < n; i++) {
			list1 = list1.next;
		}
		// 因为题中表明n均有效，所以此种情况删除的就是链表中第一个元素
		if (list1 == null) {
			return head.next;
		}
		// 再让list1和head同时跑直到list1为null
		while (list1.next != null) {
			list1 = list1.next;
			head = head.next;
		}
		// 此时list2的下一个节点为要删除的节点，删除即可
		head.next = head.next.next;
		return list2;
	}

	public static ListNode<Integer> removeNthFromEnd1(ListNode<Integer> head, int n) {
		ListNode<Integer> list1 = head;
		ListNode<Integer> list2 = head;
		int l = 0;
		while (list1 != null) {
			list1 = list1.next;
			l++;
		}
		System.out.println(l);
		if (l == n) {
			return head.next;
		}
		for (int i = 0; i < l - n - 1; i++) {
			head = head.next;
		}
		head.next = head.next.next;
		return list2;
	}

	// public static ListNode<Integer> removeNthFromEnd2(ListNode<Integer> head,
	// int n) {
	// ListNode<Integer> list1 = head;
	// ListNode<Integer> list2 = head;
	// int l = 0;
	// while (list1 != null) {
	// list1 = list1.next;
	// l++;
	// }
	// if (l == n) {
	// return head.next;
	// }
	// for (int i = 0; i <= l - n; i++) {
	// head = head.next;
	// }
	// head.next=head.next.next;
	// return list2;
	// }
	public static void main(String[] args) {
		ListNode<Integer> ln = new ListNode<Integer>(1);
		ln.next = new ListNode<>(2);
		ln.next.next = new ListNode<>(3);
		ln.next.next.next = new ListNode<>(4);
		ln.next.next.next.next = new ListNode<>(5);

		// removeNthFromEnd(ln, 2).printListNode();
		removeNthFromEnd1(ln, 2).printListNode();
		ListNode<Integer> ln1 = new ListNode<Integer>(1);
		if (removeNthFromEnd(ln1, 1) != null || removeNthFromEnd1(ln1, 1) != null) {
			ListNode.printListNode(removeNthFromEnd(ln1, 1));
			ListNode.printListNode(removeNthFromEnd1(ln1, 1));
		}

		ListNode<Integer> ln2 = new ListNode<Integer>(1);
		ln2.next = new ListNode<>(2);
		removeNthFromEnd(ln2, 2).printListNode();
		ListNode<Integer> ln3 = new ListNode<Integer>(1);
		ln3.next = new ListNode<>(2);
		removeNthFromEnd1(ln3, 1).printListNode();

	}

}
