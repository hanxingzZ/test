package com.hx.test.question.leetcode;

import com.hx.test.question.util.TreeNode;

/**
 * 
 * @description: 给定一个二叉树，找出其最小深度。
 * 
 *               最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 
 *               说明: 叶子节点是指没有子节点的节点。
 * @author : 韩兴(13039997950@163.com)
 * @date 创建时间：2020年1月10日 上午10:07:20
 * @version 1.0
 */
public class BTreeMinDepth {
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = minDepth(root.left);
		int right = minDepth(root.right);

		return (left == 0 || right == 0) ? (left + right + 1) : Math.min(left, right) + 1;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
