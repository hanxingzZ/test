package com.hx.test.question.hhh;

import com.hx.test.question.util.TreeNode;

/**
 * 
 * @description: TODO
 * @author : 韩兴(xing.han@ucarinc.com)
 * @date 创建时间：2020年7月9日 下午5:33:28
 * @version 1.0
 */
public class Q38 {
	// 或者用层序遍历，queue实现
	public static int depth(TreeNode root) {
		return root == null ? 0 : Math.max(depth(root.left), depth(root.right)) + 1;
	}

	
	public static int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = minDepth(root.left);
		int right = minDepth(root.right);
		return left == 0 || right == 0 ? left + right + 1 : Math.min(left, right) + 1;
	}

}
