
package com.hx.test.question.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.hx.test.question.util.TreeNode;

/**
 * 
 * @description: TODO
 * @author : 韩兴(13039997950@163.com)
 * @date 创建时间：2020年1月3日 下午2:01:03
 * @version 1.0
 */
public class IsValidBST {
	List<Integer> list = new ArrayList<>();

	public static boolean isValidBST(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return true;
		}
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private static boolean isValidBST(TreeNode root, Long min, Long max) {
		if (root == null) {
			return true;
		}
		if (max != null && max <= root.val) {
			return false;
		}
		if (min != null && min >= root.val) {
			return false;
		}
		return isValidBST(root.left, min, Long.valueOf(root.val))
				&& isValidBST(root.right, Long.valueOf(root.val), max);
	}

	public static boolean isValidBST1(TreeNode root) {

		Stack<TreeNode> stack = new Stack<>();
		long min = Long.MIN_VALUE;

		while (!stack.isEmpty() || root != null) {

			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (root.val < min) {
				return false;
			}
			min = root.val;
			root = root.right;
		}
		return true;
	}

	public static void main(String[] args) {
		// TreeNode root = new TreeNode(3);
		// root.left = new TreeNode(1);
		// root.right = new TreeNode(5);
		// root.left.left = new TreeNode(0);
		// root.left.right = new TreeNode(2);
		// root.right.left = new TreeNode(4);
		// root.right.right = new TreeNode(6);
		// TreeNode root = new TreeNode(Integer.MIN_VALUE);
		// root.right = new TreeNode(Integer.MAX_VALUE);
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(1);
		System.out.println(isValidBST(root));
	}

}
