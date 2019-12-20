package com.amazon.datastructures;

import com.amazon.model.Node;

class LinkedList{
	
	Node<Integer> head;
	
	static Node<Integer> previous;
	
	void add(Integer data) {
		
		if(head==null) {
			Node<Integer> node = new Node<Integer>(data, null, null);
			head = node;
			previous = node;
			node.printNode();
		}else {
			Node<Integer> node = new Node<Integer>(data, null, previous);
			previous.next = node;
			previous = node;
			node.printNode();
		}
	}
	
	void iterateForward() {
		
		Node<Integer> temp = head;
		
		while(temp.next != null) {
			System.out.println(">> Data: "+temp.data);
			temp = temp.next;
		}
		System.out.println(">> Data: "+temp.data);

	}
	
	void iterateForward(Node<Integer> node) {
		
		Node<Integer> temp = node;
		
		while(temp.next != null) {
			System.out.println(">> Data: "+temp.data);
			temp = temp.next;
		}
		System.out.println(">> Data: "+temp.data);
		
	}
	
	void iterateBackward() {
		
		Node<Integer> temp = previous;
		
		while(temp.previous != null) {
			System.out.println(">> Data: "+temp.data);
			temp = temp.previous;
		}
		System.out.println(">> Data: "+temp.data);
	}
	
	Node<Integer> splitList(Node<Integer> head) {
		
		Node<Integer> first = head;
		Node<Integer> second = head;
		
		while(first.next!=null && first.next.next != null) {
			first = first.next.next;
			second = second.next;
		}
		
		Node<Integer> temp = second.next;
		second.next = null;
		return temp;
		
	}
	
	Node<Integer> merge(Node<Integer> first, Node<Integer> second) {
		
		if(first == null) {
			return second;
		}
		
		if(second == null){
			return first;
		}
		
		// Lets compare data in both nodes in case they are not null
		if(first.data < second.data) {
			first.next = merge(first.next, second);
			first.next.previous = first;
			first.previous = null;
			return first;
		}else {
			second.next = merge(first, second.next);
			second.next.previous = second;
			second.previous = null;
			return second;
		}
	}
	
	Node<Integer> mergeSort(Node<Integer> node) {
		
		if(node == null || node.next == null) {
			return node;
		}
		
		// Get the second List
		Node<Integer> second = splitList(node);
		
		// Lets put Recursion on Left and Right List
		node = mergeSort(node);
		second = mergeSort(second);
		
		return merge(node, second);
	}
	
}

public class DoublyLinkedListApp {

	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		
		/*
		Node<Integer> node1 = new Node<Integer>(20, null, null);
		list.head = node1;
		
		Node<Integer> node2 = new Node<Integer>(30, null, node1);
		node1.next = node2;
		
		Node<Integer> node3 = new Node<Integer>(10, null, node2);
		node2.next = node3;
		
		Node<Integer> node4 = new Node<Integer>(50, null, node3);
		node3.next = node4;
		
		Node<Integer> node5 = new Node<Integer>(40, null, node4);
		node4.next = node5;*/
		
		list.add(20);
		list.add(30);
		list.add(10);
		list.add(50);
		list.add(40);
		
		/*
		System.out.println("--Iterating Forward Direction--");
		
		list.iterateForward();
		
		System.out.println("--Iterating Backward Direction--");
		
		list.iterateBackward();
		*/
		
		System.out.println(">> ORIGINAL LINKED LIST");
		list.iterateForward();
		
		
		System.out.println(">> SORTED LINKED LIST");
		Node<Integer> sortedNode = list.mergeSort(list.head);
		list.iterateForward(sortedNode);

	}

}
