package com.hx.test.question.offer;

import java.util.HashSet;

import com.hx.test.question.offer.Q3listNode.ListNode;

public class FindFirstCommonNode {
	public static ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		HashSet<ListNode> set = new HashSet<>();
		while (pHead1 != null) {
			set.add(pHead1);
			pHead1 = pHead1.next;
		}
		while (pHead2 != null) {
			if (set.contains(pHead2)) {
				return pHead2;
			}
			pHead2 = pHead2.next;
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
