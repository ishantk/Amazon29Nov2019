package com.amazon.datastructures;

import com.amazon.model.Node;

// PS: https://www.codelike.in/animation/linked-list

//class LinkedList<T>{
class LinkedList{
	
	Node root;
	private static int size;
	
	//private static Node previousNode;
	
	void add(int data) {
		
		Node node = new Node();
		node.data = data;
		size++;
		
		if(root == null) {
			root = node;
			System.out.println("---------------------------------------");
			System.out.println(">> [ADD] Node Created at "+node+" link is: "+node.link);
			System.out.println(">> [ADD] "+data+" Added and Root is: "+root);
			System.out.println("---------------------------------------");
		}else {
			Node temp = root;
			while(temp.link !=null) {
				temp = temp.link;
			}
			temp.link = node; // temp.link -> previous node's link
			System.out.println(">> [ADD] Previous Node Link is: "+node);
		}
		
		System.out.println(">> [ADD] Node Created at "+node+"Data: "+data+" Link is: "+node.link);
		
		
		/*
		if(root == null) {
			root = node;
			System.out.println("---------------------------------------");
			System.out.println(">> [ADD] Node Created at "+node+" link is: "+node.link);
			System.out.println(">> [ADD] "+data+" Added and Root is: "+root);
			System.out.println("---------------------------------------");
			previousNode = node;
		}else {
			previousNode.link = node;
			previousNode = node;
			System.out.println(">> [ADD] Previous Node Link is: "+node);
		}*/
		
		System.out.println(">> [ADD] Node Created at "+node+" link is: "+node.link);
		System.out.println();
	}
	
	int size() {
		return size;
	}
	
	void list() {
		Node temp = root;
		while(temp.link !=null) {
			System.out.println(">> Data at Node "+temp+" is: "+temp.data);
			temp = temp.link;
		}
		System.out.println(">> Data at Node "+temp+" is: "+temp.data);
	}
	
	void addInBeginning(int data) {
		Node node = new Node();
		node.data = data;
		size++;
		
		if(root==null) {
			root = node;
		}else {
			node.link = root;
			root = node;
		}
		
		System.out.println(">> [ADD-BEGINNING] Node Created at "+node+" Data is: "+data+" link is: "+node.link);
		System.out.println(">> [ADD-BEGINNING] Root is: "+root);
		System.out.println();
	}
	
	// Assignment
	void addInEnding(int data) {
		
	}
	
	// Assignment
	void addInBetween(int data, int position) {
		
	}
	
	// Assignment
	boolean contains(int data) {
		boolean check = false;
		
		return check;
	}
	
	void deleteInBeginnig() {
		
		System.out.println(">> [DELETE] Node at "+root+" Data: "+root.data+" link is: "+root);
		
		// Root's link should become the root :)
		Node temp = root.link;
		root = temp;
		size--;
		
		
	}
	
	void delete() {
		
		Node temp = root; 
		
		if(temp.link == null) {
			root = null;
		}else {
			while(temp.link.link!=null) {
				temp = temp.link;
			}
			System.out.println(">> [DELETE-END] Node at "+temp.link+" Data: "+temp.link.data+" link is: "+temp.link);
			temp.link = null;
		}
		size--;
	}
	
	@Override
	public String toString() {
		
		StringBuffer buffer = new StringBuffer();
		
		Node temp = root;
		while(temp.link !=null) {
			buffer.append(temp.data+" ");
			System.out.println(">> Data at Node "+temp+" is: "+temp.data);
			temp = temp.link;
		}
		System.out.println(">> Data at Node "+temp+" is: "+temp.data);
	
		return buffer.toString();
	}
}

public class LinkedListApp {

	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		
		
		System.out.println();
		System.out.println("==Add Data==");
		
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		
		//list.list();
		System.out.println(">> list is: "+list);

		//System.out.println(">> LIST is: "+list);
		
		/*
		System.out.println(">> [SIZE] "+list.size());
		
		System.out.println();
		System.out.println("===List====");
		list.list();
		
		list.addInBeginning(45);
		System.out.println(">> [SIZE] "+list.size());
		
		System.out.println();
		System.out.println("===List After Add in Beginning====");
		list.list();
		
		list.deleteInBeginnig();
		System.out.println(">> [SIZE] "+list.size());
		
		System.out.println();
		System.out.println("===List After Delete in Beginning====");
		list.list();
		
		list.delete();
		System.out.println();
		System.out.println("===List After Delete in END====");
		list.list();
		*/
	}

}
