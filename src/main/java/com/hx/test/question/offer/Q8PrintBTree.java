package com.hx.test.question.offer;

import java.util.ArrayList;

public class Q8PrintBTree {
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}

	ArrayList<Integer> list = new ArrayList<>();

	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		if (root == null) {
			return list;
		}
		list.add(root.val);
		valBTree(root);
		return list;
	}

	public void valBTree(TreeNode root) {

		if (root.left != null) {
			list.add(root.left.val);
		}

		if (root.right != null) {
			list.add(root.right.val);
		}

		if (root.left != null) {

			valBTree(root.left);
		}

		if (root.right != null) {

			valBTree(root.right);
		}

	}

	public ArrayList<Integer> PrintFromTopToBottom1(TreeNode root) {
		ArrayList<Integer> valList = new ArrayList<>();
		ArrayList<TreeNode> nodeList = new ArrayList<>();
		if (root == null) {
			return list;
		}
		nodeList.add(root);

		while (nodeList.size() > 0) {
			TreeNode t = nodeList.remove(0);
			if (t.left != null) {
				nodeList.add(t.left);
			}
			if (t.right != null) {
				nodeList.add(t.right);
			}
			valList.add(t.val);
		}
		return valList;
	}

	public static void main(String[] args) {
		Q8PrintBTree q8 = new Q8PrintBTree();
		TreeNode root = q8.new TreeNode(0);
		TreeNode left = q8.new TreeNode(1);
		TreeNode right = q8.new TreeNode(2);
		root.left = left;
		root.right = right;

		System.out.println(q8.PrintFromTopToBottom1(root).toString());

	}

}
