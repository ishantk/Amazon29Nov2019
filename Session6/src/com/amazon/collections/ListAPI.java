package com.amazon.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

import com.amazon.model.Product;

public class ListAPI {

	public static void main(String[] args) {
		
		//List list1 = new LinkedList();			// Polymorphic Statement

		// Generic: Raw Type i.e. can store any type of object
		// Hetrogeneous
		//LinkedList list1 = new LinkedList();						// Direct Object Construction
		LinkedList<Object> list1 = new LinkedList<Object>();						// Direct Object Construction
		
		// Type Safe
		// Homogeneous
		LinkedList<String> list2 = new LinkedList<String>();		// Direct Object Construction
		LinkedList<Product> list3 = new LinkedList<Product>();

		Product p1 = new Product(101, "Adidas Alphabounce", 10000);
		Product p2 = new Product(301, "iPonneX", 70000);
		Product p3 = new Product(201, "Samsung LED", 50000);
		
		// 1. Add Data in LinkedList
		list1.add(10);
		list1.add(20);
		list1.add("Sia");
		list1.add("Mike");
		list1.add("Mike");
		list1.add(2.2);
		list1.add(p1);
		
		list2.add("Mike");
		list2.add("Sia");
		list2.add("Leo");
		list2.add("Don");
		list2.add("Harry");
		//list2.add(2.2); // error
		//list2.add(p1);  // error	
		
		list3.add(p1);
		list3.add(p2);
		list3.add(p3);
		//list3.add("Harry"); // error
		//list3.add(2.2); 	  // error
		
		
		// 2. Read the Data in LinkedList
		System.out.println(">> list1 is: "+list1); // automatically execute toString()
		System.out.println(">> list2 is: "+list2);
		System.out.println(">> list3 is: "+list3);
		
		System.out.println();
		
		// 3. Remove Data // remove from front
		list1.remove();
		list2.remove();
		list3.remove();
		
		System.out.println(">> list1 is: "+list1); // automatically execute toString()
		System.out.println(">> list2 is: "+list2);
		System.out.println(">> list3 is: "+list3);
		
		System.out.println();
		list1.remove(4);
		
		System.out.println(">> list1 is: "+list1); // automatically execute toString()
		
		list1.addFirst(p2);
		list2.addLast("Dave");
		
		System.out.println();
		System.out.println(">> list1 is: "+list1); // automatically execute toString()
		System.out.println(">> list2 is: "+list2);
		
		//list1.clear(); // delete all
		System.out.println(">> list1 size is: "+list1.size());
		
		LinkedList<String> names = new LinkedList<String>();
		names.add("Fionna");
		names.add("Nia");
		names.add("Anaya");
		
		names.addAll(list2);
		System.out.println(">> names is: "+names);
		System.out.println(">> list2 is: "+list2);
		
		// Searching :)
		if(list2.contains("Dave")) {
			System.out.println(">> Dave is in the list2");
		}
		
		int idx = list2.indexOf("Leo");
		System.out.println(">> idx is: "+idx);
		
		String name = list2.get(idx);
		System.out.println(">> name on "+idx+" index is: "+name);
		
		System.out.println(">> Looping i.e. Iterating in List");
		
		System.out.println(">> Basic For Loop");
		for(int i=0;i<list2.size();i++) {
			System.out.println(list2.get(i));
		}
		
		System.out.println(">> Enhanced For Loop");
		for(String n : names) {
			System.out.println(">> n is: "+n);
		}
		
		for(Object o : list1) {
			System.out.println(">> o is: "+o);
		}
		
		Collections.sort(names);
		System.out.println();
		System.out.println(">> Sorted List of Names");
		for(String n : names) {
			System.out.println(">> n is: "+n);
		}
		
		System.out.println();
		
		// Update data in list
		System.out.println(">> list2 before is: "+list2);
		list2.set(1, "Leonardo");
		System.out.println(">> list2 after is: "+list2);
		
		System.out.println(">> Iterator");
		//Iterator<Object> itr = list1.iterator();
		Iterator itr = list1.iterator(); // Can only iterate in forward direction
//		System.out.println(itr.next());
//		System.out.println(itr.next());
//		System.out.println(itr.next());
		
		while(itr.hasNext()) {
			Object o = itr.next();
			System.out.println(">> o is: "+o);
		}
		
		Iterator<String> itr2 = list2.iterator();
		while(itr2.hasNext()) {
			String str = itr2.next();
			System.out.println(">> str is: "+str);
			if(str.equals("Dave")) {
				itr2.remove(); // Can only iterate in forward direction and can also remove the data from list while iterating
			}
		}
		
		System.out.println();
		
		System.out.println(">> ListIterator");
		
		ListIterator<String> listItr2 = list2.listIterator(); // Can iterate in forward and backward direction
		while(listItr2.hasNext()) {
			String str = listItr2.next();
			System.out.println(">> str is: "+str);
		}
		
		System.out.println("----");
		while(listItr2.hasPrevious()) {
			String str = listItr2.previous();
			System.out.println(">> str is: "+str);
		}
		
		
		// Re-Sizable Dynamic Array
		ArrayList<String> aList = new ArrayList<String>();
		aList.add("Mike");
		aList.add("Sia");
		aList.add("Leo");
		aList.add("Don");
		aList.add("Harry");
		// We can implement all those operations as discussed above with ArrayList as well
		
		// Vector is SYNCHRONIZED
		Vector<String> vector = new Vector<String>();
		vector.add("Mike");
		vector.add("Sia");
		vector.add("Leo");
		vector.add("Don");
		vector.add("Harry");		
	}

}
