package com.amazon.algorithms;

// PS: https://www.cs.usfca.edu/~galles/visualization/HeapSort.html

class HeapSort{
	
	int n; // size of array
	
	void sort(int[] array) {
		
		// Lets Heapify Array First i.e. convert the array into Heap
		heapify(array);
		
		for(int i=n;i>0;i--) {
			// We need to get the root element of our heap
			// which of-course will be the maximum
			// Hence, we will remove the root and swap it with last element
			swap(array, 0, i);
			n = n-1;
			// Again heapify and re do the process
			maxHeap(array, 0);
		}
		
	}
	
	void heapify(int[] array) {
		
		n = array.length-1;	 // 6
		
		// This loop shall go from the bottom non-leaf nodes of the tree
		// Max non leaf nodes of a binary tree with n nodes shall be n/2
		for(int i=n/2; i>=0; i--) {	// 3 2 1 0	
			maxHeap(array, i);
		}
	}
	
	void maxHeap(int[] array, int i) {
		
		// Represent Tree in the form of Array
		// if i is node, left child is 2i and right child is 2i + 1 | 1 ~ 2(2*1) ~ 3(2*1+1) 
		// 12, 45, 6, 77, 32, 18, 20
		// 12 is root, 45 is left child and 6 is right child
		int left = 2 * i;
		int right = (2 * i) + 1;
		
		// Consider max to be i only
		int max = i;
		
		// if left child index is less than max index of array
		// and left child of node i is greater than node i
		// so, max is left child
		if(left<=n && array[left] > array[i]) {
			max = left;
		}
		
		// With same approach check for right child
		if(right <=n && array[right] > array[max]) {
			max = right;
		}
		
		// If left or right child, who so ever is greater than current node
		// swap it and also maintain the heap i.e. from subtree to max node i.e. keep on going down and down
		if(max != i) {
			swap(array, i, max);
			maxHeap(array, max);
		}
	}
	
	void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;		
	}
	
}

public class HeapSortApp {

	public static void main(String[] args) {
		
		int[] array = {12, 45, 6, 77, 32, 18, 20};
		
		System.out.println(">> original array is: "+array+" length is: "+array.length);
		for(int element : array) {
			System.out.print(element+"  ");
		}
		
		System.out.println();
		
		HeapSort heapSort = new HeapSort();
		heapSort.sort(array);
		
		
		System.out.println(">> sorted array is: "+array+" length is: "+array.length);
		for(int element : array) {
			System.out.print(element+"  ");
		}
	}

}
