package com.hx.test.question.hxtest;

import com.hx.test.question.offer.Q3listNode.ListNode;

/**
 * 
 * @description: TODO
 * @author : 韩兴(xing.han@ucarinc.com)
 * @date 创建时间：2020年7月8日 下午1:55:09
 * @version 1.0
 */
public class Q56_deleteDuplication {
	public ListNode deleteDuplication(ListNode pHead) {
		if (pHead == null) {
			return pHead;
		}
		ListNode head = new ListNode(-999);
		head.next = pHead;
		ListNode pre = head;
		ListNode last = head.next;
		while (last != null) {
			if (last.next != null && last.val == last.next.val) {
				while (last.next != null && last.val == last.next.val) {
					last = last.next;
				}
				pre.next = last.next;
				last = last.next;
			} else {
				pre = pre.next;
				last = last.next;
			}
		}

		return head.next;
	}
}
