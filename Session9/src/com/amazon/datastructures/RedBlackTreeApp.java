package com.amazon.datastructures;

import java.util.PriorityQueue;
import java.util.Queue;

class RedBlackTree<Key extends Comparable<Key>, Value>{
	
	// Symbolic Constants
	// To manage colors for Nodes
	public static final boolean RED = true;
	public static final boolean BLACK = false;
	
	// Root Node from where we shall begin
	// Initially this reference variable root is null :)
	Node root;
	
	/*
	class Entry{
		// Data in Node
		Key key;
		Value value;
	}*/
	
	// Internal or Nested Class Node
	class Node{
		
		// Data in Node
		Key key;			// Key to Reach to Data
		Value value;		// Data in Real
		Node left, right;	// Left and Right Node References (Automatically null)
		boolean color;		// color of Node
		int size;			// size of Tree from Node :)
		
		public Node(Key key, Value value, boolean color, int size) {
			this.key = key;
			this.value = value;
			this.color = color;
			this.size = size;
		}
	
	}
	
	// Utility Functions
	
	// which tells the color of node is red -> true or black -> false
	boolean isRed(Node node) {
		if(node!=null) {
			return node.color == RED;  // non null case check for the color and return accordingly
		}else {
			return false;		// for null case return false
		}
	}

	// to get the size from the passed node
	int size(Node node) {
		if (node!=null) {
			return node.size;
		}else {
			return 0;
		}
	}
	
	// to get the size from the root
	int size() {
		return size(root);
	}
	
	// if tree is empty or not
	boolean isEmpty() {
		return root == null; 	// Check if root is null or not
	}
	
	Node rotateLeft(Node node) {
		System.out.println(">> rotateLeft "+node);
		// Rotate Nodes
		Node x = node.right;
		node.right = x.left;
		x.left = node;
		
		// Update Color
		x.color = x.left.color;
		x.left.color = RED;
		
		// Update Size
		x.size = node.size;
		node.size = size(node.left) + size(node.right) + 1;
		
		return x;
		
	}
	
	Node rotateRight(Node node) {
		System.out.println(">> rotateRight "+node);
		// Rotate Nodes
		Node x = node.left;
		node.left = x.right;
		x.right = node;
		
		// Update Color
		x.color = x.right.color;
		x.right.color = RED;
		
		// Update Size
		x.size = node.size;
		node.size = size(node.left) + size(node.right) + 1;
		
		return x;
		
	}
	
	// Flip Colors in node, left node and right node
	void flipColors(Node node) {
		System.out.println(">> flipColors "+node);
		node.color = !node.color;
		node.left.color = !node.left.color;
		node.right.color = !node.right.color;
	}
	
	// Getter Method to fetch the Value based on Key :)
	Value get(Key key) {
		if(key!=null) {
			return get(root, key);
		}else {
			return null;
		}
	}
	
	// Keep Iterating Left or Right to find the Key and return that specific value when found
	Value get(Node node, Key key) {
		while(node != null) {
			int result = key.compareTo(node.key);
			if(result < 0) 		  node = node.left;	 // Search Left 
			else if(result > 0)   node = node.right; // Search Right 
			else				  return node.value; // Found Value so Return it
		}
		
		return null;
	}
	
	// Check if we have Key Value available in Tree
	boolean contains(Key key) {
		return get(key) != null;
	}
	
	// Take Key and Value as Input 
	void put(Key key, Value value) {
		// We are only inserting non nulls | PS: Since we cannot do a null comparison, e wont be able to entertain null key or null value 
		if(key != null && value != null) {
			root = put(root, key, value);
			root.color = BLACK;			// Lets make color of Root to go as Black fulfilling RBT Strategies
		}
	}
	
	// Put the Data in Tree as BST
	Node put(Node node, Key key, Value value) {
		
		if(node == null) {
			// Whenever we will create a Node, we will mark it RED
			return new Node(key, value, RED, 1); 
		}
		
		// Check for Key Comparison
		int result = key.compareTo(node.key);
		if(result < 0) 		  node.left = put(node.left, key, value);		// Left Node Insertion
		else if(result > 0)   node.right = put(node.right, key, value);		// Right Node Insertion
		else				  node.value = value;				// Value Matching
		
		// Fix Violations for RBT to fulfill Insertion Strategies
		if( isRed(node.right) && !isRed(node.left) )		node = rotateLeft(node);
		if( isRed(node.left) && isRed(node.left.left) )		node = rotateRight(node);
		if( isRed(node.left) && isRed(node.right))		 	flipColors(node);
		
		// After fixation we must update the size of node
		node.size = size(node.left) + size(node.right) + 1;
		
		System.out.println(">> NODE PUT FINIHED: "+key+" | "+value+" | "+node.left+" | "+node.right);
		
		return node;
	}
	
    public Iterable<Key> keys() {
        return keys(min(), max());
    }
	
    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new PriorityQueue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    } 

    // add the keys between lo and hi in the subtree rooted at x to the queue
    private void keys(Node node, Queue<Key> queue, Key lo, Key hi) { 
        if (node == null) return; 
        
        int cmplo = lo.compareTo(node.key); 
        
        int cmphi = hi.compareTo(node.key); 
        
        if (cmplo < 0) keys(node.left, queue, lo, hi);   // traverse for key in left
        
        if (cmplo <= 0 && cmphi >= 0) queue.add(node.key); // found the match
        
        if (cmphi > 0) keys(node.right, queue, lo, hi);  // traverse for key in right
    }
	
	// Get the Smallest Key
    public Key min() {
        return min(root).key;
    }
    
    private Node min(Node node) { 
        if (node.left == null) return node; 
        else                return min(node.left); 
    } 
    
    // Get the Largest Key
    public Key max() {
        return max(root).key;
    } 
    
    private Node max(Node node) { 
        if (node.right == null) return node; 
        else                 return max(node.right); 
    } 
	
}

public class RedBlackTreeApp {

	public static void main(String[] args) {
		
		RedBlackTree<String, Integer> tree = new RedBlackTree<String, Integer>();
		tree.put("Kim", 1100);
		tree.put("Sia", 2100);
		tree.put("Joe", 320);
		tree.put("Dave", 4500);
		tree.put("Leo", 5100);
		tree.put("Anna", 1200);
		
		System.out.println(">> Size of Tree: "+tree.size());
		System.out.println(">> Value for key Dave is: "+tree.get("Dave"));
		System.out.println(">> Key Kim available: "+tree.contains("Kim"));	
		
		System.out.println(">> min key is: "+tree.min());
		System.out.println(">> max key is: "+tree.max());
		
		for(String key : tree.keys()) {
			System.out.println(">> Key is: "+key+" Value is: "+tree.get(key));
		}
		

	}

}
