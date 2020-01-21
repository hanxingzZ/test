package com.hx.test.question.leetcode;

import com.hx.test.question.offer.Q3listNode.ListNode;

public class TwoNumbers {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return l1 == null ? l2 : l1;
		}
		ListNode temp = l1;
		ListNode pre = null;
		while (temp != null && l2 != null) {
			temp.val += l2.val;
			pre = temp;
			temp = temp.next;
			l2 = l2.next;
		}
		//如果temp先走完，用temp的前驱节点pre连接l2
		if (temp == null) {
			pre.next = l2;
		}
		temp = l1;
		while (temp != null) {
			if (temp.val >= 10) {
				if (temp.next != null) {
					//获取进位
					temp.next.val += temp.val / 10;
				} else {
					temp.next = new ListNode(temp.val / 10);
				}
				//获取当前节点值
				temp.val %= 10;
			}
			temp = temp.next;
		}
		return l1;
	}

	public static void main(String[] args) {
		// 342 + 465 = 807
		// ListNode l1 = new ListNode(2);
		// l1.next = new ListNode(4);
		// l1.next.next = new ListNode(3);
		// ListNode l2 = new ListNode(5);
		// l2.next = new ListNode(6);
		// l2.next.next = new ListNode(4);
		// System.out.println(JSON.toJSONString(addTwoNumbers(l1, l2)));
		//
		// ListNode l3 = new ListNode(5);
		// ListNode l4 = new ListNode(5);
		// System.out.println(JSON.toJSONString(addTwoNumbers(l3, l4)));
		// ListNode l5 = new ListNode(9);
		// l5.next = new ListNode(8);
		// ListNode l6 = new ListNode(1);
		// System.out.println(JSON.toJSONString(addTwoNumbers(l5, l6)));
		// [0,8,6,5,6,8,3,5,7]
		// [6,7,8,0,8,5,8,9,7]
		int[] arr1 = { 8, 6, 5, 6, 8, 3, 5, 7 };
		int[] arr2 = { 7, 8, 0, 8, 5, 8, 9, 7 };
		ListNode l1 = new ListNode(0);
		ListNode l2 = new ListNode(6);
		ListNode temp1 = l1;
		ListNode temp2 = l2;
		for (int a : arr1) {
			temp1.next = new ListNode(a);
			temp1 = temp1.next;
		}
		for (int a : arr2) {
			temp2.next = new ListNode(a);
			temp2 = temp2.next;
		}
		System.out.println(1);
		System.out.println(addTwoNumbers(l1, l2));
	}

}
