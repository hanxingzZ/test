package com.hx.test.question.offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 倒序输出链表
 *
 */
public class Q3listNode {

	public static class ListNode {
		public int val;
		public ListNode next = null;

		public ListNode(int val) {
			this.val = val;
		}

		@Override
		public String toString() {
			return "ListNode [val=" + val + ", next=" + next + "]";
		}

	}

	public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> list = new ArrayList<>();
		if (listNode == null) {
			return list;
		}
		Stack<Integer> stack = new Stack<>();
		while (listNode != null) {
			stack.push(listNode.val);
			listNode = listNode.next;
		}
		while (!stack.isEmpty()) {
			list.add(stack.pop());
		}
		return list;

	}

	public static ListNode mergeList(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;

		if (l2 == null)
			return l1;
		ListNode curr = new ListNode(-999);
		ListNode root = curr;
		System.out.println(root);
		while (l1 != null && l2 != null) {

			if (l1.val < l2.val) {
				curr.next = l1;
				curr = curr.next;
				l1 = l1.next;
			} else {
				curr.next = l2;
				curr = curr.next;
				l2 = l2.next;
			}

			if (l1 != null) {
				curr.next = l1;
			}
			if (l2 != null) {
				curr.next = l2;
			}

		}
		return root.next;
	}

	public static void main(String[] args) {
//		ListNode ln = new ListNode(1);
//		ln.next = new ListNode(3);
//		ln.next.next = new ListNode(5);
//		ln.next.next.next = new ListNode(7);
//		ListNode ln1 = new ListNode(2);
//		ln1.next = new ListNode(4);
//		ln1.next.next = new ListNode(6);
//		ln1.next.next.next = new ListNode(8);
//		// System.out.println(printListFromTailToHead(ln));
//		System.out.println(mergeList(ln, ln1));
		Map map = new HashMap();
		map.put("1", "1");

	}

}
