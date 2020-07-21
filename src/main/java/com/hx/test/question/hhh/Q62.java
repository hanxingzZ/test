package com.hx.test.question.hhh;

import java.util.Stack;

import com.hx.test.question.util.TreeNode;

/**
 * 
 * @description: TODO
 * @author : 韩兴(xing.han@ucarinc.com)
 * @date 创建时间：2020年7月9日 下午2:26:44
 * @version 1.0
 */
public class Q62 {
	TreeNode KthNode(TreeNode pRoot, int k) {
		if (pRoot == null || k <= 0) {
			return null;
		}

		Stack<TreeNode> stack = new Stack<>();
		int count = 0;
		TreeNode temp = pRoot;
		while (!stack.isEmpty() || pRoot != null) {
			if (temp != null) {
				stack.push(temp);
				temp = temp.left;
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
