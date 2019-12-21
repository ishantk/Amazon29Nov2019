package com.amazon.datastructures;

import java.util.LinkedList;
import java.util.List;

import com.amazon.model.Employee;

// PS: Explore :- Wild Cards and Generics in Java 

class HashTableGeneric<T extends Employee>{
	// Capacity of HashTable
	private final int capacity = 10; // 0 to 9
		
	// Size will change as we put and remove data from HashTable
	private int size = 0;
		
	// Array serving as Bucket for our HashTable
	// For this bucket we have only 1 slot i.e. you can store only 1 Integer Object
	Object[] bucket = new Object[capacity]; // Array with indexes 0 to 9
	
	int hash(Integer key) {
		int idx = key % capacity;
		return idx; // bucket number
	}
	
	// Store key Value Pair
	boolean put(Integer key, T value) {
		
		int idx = hash(key);
		
		if(bucket[idx] == null) {
			bucket[idx] = value;		// Empty bucket insert data :)
			size++;
			System.out.println(">> Added Key: "+key+" On: "+idx);
			return true;
		}else {
			System.out.println(">> Occupied Idx: "+idx+" for Key: "+key);
			return false; // bucket already contains data :(
		}
		
	}
	
	// Fetch Data from Bucket
	Object get(Integer key) {
		int idx = hash(key);
		return bucket[idx];
	}
	
	int size() {
		return size;
	}
	
	int capacity() {
		return capacity;
	}
	
	boolean remove(Integer key) {
		
		int idx = hash(key);
		T emp = (T)bucket[idx];
		
		if(bucket[idx] != null && key==emp.eid) {
			bucket[idx] = null;
			size--;
			System.out.println(">> Key: "+key+" Removed from Idx: "+idx);
			return true;
		}else {
			System.out.println(">> No Key: "+key+" Found for Idx: "+idx);
			return false;
		}
	}
	
	// Which shall return all the keys available in the HashTable :)
	List<Integer> keys() {
		
		List<Integer> keys = new LinkedList<Integer>();
		// ...
		// so that you return back all the keys
		
		for(Object key : bucket) {
			if(key != null) {
				T emp = (T)key;
				keys.add(emp.eid);
				System.out.println(">> Data: "+emp.toString());
			}
		}
		
		return keys;
	}
	
	void iterate() {
		for(Object key : bucket) {
			if(key != null) {
				T emp = (T)key;
				System.out.println(">> Data: "+emp.toString());
			}
		}
	}
	
	@Override
	public String toString() {
		
		StringBuffer buffer = new StringBuffer();
		
		for(Object key : bucket) {
			if(key != null) {
				T emp = (T)key;
				buffer.append(emp.toString()+", ");
			}
		}
		
		return buffer.toString();
	}
	
}

public class HashTableGenericApp {

	public static void main(String[] args) {
		
		HashTableGeneric<Employee> table = new HashTableGeneric<Employee>();
		
		Employee eRef1 = new Employee(101, "Sam", 30000);
		Employee eRef2 = new Employee(111, "Dave", 40000);
		Employee eRef3 = new Employee(345, "Fionna", 33000);
		Employee eRef4 = new Employee(233, "Mike", 50000);
		Employee eRef5 = new Employee(377, "Leo", 47000);
		
		System.out.println(">> CAPACITY: "+table.capacity());
		System.out.println(">> SIZE: "+table.size());
		
		table.put(eRef1.eid, eRef1);
		table.put(eRef2.eid, eRef2);
		table.put(eRef3.eid, eRef3);
		table.put(eRef4.eid, eRef4);
		table.put(eRef5.eid, eRef5);
	
		
		System.out.println(">> CAPACITY: "+table.capacity());
		System.out.println(">> SIZE: "+table.size());
		
		table.iterate();
		
		List<Integer> keys = table.keys(); // Shall Print a List of Keys :)
		System.out.println(">> Keys are: "+keys);
		
		for(Integer key : keys) {
			Employee emp = (Employee)table.get(key);
			System.out.println(">> Key: "+key+" | "+emp);
		}
		
		System.out.println(">> table is: "+table);
		

	}

}
