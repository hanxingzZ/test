package com.hx.test.algorithmsanddatastructures.btree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BTree {

	/**
	 * 二叉树的前序遍历
	 * 
	 * @param <T>
	 */
	public static <T> void preOrqerTraverse(BTreeNode<T> root) {

		if (root == null)
			return;
		System.out.print(root.getVal() + " ");
		preOrqerTraverse(root.getLeftNode());
		preOrqerTraverse(root.getRightNode());

	}

	/**
	 * 二叉树的中序遍历
	 * 
	 * @param <T>
	 */
	public static <T> void inOrderTraverse(BTreeNode<T> root) {
		if (root == null)
			return;

		inOrderTraverse(root.getLeftNode());
		System.out.print(root.getVal() + " ");
		inOrderTraverse(root.getRightNode());

	}

	/**
	 * 后序遍历
	 * 
	 * @param root
	 */
	public static <T> void PostOrderTraverse(BTreeNode<T> root) {
		if (root == null)
			return;

		PostOrderTraverse(root.getLeftNode());
		PostOrderTraverse(root.getRightNode());
		System.out.print(root.getVal() + " ");
	}

	/**
	 * 层序遍历
	 * 
	 * @param root
	 */
	public static <T> void LaywerTraversal(BTreeNode<T> root) {
		if (root == null)
			return;
		LinkedList<BTreeNode<T>> list = new LinkedList<BTreeNode<T>>();
		list.add(root);
		BTreeNode<T> currentNode;
		while (!list.isEmpty()) {
			currentNode = list.poll();
			System.out.print(currentNode.getVal() + " ");
			if (currentNode.getLeftNode() != null) {
				list.add(currentNode.getLeftNode());
			}
			if (currentNode.getRightNode() != null) {
				list.add(currentNode.getRightNode());
			}
		}
	}

	/**
	 * 创建二叉树，数组需为层序遍历序列
	 * 
	 * @param cArr
	 * @return
	 */
	public static BTreeNode<Character> init(char[] cArr) {
		List<BTreeNode<Character>> treeList = new ArrayList<>();

		for (int i = 0; i < cArr.length; i++) {
			if (cArr[i] == '#') {
				treeList.add(null);
				continue;
			}
			treeList.add(new BTreeNode<Character>(cArr[i]));
		}

		for (int i = 0; i < cArr.length / 2; i++) {
			treeList.get(i).setLeftNode(treeList.get(i * 2 + 1));
			if (i * 2 + 2 < treeList.size()) {// 避免偶数的时候 下标越界
				treeList.get(i).setRightNode(treeList.get(i * 2 + 2));
			}
		}

		return treeList.get(0);
	}

	/**
	 * 二叉排序树查找元素
	 * 
	 * @param b
	 * @param key
	 * @return
	 */
	public static <T, S> boolean searchBST(BTreeNode<T> b, S key) {

		if (b == null) {
			return false;
		}
		int t = compare(b.getVal(), key);
		if (t == 0) {
			return true;
		} else if (t < 0) {
			return searchBST(b.getLeftNode(), key);
		} else {
			return searchBST(b.getRightNode(), key);
		}

	}

	/**
	 * 创建/插入二叉排序树
	 * 
	 * @param b
	 * @param key
	 * @return
	 */
	public static <T> boolean insertBST(BTreeNode<T> b, T key) {
		if (b == null) {
			throw new RuntimeException("该二叉树为null！");
		}

		if (b.getVal() == null) {
			b.setVal(key);
			return true;
		} else if (!searchBST(b, key)) {
			insertBST(null, b, key, 0);
			return true;
		} else {
			return false;
		}

	}

	public static <T> boolean deleteBST(BTreeNode<T> b, T key) {
		if (b == null) {
			throw new RuntimeException("该二叉树为null！");
		}
		if (b.getVal() == null) {
			return true;
		} else if (searchBST(b, key)) {
			deleteBST(null, b, key);
			return true;
		} else {
			return false;
		}

	}

	private static <T> void deleteBST(BTreeNode<T> parentB, BTreeNode<T> b, T key) {
		if (compare(b.getVal(), key) == 0) {
			delete(parentB, b, key);
		} else if (compare(b.getVal(), key) < 0) {
			deleteBST(b, b.getLeftNode(), key);
		} else {
			deleteBST(b, b.getRightNode(), key);
		}
	}

	private static <T> void delete(BTreeNode<T> parentB, BTreeNode<T> b, T key) {
		if (b.getLeftNode() == null && b.getRightNode() == null) {
			b.clear();
		} else if (b.getLeftNode() == null) {
			parentB.setRightNode(b.getRightNode());
		} else if (b.getRightNode() == null) {
			parentB.setLeftNode(b.getLeftNode());
		} else {

		}
	}

	/**
	 * 创建/插入二叉排序树用于递归函数
	 * 
	 * @param b
	 * @param key
	 * @return
	 */
	private static <T> void insertBST(BTreeNode<T> parentB, BTreeNode<T> b, T key, int flag) {
		if (b == null) {
			b = new BTreeNode<T>(key);
			if (flag < 0) {
				parentB.setLeftNode(b);
			} else if (flag > 0) {
				parentB.setRightNode(b);
			}
			return;
		}
		if (compare(b.getVal(), key) < 0) {
			insertBST(b, b.getLeftNode(), key, -1);

		} else {
			insertBST(b, b.getRightNode(), key, 1);

		}

	}

	/**
	 * t>key 返回负数，t=key返回0，t>key返回正数
	 * 
	 * @param t
	 * @param key
	 * @return
	 */
	private static <T, S> int compare(T t, S key) {
		return String.valueOf(key).compareTo(String.valueOf(t));
	}

	public static void main(String[] args) {

		String strq = "01234567";
		String str = "31402#5";

		BTreeNode<Character> root1 = init(str.toCharArray());
		// System.out.println("二叉树tostring" + root.toString());
		//
		// System.out.println("二叉树前序遍历：");
		// preOrqerTraverse(root);
		// System.out.println("二叉树中序遍历：");
		// inOrderTraverse(root);
		// System.out.println("二叉树后序遍历：");
		// PostOrderTraverse(root);

		// System.out.print("二叉树前序遍历：");
		// preOrqerTraverse(root1);
		// System.out.println();
		// System.out.print("二叉树中序遍历：");
		// inOrderTraverse(root1);
		// System.out.println();
		// System.out.print("二叉树后序遍历：");
		// PostOrderTraverse(root1);
		// int n = 8;
		// System.out.println();
		// System.err.println("该二叉树" + (searchBST(root1, n) == true ? "包含" :
		// "不包含") + n);
		// System.out.println(insertBST(root1, '9'));
		// ;
		// System.out.println();
		// System.out.print("二叉树中序遍历：");
		// inOrderTraverse(root1);
		BTreeNode<Integer> root3 = new BTreeNode<>();
		// BiTreeNode<Character> root3 = null;
		int[] arr = { 5, 4, 3, 1, 2, 8, 7, 6 };
		for (int i = 0; i < arr.length; i++) {
			// insertBST(root2, arr[i]);
			insertBST(root3, arr[i]);
		}
		// System.out.println();
		// System.out.print("二叉树前序遍历：");
		// preOrqerTraverse(root2);
		// System.out.println();
		// System.out.print("二叉树中序遍历：");
		// inOrderTraverse(root2);
		// System.out.println();
		// System.out.print("二叉树后序遍历：");
		// PostOrderTraverse(root2);
		// System.out.println();
		// System.out.print("二叉树层序遍历：");
		// LaywerTraversal(root2);
		System.out.println();
		System.out.print("二叉树前序遍历：");
		preOrqerTraverse(root3);
		System.out.println();
		System.out.print("二叉树中序遍历：");
		inOrderTraverse(root3);
		System.out.println();
		System.out.print("二叉树后序遍历：");
		PostOrderTraverse(root3);
		System.out.println();
		System.out.print("二叉树层序遍历：");
		LaywerTraversal(root3);

	}
}
