package com.amazon.datastructures;


class HashTableLP{
	
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

	void put(Integer value) {
		
		int idx = hash(value);
		
		if(bucket[idx] == null) {
			bucket[idx] = value;	// Empty bucket insert data :)
			size++;
			System.out.println(">> Added Value: "+value+" On: "+idx);
		}else {
			++idx;
			if(idx>=capacity) {
				System.out.println(">> We ran out of Capacity :( ");
			}else {
				put(value, idx);
			}
		}
		
	}

	// Overloading : Overload the method put
	// To Move it cyclic : Please check for the size and set idx to 0
	void put(Integer value, int idx) {
		
		if(idx>=capacity) {
			System.out.println(">> We ran out of Capacity :( ");
		}else {
			if(bucket[idx] == null) {
				bucket[idx] = value;	// Empty bucket insert data :)
				size++;
				System.out.println(">> Added Value: "+value+" On: "+idx);
			}else {
				put(value, ++idx);
			}
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
	
	// Implement overloaded remove the same way as put
	boolean remove(Integer key) {
		
		int idx = hash(key);
		
		if(bucket[idx] != null) {
			bucket[idx] = null;
			size--;
			System.out.println(">> Key: "+key+" Removed from Idx: "+idx);
			return true;
		}else {
			// Iteration to find if it exists in the next slot somewhere | Cyclic
			return false;
		}
	}
	
}

public class LinearProbingApp {

	public static void main(String[] args) {
		
		HashTableLP table = new HashTableLP();
		
		System.out.println(">> CAPACITY: "+table.capacity());
		System.out.println(">> SIZE: "+table.size());
		
		table.put(450); 
		table.put(110); 
		table.put(76);
		table.put(123);
		table.put(13);
		table.put(88);
		table.put(23);
		table.put(93);
		table.put(93);
		table.put(93);

	}

}
