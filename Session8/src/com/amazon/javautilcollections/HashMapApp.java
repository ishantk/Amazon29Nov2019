package com.amazon.javautilcollections;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import com.amazon.model.Employee;

public class HashMapApp {

	public static void main(String[] args) {
		
		// keys are unique and values can be duplicated
		// re-using the same key means, value will be updated
		// we can even have null key and null values
		
		HashMap<Integer, String> map1 = new HashMap<Integer, String>();
		HashMap<Integer, Employee> map2 = new HashMap<Integer, Employee>();
		HashMap<String, Employee> map3 = new HashMap<String, Employee>();
		
		map1.put(101, "Mike");
		map1.put(201, "Sia");
		map1.put(111, "Kim");
		map1.put(999, "Leo");
		map1.put(321, "Fionna");
		
		map1.put(101, "Dave"); // Update the Value at the Key 101
		
		System.out.println(">> Map1 is: "+map1);
		
		Employee eRef1 = new Employee(101, "Sam", 30000);
		Employee eRef2 = new Employee(111, "Dave", 40000);
		Employee eRef3 = new Employee(345, "Fionna", 33000);
		Employee eRef4 = new Employee(233, "Mike", 50000);
		Employee eRef5 = new Employee(377, "Leo", 47000);
		
		map2.put(eRef1.eid, eRef1);
		map2.put(eRef2.eid, eRef2);
		map2.put(eRef3.eid, eRef3);
		map2.put(eRef4.eid, eRef4);
		map2.put(eRef5.eid, eRef5);
		
		System.out.println(">> Map2 is: "+map2);
		
		Set<Integer> keys1 = map1.keySet();
		Set<Integer> keys2 = map2.keySet();
		
		System.out.println(">> keys1: "+keys1);
		System.out.println(">> keys2: "+keys2);
		
		// Get Single Element on the basis of key
		String name = map1.get(321);
		Employee emp = map2.get(eRef3.eid);
		
		System.out.println(">> name is: "+name);
		System.out.println(">> emp is: "+emp);
		
		// Iterate and get all the elements
		Iterator<Integer> itr1 = keys1.iterator();
		Iterator<Integer> itr2 = keys2.iterator();
		
		System.out.println();
		
		System.out.println(">> Iterating in map1");
		while(itr1.hasNext()) {
			Integer key = itr1.next();
			String value = map1.get(key);
			System.out.println(key+"\t\t"+value);
		}
		
		System.out.println();
		
		System.out.println(">> Iterating in map2");
		while(itr2.hasNext()) {
			Integer key = itr2.next();
			Employee value = map2.get(key);
			System.out.println(key+"\t\t"+value);
		}
		

		HashMap<Integer, String> map = new HashMap<Integer, String>();			// Not SYNCHRONIZED
		map.put(101, "Mike");
		map.put(201, "Sia");
		map.put(111, "Kim");
		map.put(null, "Harry"); // null key allowed		(Only 1)
		map.put(130, null);     // null value allowed   (Multiple)
		
		
		Hashtable<Integer, String> table = new Hashtable<Integer, String>();	// SYNCHRONIZED (THREAD-SAFE)
		table.put(101, "Mike");
		table.put(201, "Sia");
		table.put(111, "Kim");
		//table.put(null, "Harry"); // null key not allowed		(Only 1)
		//table.put(130, null);     // null value not allowed   (Multiple)
		
		System.out.println(">> map is: "+map);
		System.out.println(">> table is: "+table);
		
		System.out.println("is 101 in map: "+map.containsKey(101));
		System.out.println("is Sia in map: "+map.containsValue("Sia"));
		
		System.out.println("is 101 in table: "+table.containsKey(101));
		System.out.println("is Sia in table: "+table.containsValue("Sia"));
		
		System.out.println(">> SIZE: "+map.size()+" | "+table.size());
		
		System.out.println("---Iterate with Entry---");
		
		Set<Entry<Integer, String>> set = table.entrySet(); //map.entrySet();
		
		// PS: Assignment : Implement iterator in custom data structure | Design Pattern
		Iterator<Entry<Integer, String>> itr = set.iterator(); 
		
		while(itr.hasNext()) {
			Entry<Integer, String> entry = itr.next();
			Integer key = entry.getKey();
			String value = entry.getValue();
			
			System.out.println(key+"\t\t"+value);
		}
		
		
	}

}
