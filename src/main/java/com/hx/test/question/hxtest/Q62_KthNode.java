package com.hx.test.question.hxtest;

import java.util.Stack;

import com.hx.test.question.util.TreeNode;

/**
 * 
 * @description: 二叉搜索树的第k个节点 二叉搜索树中序遍历有序
 * @author : 韩兴(xing.han@ucarinc.com)
 * @date 创建时间：2020年7月8日 下午5:37:16
 * @version 1.0
 */
public class Q62_KthNode {
	TreeNode KthNode(TreeNode pRoot, int k) {
		if (pRoot == null || k <= 0) {
			return null;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode temp = stack.pop();
		stack.push(pRoot);
		int count = 0;
		while (!stack.isEmpty() || temp != null) {
			if (temp != null) {
				while (temp.left != null) {
					temp = temp.left;
					stack.push(temp);
				}
			} else {
				temp = stack.pop();
				count++;
				if (count == k) {
					return temp;
				}
				temp = temp.right;
			}

		}
		return null;
	}
}
