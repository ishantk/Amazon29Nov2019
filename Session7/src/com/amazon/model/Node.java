package com.amazon.model;

public class Node<T> {

	public T data;
	public Node next;
	public Node previous;
	
	public Node(){
		/*data = null;
		next = null;
		previous = null;*/
	}

	public Node(T data, Node next, Node previous) {
		this.data = data;
		this.next = next;
		this.previous = previous;
	}
	
	public void printNode() {
		System.out.println(">> [NODE]: "+this+" Data:"+data+" Previous:"+previous+" Next:"+next);
	}
	
}
