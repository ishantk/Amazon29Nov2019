package com.amazon.algorithms;

// PS: https://visualgo.net/bn/sorting

public class MergeSortApp {
	
	// Merge the Elements to created a sorted Array
	void merge(int[] array, int left, int middle, int right) {
		System.out.println(">> Merge for Left:"+left+" Middle:"+middle+" Right:"+right);
		
		int leftSize = middle - left + 1; // Size of Left Array
		int rightSize = right - middle;	  // Size of Right Array
		
		// Create SubArrays to be Compared/Merged
		
		int[] leftArray = new int[leftSize];
		int[] rightArray = new int[rightSize];
		
		// Populate them with Data :)
		for(int i=0;i<leftSize;i++) {
			leftArray[i] = array[left+i];			// Add Data to Left Array
		}
		
		for(int i=0;i<rightSize;i++) {
			rightArray[i] = array[middle+1+i];		// Add Data to Right Array
		}
		
		// Compare and Swap Data in Arrays :)
		int idxLeft = 0, idxRight = 0;
		int idx = left;
		
		while(idxLeft<leftSize && idxRight<rightSize) {
			
			if(leftArray[idxLeft] <= rightArray[idxRight]) {
				array[idx] = leftArray[idxLeft];
				idxLeft++;
			}else {
				array[idx] = rightArray[idxRight];
				idxRight++;
			}
			idx++;
		}
		
		// Copy Remaining Elements of Left Array and Right Array into array
		while(idxLeft < leftSize) {
			array[idx] = leftArray[idxLeft];
			idxLeft++;
			idx++;
		}
		
		while(idxRight < rightSize) {
			array[idx] = rightArray[idxRight];
			idxRight++;
			idx++;
		}
	}
		
	// Divided the Array till Individual Elements :)
	void mergeSort(int[] array, int left, int right) {
		
		if(left < right) {
			
			System.out.println(">> Sorting Array: ");
			for(int i=left;i<=right;i++) {
				System.out.print(array[i]+"  ");
			}
			System.out.println();
			
			int middle = (left+right)/2;
			System.out.println(">> middle is: "+middle);
			
			// Divide Array in 2 Halves. Left and Right !!
			// Using Recursion to do so !!
			
			mergeSort(array, left, middle);			// Left Sub Array
			mergeSort(array, middle+1, right);		// Right Sub Array
			
			merge(array, left, middle, right);		// Start Merging and created Sorted Array Eventually

		}
		
	}

	public static void main(String[] args) {
		
		int[] array = {12, 45, 6, 77, 32, 18, 20, 33, 41};
		
		System.out.println(">> original array is: "+array+" length is: "+array.length);
		for(int element : array) {
			System.out.print(element+"  ");
		}
		
		System.out.println();
		
		MergeSortApp app = new MergeSortApp();
		
		app.mergeSort(array, 0, array.length-1);
		
		System.out.println(">> sorted array is: "+array+" length is: "+array.length);
		for(int element : array) {
			System.out.print(element+"  ");
		}
		

	}

}
