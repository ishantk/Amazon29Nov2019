package com.amazon.algorithms;

public class InsertionSort {
	
	static void sortPrices(int[] prices) {
		
		for(int i=1; i<prices.length; i++) {
			// System.out.println(">> For i: "+i);
			int key = prices[i]; 			// When i is:1, key is: 9876
			int j = i-1;		 			// j is:0
			
			while(j>=0 && prices[j]>key) {  // prices[0]:2345 which is not greater
				prices[j+1] = prices[j];
				j--;
			}
			prices[j+1] = key;			    // prices[1] : 9876
		}
		
	}
	
	static void printPrices(int[] prices) {
		
		for(int element : prices) {
			System.out.print(element+"  ");
		}
		
		System.out.println();
	}

	public static void main(String[] args) {
		
		int[] prices = {2345, 9876, 1231, 3212, 5432};
		sortPrices(prices);
		printPrices(prices);

	}

}

// Exercises: 
// Implement BubbleSort, SelectionSort, InsertionSort, MergeSort and QuickSort !!
// Compare their Time Complexity Analysis !! [geeks for geeks] [medium] [hasckerearth and hasckerrank]