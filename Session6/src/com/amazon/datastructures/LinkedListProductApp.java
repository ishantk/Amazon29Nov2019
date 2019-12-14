package com.amazon.datastructures;

import com.amazon.model.MyNode;
import com.amazon.model.Node;
import com.amazon.model.Product;

class MyLinkedList<T>{
	
	MyNode<T> root;
	private static int size;
	
	//private static Node previousNode;
	
	void add(T data) { // Generics in implementation 
		
		MyNode<T> node = new MyNode<T>();
		node.data = data;
		size++;
		
		if(root == null) {
			root = node;
			System.out.println("---------------------------------------");
			System.out.println(">> [ADD] Node Created at "+node+" link is: "+node.link);
			System.out.println(">> [ADD] "+data+" Added and Root is: "+root);
			System.out.println("---------------------------------------");
		}else {
			MyNode<T> temp = root;
			while(temp.link !=null) {
				temp = temp.link;
			}
			temp.link = node; // temp.link -> previous node's link
			System.out.println(">> [ADD] Previous Node Link is: "+node);
		}
		
		System.out.println(">> [ADD] Node Created at "+node+"Data: "+data+" Link is: "+node.link);
		
		
		
	}
	
	void list() {
		MyNode<T> temp = root;
		while(temp.link !=null) {
			System.out.println(">> Data at Node "+temp+" is: "+temp.data);
			temp = temp.link;
		}
		System.out.println(">> Data at Node "+temp+" is: "+temp.data);
	}
	
}

public class LinkedListProductApp {

	public static void main(String[] args) {
		
		MyLinkedList<Object> list1 = new MyLinkedList<Object>();
		MyLinkedList<String> list2 = new MyLinkedList<String>();
		MyLinkedList<Product> list3 = new MyLinkedList<Product>();
		
		list2.add("Harry");
		list2.add("Sia");
		list2.add("Kim");
		
		list2.list();
		
		System.out.println("********************");
		System.out.println();
		
		Product p1 = new Product(101, "Adidas Alphabounce", 10000);
		Product p2 = new Product(301, "iPonneX", 70000);
		Product p3 = new Product(201, "Samsung LED", 50000);

		list3.add(p1);
		list3.add(p2);
		list3.add(p3);
		
		list3.list();
		
		System.out.println("********************");
		System.out.println();
		
		list1.add(10);
		list1.add("Hello");
		list1.add(p1);
		
		list1.list();
		
	}

}
