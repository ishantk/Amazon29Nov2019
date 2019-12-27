package com.amazon.model;

public class TreeNode<T> {
	public T data;
	public int height;
	
	public TreeNode<T> left;
	public TreeNode<T> right;

	public TreeNode() {
		data = null;
		height = 1;
		left = null;
		right = null;
	}
	
}
