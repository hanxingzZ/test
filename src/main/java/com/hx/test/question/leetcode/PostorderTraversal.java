package com.hx.test.question.leetcode;

import java.util.ArrayList;
import java.util.Stack;

import com.hx.test.question.util.TreeNode;

public class PostorderTraversal {
	public static ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		if (root == null) {
			return list;
		}
		stack.add(root);
		TreeNode pre = null;
		TreeNode curr = null;
		while (!stack.isEmpty()) {
			curr = stack.peek();
			// 左右孩子节点均为空
			if ((curr.left == null && curr.right == null) || (pre != null && (pre == curr.left || pre == curr.right))) {
				list.add(curr.val);
				stack.pop();
				pre = curr;

			} else {
				if (curr.right != null) {
					stack.push(curr.right);
				}
				if (curr.left != null) {
					stack.push(curr.left);
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		t1.right = t2;
		t1.left = new TreeNode(30);
		t2.left = t3;
		t2.right = new TreeNode(31);

		System.out.println(postorderTraversal(t1));

	}

}
