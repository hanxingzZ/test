package com.hx.test.question.hhh;

import com.hx.test.question.util.ListNode;

/**
 * 
 * @description: TODO
 * @author : 韩兴(xing.han@ucarinc.com)
 * @date 创建时间：2020年7月9日 下午6:06:44
 * @version 1.0
 */
public class Q36 {
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		ListNode p1 = pHead1;
		ListNode p2 = pHead2;

		int l1 = 0;
		int l2 = 0;
		while (p1 != null) {
			p1 = p1.next;
			l1++;
		}
		while (p2 != null) {
			p2 = p2.next;
			l2++;
		}

		for (int i = 0; i < l1 - l2; i++) {
			if (l1 - l2 > 0) {
				pHead1 = pHead1.next;
			} else {
				pHead2 = pHead2.next;
			}
		}
		while (pHead1 != null) {
			if (pHead1 == pHead2) {
				return pHead1;
			}
			pHead1 = pHead1.next;
			pHead2 = pHead2.next;
		}
		return null;
	}

}
