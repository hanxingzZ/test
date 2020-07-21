package com.hx.test.question.hxtest;

import java.util.LinkedList;

import com.hx.test.question.util.TreeNode;

/**
 * 
 * @description: TODO
 * @author : 韩兴(xing.han@ucarinc.com)
 * @date 创建时间：2020年6月29日 下午3:26:41
 * @version 1.0
 */
public class Q38_TreeDepth {
	public int maxTreeDepth(TreeNode root) {
		return root == null ? 0 : Math.max(maxTreeDepth(root.left), maxTreeDepth(root.right)) + 1;
	}

	public int maxTreeDepth1(TreeNode root) {
		if (root == null) {
			return 0;
		}
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int d = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode temp = queue.poll();
				if (temp.left != null) {
					queue.offer(temp.left);
				}
				if (temp.right != null) {
					queue.offer(temp.right);
				}
			}
			d++;
		}
		return d;
	}

	public int minTreeDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = minTreeDepth(root.left);
		int right = minTreeDepth(root.right);
		return left == 0 || right == 0 ? left + right + 1 : Math.min(left, right) + 1;

	}
}
