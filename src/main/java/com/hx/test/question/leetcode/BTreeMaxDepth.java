package com.hx.test.question.leetcode;

import com.hx.test.question.util.TreeNode;

/**
 * 
 * @description: TODO
 * @author : 韩兴(13039997950@163.com)
 * @date 创建时间：2020年1月10日 上午10:16:29
 * @version 1.0
 */
public class BTreeMaxDepth {
	public int maxDepth(TreeNode root) {

		return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
