package com.amazon.datastructures;

import com.amazon.model.Node;

// PS: https://www.cs.usfca.edu/~galles/visualization/StackLL.html

class Stack{
	
	static int size = 0;
	Node top;
	
	void push(int data) {
		
		Node node = new Node();
		node.data = data;
		size++;
		
		if(top==null) {
			top = node;
		}else {
			node.link = top;
			top = node;		
		}
		
		System.out.println(">> [PUSH] Node Created: "+node+" | Data: "+node.data+" | Link: "+node.link);
		System.out.println(">> [PUSH] Top is: "+top);
		System.out.println();
	}
	
	void pop() {
		
		if(top == null) {
			System.out.println(">> STACK EMPTY");
		}else {
			Node temp = top;
			top = temp.link; // Assign Next Link
			
			System.out.println(">> [POP] Node Popped: "+temp+" | Data: "+temp.data);
			System.out.println(">> [POP] Top is: "+top);
			System.out.println();
			size--;
			
			temp = null; // let GC delete the node
		}

	}
	
	int size() {
		return size;
	}
	
	@Override
	public String toString() {
	
		StringBuffer buffer = new StringBuffer();
		Node temp = top;
		
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

public class StackApp {

	public static void main(String[] args) {
		
		Stack stack = new Stack();
		
		System.out.println("[[PUSHING DATA]]");
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		
		System.out.println("SIZE: "+stack.size());
		
		System.out.println();
		
		System.out.println("[[POPPING DATA]]");
		stack.pop();
		stack.pop();
		
		System.out.println("SIZE: "+stack.size());
		
		System.out.println();
		
		System.out.println("[[STACK CONTENT]]");
		System.out.println(stack);
		System.out.println("SIZE: "+stack.size());

	}

}

// Assignment : Implement Stack with Generics/Templates
