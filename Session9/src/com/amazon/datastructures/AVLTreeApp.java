package com.amazon.datastructures;

import com.amazon.model.Product;
import com.amazon.model.TreeNode;

// PS: https://cstack.github.io/db_tutorial/
//     For DB Tutorial as in Data Structures

// Generic AVL Tree Implementation in Java :)

// Explore WildCards in Generics -> ?
class AVLTree<T extends Product>{
	
	static int size = 0;
	
	TreeNode<T> insert(TreeNode<T> node, T data) {
		
		size++;
			
		if(node == null) {
			node = new TreeNode<T>(); // data will be 0 | left and right will be null | height will be 0
			node.data = data;
			System.out.println(">> [INSERT] NODE "+node+" Data: "+data+" Right: "+node.right+" Left: "+node.left);
			return node;
		}
  
		// Use BST Operation to add Node.
		// Data smaller than node goes left, and greater goes right
        if (data.pid < node.data.pid) {
            node.left = insert(node.left, data); 
        }else if (data.pid > node.data.pid) { 
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
        if (balance > 1 && data.pid < node.left.data.pid) {
        	System.out.println("1. Left Left Case : Perform Right Rotation");
            return rightRotate(node); 
        }
  
        // 2. Right Right Case : Perform Left Rotation
        if (balance < -1 && data.pid > node.right.data.pid) {
        	System.out.println("2. Right Right Case : Perform Left Rotation");
            return leftRotate(node); 
		}
  
        // 3. Left Right Case : Perform Left Rotation and than Right Rotation
        if (balance > 1 && data.pid > node.left.data.pid) { 
        	System.out.println("3. Left Right Case : Perform Left Rotation and than Right Rotation");
            node.left = leftRotate(node.left); 
            return rightRotate(node); 
        } 
  
        // 4. Right Left Case : Perform Right Rotation and than Left Rotation
        if (balance < -1 && data.pid < node.right.data.pid) {
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
	
	int balaneFactor(TreeNode<T> node) { 
        if (node == null) 
            return 0; 
  
        return height(node.left) - height(node.right); 
    } 
	
	// Right Rotation for Balancing
    TreeNode<T> rightRotate(TreeNode<T> y) { 
    	TreeNode<T> x = y.left; 
    	TreeNode<T> T2 = x.right; 
  
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
    TreeNode<T> leftRotate(TreeNode<T> x) { 
    	TreeNode<T> y = x.right; 
    	TreeNode<T> T2 = y.left; 
  
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
	void inOrder(TreeNode<T> root) {
		
		if(root!=null) {
			inOrder(root.left);
			System.out.println(root.data+"  ");
			inOrder(root.right);
		}
	}

	void preOrder(TreeNode<T> root) {
		
		if(root!=null) {
			System.out.println(root.data+"  ");
			preOrder(root.left);
			preOrder(root.right);
		}
		
	}
	
	void postOrder(TreeNode<T> root) {
		
		if(root!=null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.println(root.data+"  ");
		}
		
	}
	
	TreeNode<T> search(TreeNode<T> root, T data) {
		
		if(root==null || root.data.pid == data.pid) {
			return root;
		}
		
		// If root's data is greater than data | Search Left
		if(root.data.pid > data.pid) {
			return search(root.left, data);
		}
		
		// 	Otherwise Search Right
		return search(root.right, data);
	}
	
	
	int minimumData(TreeNode<T> root) {
		
		
		int minimumData = root.data.pid;
		
		TreeNode<T> temp = root;
		
		while(temp.left != null) {
			minimumData = temp.left.data.pid;
			temp = temp.left;
		}
		
		return minimumData;
	}
	
	int maximumData(TreeNode<T> root) {
		
		int maximumData = root.data.pid;
		
		TreeNode<T> temp = root;
		
		while(temp.right != null) {
			maximumData = temp.right.data.pid;
			temp = temp.right;
		}
		
		return maximumData;
	}
	
	// Return Height of Tree
	int height(TreeNode<T> node) {
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
		
		Product p1 = new Product(30, "Adidas Alphabounce", 3000);
		Product p2 = new Product(5, "Adidas BackPack", 500);
		Product p3 = new Product(35, "Nike Track Suit", 3500);
		Product p4 = new Product(32, "Apple iPhone", 32000);
		Product p5 = new Product(40, "Samsung LED TV", 45000);
		Product p6 = new Product(45, "LG LED TV", 25000);
	
		AVLTree<Product> tree = new AVLTree<Product>();
		
		TreeNode<Product> rootNode = tree.insert(null, p1);
		
		System.out.println(">> rootNode "+rootNode);
		
		rootNode = tree.insert(rootNode, p2);
		rootNode = tree.insert(rootNode, p3);
		rootNode = tree.insert(rootNode, p4);
		rootNode = tree.insert(rootNode, p5);
		rootNode = tree.insert(rootNode, p6);
		
		tree.inOrder(rootNode);

	}

}
