package com.amazon.datastructures;

import com.amazon.model.TreeNode;

// PS: https://www.cs.usfca.edu/~galles/visualization/BST.html

class Tree{
	
	static int size = 0;
		
	TreeNode insert(TreeNode node, int data) {
		
		size++;
			
		if(node == null) {
			node = new TreeNode(); // data will be 0 | left and right will be null
			node.data = data;
			System.out.println(">> [INSERT] ROOT NODE "+node+" Data: "+data+" Right: "+node.right+" Left: "+node.left);
			return node;
		}
		
		// Using Recursion to do the Job for us !! 
		if(data<node.data) { // In Case data is lesser insert the data in the left node
			node.left = insert(node.left, data);
		}else { // otherwise insert the data in the right node
			node.right = insert(node.right, data);
		}
		
		System.out.println(">> [INSERT] NODE "+node+" Data: "+data+" Right: "+node.right+" Left: "+node.left);
		
		return node;
	}
	
	// Traversing Recursively :)
	void inOrder(TreeNode root) {
		
		if(root!=null) {
			inOrder(root.left);
			System.out.print(root.data+"  ");
			inOrder(root.right);
		}
	}

	void preOrder(TreeNode root) {
		
		if(root!=null) {
			System.out.print(root.data+"  ");
			preOrder(root.left);
			preOrder(root.right);
		}
		
	}
	
	void postOrder(TreeNode root) {
		
		if(root!=null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data+"  ");
		}
		
	}
	
	TreeNode search(TreeNode root, int data) {
		
		if(root==null || root.data == data) {
			return root;
		}
		
		// If root's data is greater than data | Search Left
		if(root.data > data) {
			return search(root.left, data);
		}
		
		// 	Otherwise Search Right
		return search(root.right, data);
	}
	
	
	int minimumData(TreeNode root) {
		
		
		int minimumData = root.data;
		
		TreeNode temp = root;
		
		while(temp.left != null) {
			minimumData = temp.left.data;
			temp = temp.left;
		}
		
		return minimumData;
	}
	
	int maximumData(TreeNode root) {
		
		
		int maximumData = root.data;
		
		TreeNode temp = root;
		
		while(temp.right != null) {
			maximumData = temp.right.data;
			temp = temp.right;
		}
		
		return maximumData;
	}
	
	int size() {
		return size;
	}
	
	void deleteData(int data) {
		
	}
	
}


public class TreeApp {

	public static void main(String[] args) {
		
		Tree tree = new Tree();
		
		TreeNode rootNode = tree.insert(null, 14);
		
		tree.insert(rootNode, 23);
		tree.insert(rootNode, 7);
		tree.insert(rootNode, 10);
		tree.insert(rootNode, 33);
		tree.insert(rootNode, 56);
		tree.insert(rootNode, 80);
		tree.insert(rootNode, 66);
		tree.insert(rootNode, 70);
		tree.insert(rootNode, 44);
		tree.insert(rootNode, 50);
		
		// Traverse InOrder [L  R'  R]
		// 7, 10, 14, 23, 33, 44, 50, 56, 66, 70, 80
		
		tree.inOrder(rootNode);
		System.out.println();
		
		// Traverse PreOrder [R' L  R]
		// 14, 7, 10, 23, 33, 56, 44, 50, 80, 66, 70
		
		tree.preOrder(rootNode);
		System.out.println();
		
		// Traverse PostOrder [L  R  R']
		// 10, 7, 50, 44, 70, 66, 80, 56, 33, 23, 14
		
		tree.postOrder(rootNode);
		System.out.println();
		
		System.out.println("--Searching--");
		
		TreeNode searchedNode = tree.search(rootNode, 56);
		System.out.println(">> [SEARCHED] NODE "+searchedNode+" Data: "+searchedNode.data+" Right: "+searchedNode.right+" Left: "+searchedNode.left);
		
		System.out.println(">> Minimum Data in Tree: "+tree.minimumData(rootNode));
		System.out.println(">> Maximum Data in Tree: "+tree.maximumData(rootNode));
		System.out.println(">> Size is: "+tree.size());

	}

}
