package com.amazon.javautilcollections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class SetApp {

	public static void main(String[] args) {
		
		LinkedList<String> list = new LinkedList<String>();
		list.add("Mike");
		list.add("Leo");
		list.add("Sia");
		list.add("Kim");
		list.add("Mike"); // Duplicate Data is Supported in the List
		list.add("Dave");

		System.out.println(">> list is: "+list);
		
		// PS: for UNIQUE Data Storage use Hashing :)
		
		//Set<String> set = new HashSet<String>();		// Polymorphic Statement
		//HashSet<String> set = new HashSet<String>();	// Direct Object Construction
		
		TreeSet<String> set = new TreeSet<String>();	// Sorted Version of HashSet :)
		set.add("Mike");
		set.add("Leo");
		set.add("Sia");
		set.add("Kim");
		set.add("Mike"); // Duplicate Data is Supported in the List
		set.add("Dave");
		
		System.out.println(">> set is: "+set);
		// We do not have access to the keys
		
		System.out.println(">> size:"+set.size());
		System.out.println(">> Leo in the Set: "+set.contains("Leo"));
		set.remove("Leo");
		
		Iterator<String> itr = set.iterator();
		while(itr.hasNext()) {
			String name = itr.next();
			System.out.println("Name: "+name);
		}
		
		
		
	}

}
