package com.hx.test.question.hxtest;

import com.hx.test.question.util.TreeLinkNode;

/**
 * 
 * @description: TODO
 * @author : 韩兴(xing.han@ucarinc.com)
 * @date 创建时间：2020年7月8日 下午2:12:06
 * @version 1.0
 */
public class Q57_GetNext {
	public TreeLinkNode GetNext(TreeLinkNode pNode) {
		if (pNode.right != null) {
			TreeLinkNode node = pNode.right;
			while (node.left != null) {
				node = node.left;
			}
			return node;
		} else {
			while (pNode.next != null) {
				TreeLinkNode parent = pNode.next;
				if (parent.left == pNode) {
					return parent;
				}
				pNode = parent;
			}

		}
		return null;
	}
}
