package com.amazon.datastructures;

import com.amazon.model.TreeNode;

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
	
	// Shall return back the Tree after deletion
	TreeNode delete(TreeNode root, int data) {
		TreeNode node = deleteNode(root, data);
		return node;
	}
	
	// For Recursion to look into the Tree and delete the data
	TreeNode deleteNode(TreeNode root, int data) {
		
		// Check for Empty Tree
		// In Recursion this shall act as a base condition where to stop executions further
		if(root == null) {
			return root;
		}
		
		if(data < root.data) { 				// For Data less than root data we need to recursively go into the left subtree
			root.left = deleteNode(root.left, data);
		}else if(data > root.data) {		// For Data greater than root data we need to recursively go into the left subtree
			root.right = deleteNode(root.right, data);
		}else {								// neither less nor greater, we reached to the node where data matched :)
			// for node with no child or only 1 child return the one
			if(root.left == null) {
				return root.right;
			}else if(root.right == null) {
				return root.left;
			}
			
			// Deleting the Node with data
			// Get the minimum data in the right node
			root.data = minimumData(root.right);
			// delete that data from the right node
			root.right = deleteNode(root.right, root.data);
		}
		return root;
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
}

public class TreeAppNodeDeletion {

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
		
		System.out.println(">> Original Tree");
		tree.inOrder(rootNode);
		System.out.println();
		
		System.out.println(">> After Deleting 33 from Tree");
		tree.delete(rootNode, 33);
		tree.inOrder(rootNode);
		
		System.out.println();
		System.out.println(">> After Deleting 70 from Tree");
		tree.delete(rootNode, 70);
		tree.inOrder(rootNode);
	}

}
