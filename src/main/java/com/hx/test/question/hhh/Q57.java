package com.hx.test.question.hhh;

import com.hx.test.question.util.TreeLinkNode;

/**
 * 
 * @description: TODO
 * @author : 韩兴(xing.han@ucarinc.com)
 * @date 创建时间：2020年7月9日 下午2:51:45
 * @version 1.0
 */
public class Q57 {
	public TreeLinkNode GetNext(TreeLinkNode pNode) {
		if (pNode.right != null) {
			pNode = pNode.right;
			while (pNode.left != null) {
				pNode = pNode.left;
			}
			return pNode;
		} else {

			while (pNode.next != null) {
				TreeLinkNode parent = pNode.next;
				if (parent.left == pNode) {
					return pNode;
				}
				pNode = parent;
			}
		}
		return null;

	}
}
