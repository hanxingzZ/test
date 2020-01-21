package com.hx.test.question.leetcode;

import java.util.HashSet;

import com.hx.test.question.util.ListNode;

/**
 * 
 * @description: TODO
 * @author : 韩兴(13039997950@163.com)
 * @date 创建时间：2019年12月26日 下午2:37:41
 * @version 1.0
 */
public class LinkedListHasCycle {

	// 借助set
	public static boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}
		HashSet<ListNode> set = new HashSet<>();
		while (head != null) {
			if (set.contains(head)) {
				return true;
			}
			set.add(head);
			head = head.next;
		}

		return false;
	}

	// 快慢指针
	public static boolean hasCycle1(ListNode head) {
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			head = head.next;
			if (fast == head) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);

	}

}
