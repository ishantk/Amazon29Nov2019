package com.amazon.dynamicprogramming;

// Fiboncaai With Dynamic Programming
// 0 1 1 2 3 5 8 13 .....
// 0 1 2 3 4 5 6 7  .....


class Fibonacci{
	
	// Recursion as Solution : Break Problem into sub problems
	// Brute Force Algo
	int fibonacciNum(int n) {
		
		if(n<2) 
			return n;
		
		return fibonacciNum(n-1) + fibonacciNum(n-2); 
			
	}
	
	// 1. Implement Dynamic Programming
	//    Top Down Approach with Memoization | Cache results of already solved problems
	
	int fibonacciNumMemoization(int n) {
		
		// Create a Cache to Store results
		// What must be the size of my Cache :)
		// In case we do not have computation for size of cache to store results, use dynamic data structure like hashMap
		int[] cache = new int[n+1];
		return fibonacciNumMemoizationSoln(cache, n);
		
	}
	
	int fibonacciNumMemoizationSoln(int[] cache, int n) {
		if(n<2) 
			return n;
		
		if(cache[n] != 0)
			return cache[n];
		
		cache[n] = fibonacciNumMemoizationSoln(cache, n-1) + fibonacciNumMemoizationSoln(cache, n-2);
		return cache[n];
	}
	
	
	// 1. Implement Dynamic Programming
	//    Bottom Up Approach with Tabulation | Create nDim Array and store results
	
	int fibonacciNumTabulation(int n) {
		
		// Tabular Format for us 
		// Table with Results for us
		int[] dpCache = new int[n+1];
		
		dpCache[0] = 0;
		dpCache[1] = 1;
		
		for(int i=2;i<=n;i++) {
			dpCache[i] = dpCache[i-1] + dpCache[i-2];
		}
		
		return dpCache[n];
	}
	
}

public class DynamicProgramming1 {

	public static void main(String[] args) {
		
		Fibonacci fRef = new Fibonacci();
		
		
		
//		System.out.println(">> result for 5 is: "+fRef.fibonacciNum(5)); // 5
//		System.out.println(">> result for 6 is: "+fRef.fibonacciNum(6)); // 8
		
//		System.out.println(">> result for 5 is: "+fRef.fibonacciNumMemoization(5)); // 5
//		System.out.println(">> result for 6 is: "+fRef.fibonacciNumMemoization(6)); // 8
		
		long startTime = System.nanoTime();
		System.out.println(">> result for 5 is: "+fRef.fibonacciNumTabulation(5)); // 5
		System.out.println(">> result for 6 is: "+fRef.fibonacciNumTabulation(6)); // 8
		long endTime = System.nanoTime();
		
		System.out.println(">> Total Time : "+(endTime - startTime));
		
		// PS: Bottom Up Approach with Tabulation shall be the most optimized technique
		
	}

}
