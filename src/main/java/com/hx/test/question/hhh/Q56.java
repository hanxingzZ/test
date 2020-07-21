package com.hx.test.question.hhh;

import com.hx.test.question.offer.Q3listNode.ListNode;

/**
 * 
 * @description: TODO
 * @author : 韩兴(xing.han@ucarinc.com)
 * @date 创建时间：2020年7月9日 下午3:22:12
 * @version 1.0
 */
public class Q56 {
	public ListNode deleteDup(ListNode pHead) {

		ListNode head = new ListNode(-999999);
		head.next = pHead;
		ListNode pre = head;

		while (pHead != null) {
			if (pHead.next != null && pHead.val == pHead.next.val) {
				while (pHead.next != null && pHead.val == pHead.next.val) {
					pHead = pHead.next;
				}
				pre.next = pHead.next;
				pHead = pHead.next;
			} else {
				pre = pre.next;
				pHead = pHead.next;
			}
		}

		return head.next;
	}
}
