package com.hx.test.question.offer;

import com.hx.test.question.util.TreeNode;

public class ReConstructBinaryTree {
	public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {

		return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	public static TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
		if (startPre > endPre || startIn > endIn) {
			return null;
		}
		TreeNode root = new TreeNode(pre[startPre]);
		for (int i = startIn; i <= endIn; i++) {
			// 遍历找到中序遍历的根节点
			if (in[i] == pre[startPre]) {
				// 前序遍历 根+左子树+右子树
				// 中序遍历根节点左边都左子树
				root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
				// 中序遍历根节点右边边都右子树
				root.right = reConstructBinaryTree(pre, startPre + i - startIn + 1, endPre, in, i + 1, endIn);
				break;
			}
		}
		return root;
	}

	public static void main(String[] args) {
		// // {1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
		// int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
		// int[] in = { 4, 7, 2, 1, 5, 3, 8, 6 };
		// System.out.println(JSON.toJSONString(reConstructBinaryTree(pre,
		// in)));
		boolean flag = false;
		if (flag = true) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}
}
