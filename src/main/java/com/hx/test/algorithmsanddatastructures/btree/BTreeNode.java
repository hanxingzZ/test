package com.hx.test.algorithmsanddatastructures.btree;

public class BTreeNode<T> {
	/**
	 * 数据域
	 */
	private T val;

	private BTreeNode<T> leftNode;

	private BTreeNode<T> rightNode;

	public BTreeNode() {

	}

	public BTreeNode(T t) {
		this(t, null, null);

	}

	public BTreeNode(T t, BTreeNode<T> leftNode, BTreeNode<T> rightNode) {
		this.val = t;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}

	public T getVal() {
		return val;
	}

	public void setVal(T val) {
		this.val = val;
	}

	public BTreeNode<T> getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(BTreeNode<T> leftNode) {
		this.leftNode = leftNode;
	}

	public BTreeNode<T> getRightNode() {
		return rightNode;
	}

	public void setRightNode(BTreeNode<T> rightNode) {
		this.rightNode = rightNode;
	}

	public void clear() {
		this.val = null;
		this.rightNode = null;
		this.leftNode = null;
	}
}
