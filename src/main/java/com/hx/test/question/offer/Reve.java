package com.hx.test.question.offer;

import com.hx.test.question.offer.Q3listNode.ListNode;
import com.hx.test.question.offer.Q8PrintBTree.TreeNode;

public class Reve {
	public static ListNode ReverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode pre = null;
		ListNode next = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}

	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return root;
		TreeNode tree = root.left;
		root.left = root.right;
		root.right = tree;
		if (root.left != null)
			invertTree(root.left);
		if (root.right != null)
			invertTree(root.right);
		return root;
	}

	public static void main(String[] args) {
		ListNode ln = new ListNode(1);
		ln.next = new ListNode(3);
		ln.next.next = new ListNode(5);
		ln.next.next.next = new ListNode(7);
		ListNode ln1 = new ListNode(2);
		ln1.next = new ListNode(4);
		ln1.next.next = new ListNode(6);
		ln1.next.next.next = new ListNode(8);
		ReverseList(ln);
		ReverseList(ln1);

	}

}
