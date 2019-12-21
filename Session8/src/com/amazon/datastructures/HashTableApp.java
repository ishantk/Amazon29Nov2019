package com.amazon.datastructures;

class HashTable{
	
	// Capacity of HashTable
	private final int capacity = 10; // 0 to 9 buckets
	
	// Size will change as we put and remove data from HashTable
	private int size = 0;
	
	// Array serving as Bucket for our HashTable
	// For this bucket we have only 1 slot i.e. you can store only 1 Integer Object
	Integer[] bucket = new Integer[capacity]; // Array with indexes 0 to 9
	
	int hash(Integer key) {
		int idx = key % capacity;
		return idx; // bucket number
	}
	
	// Here key and data is same | as of now 
	// key and value is same | they are only 1
	boolean put(Integer value) {
		
		int idx = hash(value);
		
		if(bucket[idx] == null) {
			bucket[idx] = value;	// Empty bucket insert data :)
			size++;
			System.out.println(">> Added Key: "+value+" On: "+idx);
			return true;
		}else {
			System.out.println(">> Occupied Idx: "+idx+" for Key: "+value);
			return false; // bucket already contains data :(
		}
		
	}
	
	void iterate() {
		for(Integer key : bucket) {
			if(key != null) {
				System.out.println(">> Data: "+key);
			}
		}
	}
	
	// Fetch Data from Bucket
	Integer get(Integer key) {
		int idx = hash(key);
		return bucket[idx];
	}
	
	boolean contains(Integer value) {
		int idx = hash(value);
		return (bucket[idx] != null);
				
	}
	
	int size() {
		return size;
	}
	
	int capacity() {
		return capacity;
	}
	
	boolean remove(Integer key) {
		int idx = hash(key);
		if(bucket[idx] != null) {
			bucket[idx] = null;
			size--;
			System.out.println(">> Key: "+key+" Removed from Idx: "+idx);
			return true;
		}else {
			System.out.println(">> No Key: "+key+" Found for Idx: "+idx);
			return false;
		}
	}
	
}


public class HashTableApp {

	public static void main(String[] args) {
		

		HashTable table = new HashTable();
		System.out.println(">> CAPACITY: "+table.capacity());
		System.out.println(">> SIZE: "+table.size());
		
		table.put(450); 
		table.put(110); 
		table.put(76);
		table.put(123);
		table.put(111);
		table.put(88);
		table.put(17);
		
		System.out.println();
		
		System.out.println(">> CAPACITY: "+table.capacity());
		System.out.println(">> SIZE: "+table.size());
		
		table.iterate();
		
		table.remove(450);
		table.remove(88);
		
		System.out.println();
		System.out.println(">> CAPACITY: "+table.capacity());
		System.out.println(">> SIZE: "+table.size());
		
		table.iterate();
	}

}
