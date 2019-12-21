package com.amazon.datastructures;

import java.util.LinkedList;

import com.amazon.model.Employee;

// PS: https://www.cs.usfca.edu/~galles/visualization/OpenHash.html

// We will Handle Collisions
class ChainedHashTable<K, V extends Employee>{
	
	// Capacity of HashTable
	private final int capacity = 10; // 0 to 9 as in buckets
	
	// Size will change as we put and remove data from HashTable
	private int size = 0;

	// Array on LinkedLists
	// LinkedList is Generic i.e. it can store any type of Object 
	LinkedList[] bucket = new LinkedList[capacity];
	
	
	int hash(K key) {
		int idx = (Integer)key % capacity; // we are assuming keys must be Integer, since we have downcasted
		return idx; // bucket number
	}
	
	// stores data as key value pair
	void put(K key, V value) {
		
		int idx = hash(key);
		
		if(bucket[idx] == null) {
			// id idx avilable is having no LinkedList, create a one !!
			bucket[idx] = new LinkedList<V>(); // V for us is Employee
		}
		
		size++;
		bucket[idx].add(value);
		System.out.println(">> Value: "+value+" Added at Idx: "+idx+" For Key: "+key);
		
	}
	
	void iterate() {
		
		//for(LinkedList<V> list : bucket) {
		for(int i=0;i<bucket.length;i++) { // Iterating in the bucket  
			LinkedList<V> list = bucket[i];
			if(list!=null) {
				System.out.println(">> Iterating in Bucket["+i+"]");
				for(Employee emp : list) { // Iterating into LinkedList i.e. slots
					System.out.print(emp+"  ");
				}
				System.out.println();
			}
		}
		
	}
	
	void remove(K key) {
		System.out.println(">> Key to be Removed: "+key);
		int idx = hash(key);
		
		LinkedList<V> list = bucket[idx];
		System.out.println(">> List Found with Size: "+list.size());
		
		
		for(int i=0;i<list.size();i++){
			
			Employee emp = list.get(i);
			
			int k = (Integer)key; // DownCasting [UnBoxing] 
			
			if(k == emp.eid) {
				list.remove(i);
				System.out.println(">> KEY "+key+" Removed");
				size--;
				break;
			}
		}
	}
	
	boolean containsKey(K key) {
		
		boolean isAvailable = false;
		
		
		return isAvailable;
	}
	
	boolean containsValue(V value) {
		
		boolean isAvailable = false;
		
		
		return isAvailable;
	}
	
	int size() {
		return size;
	}
	
	int capacity() {
		return capacity;
	}
}

public class CahinedHashTableApp {

	public static void main(String[] args) {

		ChainedHashTable<Integer, Employee> table = new ChainedHashTable<Integer, Employee>();
		
		Employee eRef1 = new Employee(105, "Sam", 30000);
		Employee eRef2 = new Employee(111, "Dave", 40000);
		Employee eRef3 = new Employee(345, "Fionna", 33000);
		Employee eRef4 = new Employee(233, "Mike", 50000);
		Employee eRef5 = new Employee(377, "Harry", 47000);
		Employee eRef6 = new Employee(297, "Kim", 67000);
		Employee eRef7 = new Employee(177, "Anna", 97000);
		
		table.put(eRef1.eid, eRef1);
		table.put(eRef2.eid, eRef2);
		table.put(eRef3.eid, eRef3);
		table.put(eRef4.eid, eRef4);
		table.put(eRef5.eid, eRef5);
		table.put(eRef6.eid, eRef6);
		table.put(eRef7.eid, eRef7);
		
		System.out.println(">> CAPACITY: "+table.capacity());
		System.out.println(">> SIZE: "+table.size());
		
		table.iterate();
		
		System.out.println();
		
		table.remove(297);
		
		System.out.println();
		table.iterate();
		
		
		
	}

}
