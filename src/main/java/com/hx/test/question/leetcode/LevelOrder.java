package com.hx.test.question.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.hx.test.question.util.TreeNode;

/**
 * 
 * @description: 二叉树层序遍历
 * @author : 韩兴(13039997950@163.com)
 * @date 创建时间：2020年1月9日 下午3:07:01
 * @version 1.0
 */
public class LevelOrder {
	public List<List<Integer>> levelOrder(TreeNode root) {
		LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
		if (root == null) {
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < levelSize; i++) {
				TreeNode temp = queue.poll();

				list.add(temp.val);

				if (temp.left != null) {
					queue.offer(temp.left);
				}
				if (temp.right != null) {
					queue.offer(temp.right);
				}
			}
			result.addFirst(list);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
