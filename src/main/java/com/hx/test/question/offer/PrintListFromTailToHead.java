package com.hx.test.question.offer;

import java.util.ArrayList;

import com.hx.test.question.util.ListNode;

/**
 * 
 * @description: 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * @author : 韩兴(13039997950@163.com)
 * @date 创建时间：2019年12月5日 下午6:41:28
 * @version 1.0
 */
public class PrintListFromTailToHead {
	static ArrayList<Integer> l = new ArrayList<>();

	/** 遍历 和 栈相同 */
	public static ArrayList<Integer> printListFromTailToHead(ListNode<Integer> listNode) {
		ArrayList<Integer> tempList = new ArrayList<>();
		if (listNode == null) {
			return tempList;
		}
		while (listNode != null) {
			tempList.add(listNode.val);
			listNode = listNode.next;
		}
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = tempList.size() - 1; i >= 0; i--) {
			System.out.println(i);
			list.add(tempList.get(i));
		}
		return list;
	}

	/** 递归解法 */
	public static ArrayList<Integer> printListFromTailToHead1(ListNode<Integer> listNode) {
		if (listNode != null) {
			printListFromTailToHead1(listNode.next);
			l.add(listNode.val);
		}

		return l;
	}

	public static void main(String[] args) {
		// {67,0,24,58}
		ListNode<Integer> node = new ListNode<Integer>(67);
		node.next = new ListNode<>(0);
		node.next.next = new ListNode<>(24);
		node.next.next.next = new ListNode<>(58);
		System.out.println(printListFromTailToHead(node));
		System.out.println(printListFromTailToHead1(node));
	}
}
