package com.amazon.datastructures;

import com.amazon.model.TreeNode;

class AVLTree{
	
	static int size = 0;
	
	TreeNode insert(TreeNode node, int data) {
		
		size++;
			
		if(node == null) {
			node = new TreeNode(); // data will be 0 | left and right will be null | height will be 0
			node.data = data;
			System.out.println(">> [INSERT] NODE "+node+" Data: "+data+" Right: "+node.right+" Left: "+node.left);
			return node;
		}
  
		// Use BST Operation to add Node.
		// Data smaller than node goes left, and greater goes right
        if (data < node.data) {
            node.left = insert(node.left, data); 
        }else if (data > node.data) { 
            node.right = insert(node.right, data); 
        }else { 
        	// data might be same as that of node's data. BST no Duplicates
            return node;
        }
  
        // Update height of this ancestor node : get the max height and add 1 
        node.height = getMaxHeight(height(node.left), height(node.right)) + 1; 
  
        // Check balance factor for rotation of tree and make it balance further
        int balance = balaneFactor(node); 
        System.out.println(">> balance factor: "+balance);
  
        // 4 Cases for UnBalanced Node
        
        // 1. Left Left Case : Perform Right Rotation
        if (balance > 1 && data < node.left.data) {
        	System.out.println("1. Left Left Case : Perform Right Rotation");
            return rightRotate(node); 
        }
  
        // 2. Right Right Case : Perform Left Rotation
        if (balance < -1 && data > node.right.data) {
        	System.out.println("2. Right Right Case : Perform Left Rotation");
            return leftRotate(node); 
		}
  
        // 3. Left Right Case : Perform Left Rotation and than Right Rotation
        if (balance > 1 && data > node.left.data) { 
        	System.out.println("3. Left Right Case : Perform Left Rotation and than Right Rotation");
            node.left = leftRotate(node.left); 
            return rightRotate(node); 
        } 
  
        // 4. Right Left Case : Perform Right Rotation and than Left Rotation
        if (balance < -1 && data < node.right.data) {
        	System.out.println("4. Right Left Case : Perform Right Rotation and than Left Rotation");
            node.right = rightRotate(node.right); 
            return leftRotate(node); 
        } 
  
        return node; 
	}
	
	int getMaxHeight(int leftHeight, int rightHeight) {
		int maxHeight = leftHeight > rightHeight ? leftHeight : rightHeight;
		return maxHeight;
	}
	
	int balaneFactor(TreeNode node) { 
        if (node == null) 
            return 0; 
  
        return height(node.left) - height(node.right); 
    } 
	
	// Right Rotation for Balancing
    TreeNode rightRotate(TreeNode y) { 
    	TreeNode x = y.left; 
    	TreeNode T2 = x.right; 
  
        // Perform Rotation 
        x.right = y; 
        y.left = T2; 
  
        // Update heights 
        y.height = getMaxHeight(height(y.left), height(y.right)) + 1; 
        x.height = getMaxHeight(height(x.left), height(x.right)) + 1; 
  
        // Return new root 
        return x; 
    }
    
	// Left Rotation for Balancing
    TreeNode leftRotate(TreeNode x) { 
    	TreeNode y = x.right; 
    	TreeNode T2 = y.left; 
  
        // Perform rotation 
        y.left = x; 
        x.right = T2; 
  
        // Update heights 
        x.height = getMaxHeight(height(x.left), height(x.right)) + 1; 
        y.height = getMaxHeight(height(y.left), height(y.right)) + 1; 
  
        // Return new root 
        return y; 
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
	
	// Return Height of Tree
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
	
}

public class AVLTreeApp {

	public static void main(String[] args) {
	
		AVLTree tree = new AVLTree();
		
		TreeNode rootNode = tree.insert(null, 30);
		System.out.println(">> rootNode "+rootNode);
		rootNode = tree.insert(rootNode, 5);
		rootNode = tree.insert(rootNode, 35);
		rootNode = tree.insert(rootNode, 32);
		rootNode = tree.insert(rootNode, 40);
		rootNode = tree.insert(rootNode, 45);
		
		tree.inOrder(rootNode);

	}

}
