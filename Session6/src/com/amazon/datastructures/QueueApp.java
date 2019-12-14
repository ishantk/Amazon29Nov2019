package com.amazon.datastructures;

import com.amazon.model.Node;

// PS: https://www.cs.usfca.edu/~galles/visualization/QueueLL.html

//class Queue<T>{ Please Try out :)

class Queue{
	
	private static int size;
	Node head, tail;
	
	void enqueue(int data) {
		
		Node node = new Node();
		node.data = data;
		size++;
		
		if(head==null) {
			head = node;
			tail = node;
		}else {
			Node temp = head;
			
			while(temp.link != null) {
				temp = temp.link;
				//System.out.println("** temp is: "+temp);
			}
			temp.link = node; // Last Node
			tail = node;
		}
		
		System.out.println(">> [ENQUEUE] Node Created: "+node+" Data: "+node.data+" Link: "+node.link);
		System.out.println(">> [ENQUEUE] Head: "+head+" Tail: "+tail);
	}
	
	void dequeue() {
		
		Node temp = head;
		
		if(head !=null) {
			head = head.link;
			size--;
			
			System.out.println(">> [DEQUEUE] Node Deletd: "+temp+" Data: "+temp.data+" Link: "+temp.link);
			System.out.println(">> [DEQUEUE] Head: "+head+" Tail: "+tail);
			
			temp = null; // Let GC delete the node
		}else {
			System.out.println(">> Nothing to Delete");
		}
	}
	
	void peek() {
		if(head != null) {
			System.out.println(">> [HEAD] : "+head+" Data: "+head.data);
		}
	}
	
	int size() {
		return size;
	}
	
	boolean contains(int data) {
		boolean check=false;
		
		return check;
	}
	
	@Override
	public String toString() {
		
		StringBuffer buffer = new StringBuffer();
		Node temp = head;
		
		if(temp!=null) {
			buffer.append(temp.data+" ");
			
			while(temp.link !=null) {
				temp = temp.link;
				buffer.append(temp.data+" ");
			}
		}
		
		return buffer.toString();
	}
}

public class QueueApp {

	public static void main(String[] args) {
		
		Queue queue = new Queue();
		
		System.out.println(">> ADDING DATA TO QUEUE");
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		
		System.out.println(">> SIZE: "+queue.size());
		
		System.out.println();
		
		System.out.println(">> DELETING DATA FROM QUEUE");

		queue.dequeue();
		queue.dequeue();

		System.out.println(">> SIZE: "+queue.size());
		
		queue.peek();
		
		System.out.println();
		System.out.println(">> QUEUE CONTENTS");
		System.out.println(queue);
		
	}

}
