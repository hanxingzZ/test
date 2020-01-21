package com.hx.test.question.offer;

import com.hx.test.question.util.ListNode;

/**
 * 
 * @description: TODO
 * @author : 韩兴(13039997950@163.com)
 * @date 创建时间：2019年12月8日 下午3:28:59
 * @version 1.0
 */
public class ReverseList {
	public static ListNode<Integer> reverseList(ListNode<Integer> head) {
		if (head == null) {
			return null;
		}
		ListNode<Integer> pre = null;
		ListNode<Integer> next = null;
		while (head != null) {
			// 暂存下个节点
			next = head.next;
			// 断链
			head.next = pre;
			pre = head;
			head = next;

		}

		return pre;
	}

	public static void main(String[] args) {

	}

}
