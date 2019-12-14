package com.amazon.collections;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import com.amazon.model.Product;

public class StackAPI {

	public static void main(String[] args) {

		//List<Object> stack1 = new Stack<Object>();	// Polymorphic Statement
		Stack<Object> stack1 = new Stack<Object>(); 	// Direct Object Construction
		
		//Stack<int> stack2 = new Stack<int>(); error : Generics only supports References
		// PS: For Dynamic Data Structures we cannot work with primitives and Hence Wrapper Classes step in
		Stack<Integer> stack2 = new Stack<Integer>();
		Stack<Product> stack3 = new Stack<Product>();
		Stack<String> stack4 = new Stack<String>();
		
		/*
		stack4.add("Jennie");
		stack4.add("Jim");
		stack4.add("Jack");
		stack4.add("Jennie");
		stack4.add("Anna");
		stack4.add("Bob");
		stack4.add("Dave");*/
		
		stack4.push("Jennie");
		stack4.push("Jim");
		stack4.push("Jack");
		stack4.push("Jennie");
		stack4.push("Anna");
		stack4.push("Bob");
		stack4.push("Dave");
		
		System.out.println(stack4);
		
		System.out.println(stack4.peek());
		
		//stack4.remove(6);
		stack4.pop();
		
		System.out.println(stack4.peek());
		
		for(String name : stack4) {
			System.out.println(">> name is: "+name);
		}
		
		System.out.println("===Iterator===");
		
		Iterator<String> itr = stack4.iterator();
		while(itr.hasNext()) {
			String nm = itr.next();
			System.out.println(">> nm is: "+nm);
		}
		
		Collections.sort(stack4);
		
		System.out.println(">> "+stack4.peek());
		
		// PS : Explore all the methods and operations as in LinkedList of collections framework
	}

}
