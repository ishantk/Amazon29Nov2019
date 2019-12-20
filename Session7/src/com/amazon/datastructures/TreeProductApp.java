package com.amazon.datastructures;

import com.amazon.model.MyTreeNode;
import com.amazon.model.Product;
import com.amazon.model.TreeNode;

class TreeProduct{
	
	MyTreeNode<Product> insert(MyTreeNode<Product> node, Product data) {
		
			
		if(node == null) {
			node = new MyTreeNode<Product>(); // data will be 0 | left and right will be null
			node.data = data;
			System.out.println(">> [INSERT] ROOT NODE "+node+" Data: "+data+" Right: "+node.right+" Left: "+node.left);
			return node;
		}
		
		// Using Recursion to do the Job for us !! 
		if(data.price < node.data.price) { // In Case price is lesser insert the data in the left node
			node.left = insert(node.left, data);
		}else { // otherwise insert the data in the right node
			node.right = insert(node.right, data);
		}
		
		System.out.println(">> [INSERT] NODE "+node+" Data: "+data+" Right: "+node.right+" Left: "+node.left);
		
		
		return node;
	}
	
	MyTreeNode<Product> insertAlphabetically(MyTreeNode<Product> node, Product data) {
		
		
		if(node == null) {
			node = new MyTreeNode<Product>(); // data will be 0 | left and right will be null
			node.data = data;
			System.out.println(">> [INSERT] ROOT NODE "+node+" Data: "+data+" Right: "+node.right+" Left: "+node.left);
			return node;
		}
		
		// Using Recursion to do the Job for us !! 
		if(data.name.compareTo(node.data.name) < 0) { // In name is lesser insert the data in the left node
			node.left = insert(node.left, data);
		}else { // otherwise insert the data in the right node
			node.right = insert(node.right, data);
		}
		
		System.out.println(">> [INSERT] NODE "+node+" Data: "+data+" Right: "+node.right+" Left: "+node.left);
		
		
		return node;
	}
	
	// Traversing Recursively :)
	void inOrder(MyTreeNode<Product> root) {
		if(root!=null) {
			inOrder(root.left);
			System.out.println(root.data);
			inOrder(root.right);
		}
	}
	
	
}

public class TreeProductApp {

	public static void main(String[] args) {
		
		
		Product p1 = new Product(101, "Adidas AlphaBounce", 500);
		Product p2 = new Product(201, "iPhoneX", 5000);
		Product p3 = new Product(301, "Adidas BackPack", 300);
		Product p4 = new Product(401, "Samsung LED TV", 3000);
		Product p5 = new Product(501, "Nike Shoes", 400);
		
		TreeProduct tree = new TreeProduct();
		
		/*MyTreeNode<Product> rootNode = tree.insert(null, p1);
		tree.insert(rootNode, p2);
		tree.insert(rootNode, p3);
		tree.insert(rootNode, p4);
		tree.insert(rootNode, p5);

		tree.inOrder(rootNode);*/
		
		MyTreeNode<Product> rootNode = tree.insertAlphabetically(null, p1);
		tree.insertAlphabetically(rootNode, p2);
		tree.insertAlphabetically(rootNode, p3);
		tree.insertAlphabetically(rootNode, p4);
		tree.insertAlphabetically(rootNode, p5);

		tree.inOrder(rootNode);
		
		//String s1 = "Adidas AlphaBounce";
		//String s2 = "Bdidas AlphaBounce";
		
		//System.out.println(">> ComparetoResult: "+s1.compareTo(s2));
		//System.out.println(">> ComparetoResult: "+s2.compareTo(s1));
		
		
	}

}
