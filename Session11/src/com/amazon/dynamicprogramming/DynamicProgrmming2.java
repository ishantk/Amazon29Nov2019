package com.amazon.dynamicprogramming;

// KnapSack Problem With Dynamic Programming
class KnapSack{

	// Implement Brute Force
	int knapSack(int[] profits, int[] weights, int capacity) {
		return knapSackSoln(profits, weights, capacity, 0); // start solving from 0th index i.e. Select A	
	}
	
	int knapSackSoln(int[] profits, int[] weights, int capacity, int idx) {
		
		// Base Condition for Recursive Algo
		if(capacity<=0 || idx>=profits.length)
			return 0;
		
		int profit1=0, profit2=0;
		
		// Case of Selection i.e. Including
		// Working with element at idx
		// for weight, it should'nt increase the capacity
		if(weights[idx] <= capacity) 
			// for recursive call we move to the next index and decrease the capacity by subtracting weight, which is checked above !!
			// recursively processing the remaining capacity and items
			profit1 = profits[idx] + knapSackSoln(profits, weights, capacity-weights[idx], idx+1);

		// Case of Skipping i.e. Excluding
		// Working again without the element at idx
		profit2 = knapSackSoln(profits, weights, capacity, idx+1); 
		
		// return max profit :)
		return (profit1 > profit2) ? profit1 : profit2;
	}
	
	// 1. Implement Dynamic Programming
	//    Top Down Approach with Memoization | Cache results of already solved problems
	int knapSackMemoization(int[] profits, int[] weights, int capacity) {
		// 2-D Array to store results of sub-problems
		// we have 2 changing values: 1. Capacity and 2. index
		// we must save results for all sub arrays. For every possible idx and for every possible capacity
		// Let Integer Objects be in Cache rather than prmitives
		Integer[][] cache = new Integer[profits.length][capacity+1];
		
		return knapSackMemoizationSoln(cache, profits, weights, capacity, 0); // start solving from 0th index i.e. Select A	
	}
	
	int knapSackMemoizationSoln(Integer[][] cache, int[] profits, int[] weights, int capacity, int idx) {
		
		// Base Condition for Recursive Algo
		if(capacity<=0 || idx>=profits.length)
			return 0;
		
		
		// Check if we have data in Cache or nor
		// Keep a null check rather than !=0 checks. May be a case where computation of a problem result into 0
		if(cache[idx][capacity] != null ) {
			return cache[idx][capacity];
		}
		
		int profit1=0, profit2=0;
		
		// Case of Selection i.e. Including
		// Working with element at idx
		// for weight, it should'nt increase the capacity
		if(weights[idx] <= capacity) 
			// for recursive call we move to the next index and decrease the capacity by subtracting weight, which is checked above !!
			// recursively processing the remaining capacity and items
			profit1 = profits[idx] + knapSackSoln(profits, weights, capacity-weights[idx], idx+1);

		// Case of Skipping i.e. Excluding
		// Working again without the element at idx
		profit2 = knapSackSoln(profits, weights, capacity, idx+1); 
		
		// return max profit :)
		// Each Computed Result shall be in the Cache :)
		
		cache[idx][capacity] = (profit1 > profit2) ? profit1 : profit2;
		return cache[idx][capacity];
		
		
	}

}

public class DynamicProgrmming2 {

	public static void main(String[] args) {
		
		KnapSack kRef = new KnapSack();
		
		// Consider Items -> A, B, C and D as 4 items indexed 0, 1, 2, 3
		int[] profits = {1, 6, 10, 16};
		int[] weights = {1, 2, 3, 5};
		int capacity = 7;
		
//		int maxProfit = kRef.knapSack(profits, weights, capacity);
		int maxProfit = kRef.knapSackMemoization(profits, weights, capacity);
		System.out.println(">> Max Profit is: "+maxProfit);

	}

}
