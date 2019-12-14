package com.amazon.collections;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

import com.amazon.model.Product;

public class QueueAPI {

	public static void main(String[] args) {
		
		//Queue<Integer> queue = new PriorityQueue<Integer>(); 			// Polymorphic Statement
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(); 	// Direct Object Construction
		
		for(int i=10;i>0;i--) {
			queue.add(i);
		}
		
		// Head 10 9 8 7 6 5 4 3 2 1 Tail

		// PriorityQueue Sorts the Data :)
		
		// Head 1 2 3 4 5 6 7 8 9 10 Tail

		/*
		System.out.println(">> Head is: "+queue.peek()); // 1
		System.out.println(">> SIZE "+queue.size());	 // 10
		
		int removedHead = queue.poll(); // Removes the Head of Queue // -> 2 3 4 5 6 7 8 9 10 
		System.out.println(">> Removed Head is: "+removedHead);      // 1
		System.out.println(">> SIZE "+queue.size());				 // 9
		
		System.out.println(">> Head is: "+queue.peek()); // 2
		*/
		
		/*
		int size = queue.size();
		//for(int i=0;i<queue.size();i++) {
		for(int i=0;i<size;i++) {	
			System.out.println(">> "+queue.peek()); // Get Head of Queue
			queue.poll();						    // Remove Head of Queue 
		}*/
		
		if(queue.contains(100)) {
			System.out.println(">> 10 is in the Queue");
		}else {
			System.out.println(">> Not Available");
		}
		
		// EXPLORE : Why we get unordered output here :)
		System.out.println(">> QUEUE: "+queue);
		
		Iterator<Integer> itr = queue.iterator();
		while(itr.hasNext()) {
			Integer data = itr.next();
			System.out.println(">> data: "+data);
		}
	
		PriorityQueue<String> queue1 = new PriorityQueue<String>();
		queue1.add("Dave");
		queue1.add("Kim");
		queue1.add("Sia");
		queue1.add("Anaya");
		queue1.add("Bob");
		
		System.out.println(">> Queue Head: "+queue1.peek()); // Anaya
		
		//PriorityQueue<Product> queue2 = new PriorityQueue<Product>(comparator); // Use Comparator
		
	}

}

// Assignment : Create a ThreadPool Queue and process Tasks synchronously :)