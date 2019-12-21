package com.amazon.datastructures;

import com.amazon.model.TreeNode;

class AVLTree{
	
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
		
		if(node.left.height > node.right.height) {
			node.height = 1 + node.left.height;
		}else {
			node.height = 1 + node.right.height;
		}
		
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
	
	int height(TreeNode node) {
		if(node != null) { // null check to avoid NullPointerException
			return node.height;
		}else {
			return 0;
		}
	}
	
	int size() {
		return size;
	}
	
	TreeNode deleteData(TreeNode root, int data) { 
         return deleteRec(root, data); 
    } 
	
    /* A recursive function to insert a new key in BST */
	TreeNode deleteRec(TreeNode root, int data) 
    { 
        /* Base Case: If the tree is empty */
        if (root == null)  return root; 
  
        /* Otherwise, recur down the tree */
        if (data < root.data) {
            root.left = deleteRec(root.left, data); 
        }else if (data > root.data) { 
            root.right = deleteRec(root.right, data); 
        // if key is same as root's key, then This is the node 
        // to be deleted 
        }else{ 
            // node with only one child or no child 
            if (root.left == null) 
                return root.right; 
            else if (root.right == null) 
                return root.left; 
  
            // node with two children: Get the inorder successor (smallest 
            // in the right subtree) 
            root.data = minimumData(root.right); 
  
            // Delete the inorder successor 
            root.right = deleteRec(root.right, root.data); 
        } 
  
        return root; 
    }
	
}


public class AVLTreeApp {

	public static void main(String[] args) {
	

	}

}
