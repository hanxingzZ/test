package com.hx.test.question.offer;

import java.util.LinkedList;

import com.hx.test.question.util.TreeNode;

public class TreeDepth {

	public static int treeDepth(TreeNode root) {
		return root == null ? 0 : Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
	}

	public static int treeDepth1(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		int depth = 0;
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			depth++;
		}

		return depth;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode root1 = new TreeNode(2);
		TreeNode root2 = new TreeNode(3);
		TreeNode root3 = new TreeNode(4);
		TreeNode root4 = new TreeNode(5);
		TreeNode root5 = new TreeNode(6);
		TreeNode root6 = new TreeNode(7);
		root.left = root1;
		root.right = root2;
		root1.left = root3;
		root1.right = root4;
		root2.right = root5;
		root4.left = root6;

		System.out.println(treeDepth(root));
		System.out.println(treeDepth1(root));

	}

}
