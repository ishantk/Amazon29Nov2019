package com.amazon.dynamicprogramming;

import java.util.HashMap;

// Dynamic Programming Problems : https://blog.usejournal.com/top-50-dynamic-programming-practice-problems-4208fed71aa3

/*
 
 Solution:
	> Consider each key as root node
	> find an optimal cost by recursively iterating in left and right subtrees
	> Computation Formula: frequency of key * level
	> Keep comparing optimal cost with previous computed costs of root nodes and update the optimal cost
 
 */

class OptimalCostBST{

	
	// i is the first key i.e. 0
	// j is the last key till where we have to work i.e 2
	// level represents tree level | should be 1, 2 and 3 -> Will be used for multiplication to find cost -> frequency of key * level
	int findOptimalCost(int[] frequency, int i, int j, int level) {
		
		// Let the Optimal Cost be a higher number so as to compare the lower cost and update it with lower value 
		int optimalCost = 1000000;		
		
		// Base Case : we need to stop in case first key goes less than last key :(
		if(j < i) {
			return 0;
		}
		
		// Iterate with keys
		// key will be 0, 1 and 2
		// Considering each key as root to recursively find the optimal cost
		for(int key=i; key<=j; key++) {
			
			// Find Left Cost for Key : 0, 1 and 2 recursively  | Left SubTree
			int leftCost = findOptimalCost(frequency, i, key-1, level+1);
			
			// Find Right Cost for Key : 0, 1 and 2 recursively | Right SubTree
			int rightCost = findOptimalCost(frequency, key+1, j, level+1);
			
			// Current Node Cost: (frequency[key] * level)
			int cost = (frequency[key] * level) + leftCost + rightCost;
						
			// Check if cost is lesser than optimal cost, and update the optimalCost for next comparisons
			optimalCost = (optimalCost < cost) ? optimalCost : cost;			
		}
		
		return optimalCost;
	}
	
	
	// i is the first key i.e. 0
	// j is the last key till where we have to work i.e 2
	// level represents tree level | should be 1, 2 and 3 -> Will be used for multiplication to find cost -> frequency of key * level
	int findOptimalCostMemoization(int[] frequency, int i, int j, int level, HashMap<String, Integer> dpCache) {
		
		// Let the Optimal Cost be a higher number so as to compare the lower cost and update it with lower value 
		int optimalCost = 1000000;
		// Cache Key is combination of i j and level
		
		// Using a HasMap : Challenge : Working on Unique Key
		String cacheKey = i+"-"+j+"-"+level;
		
		// Base Case : we need to stop in case first key goes less than last key :(
		if(j < i) {
			return 0;
		}
		
		if(!dpCache.containsKey(cacheKey)) {
			
			dpCache.put(cacheKey, optimalCost);
		
			// Iterate with keys
			// key will be 0, 1 and 2
			// Considering each key as root to recursively find the optimal cost
			for(int key=i; key<=j; key++) {
				
				// Find Left Cost for Key : 0, 1 and 2 recursively  | Left SubTree
				int leftCost = findOptimalCostMemoization(frequency, i, key-1, level+1, dpCache);
				
				// Find Right Cost for Key : 0, 1 and 2 recursively | Right SubTree
				int rightCost = findOptimalCostMemoization(frequency, key+1, j, level+1, dpCache);
				
				// Current Node Cost: (frequency[key] * level)
				int cost = (frequency[key] * level) + leftCost + rightCost;
							
				// Check if cost is lesser than optimal cost, and update the optimalCost for next comparisons
				optimalCost = (optimalCost < cost) ? optimalCost : cost;
				
				dpCache.put(cacheKey, optimalCost);
				
			}
		}
		
		return dpCache.get(cacheKey);
	}
	
}

public class DynamicProgramming3 {

	public static void main(String[] args) {
		
		OptimalCostBST oRef = new OptimalCostBST();
		
		// Suppose Keys to be 0, 1 and 2
		int[] frequency = {25, 10, 20};
		
		// Memoization Approach
		// Create Cache
		HashMap<String, Integer> dpCache = new HashMap<String, Integer>();
		
													// i-> first key (0) | j-> last key (2) | level (1) 
		//System.out.println(">> Optimal Cost : "+oRef.findOptimalCost(frequency, 0, 2, 1));
		System.out.println(">> Optimal Cost : "+oRef.findOptimalCostMemoization(frequency, 0, 2, 1, dpCache));
		
		System.out.println();
		
		System.out.println(">> Memoization Cache: ");
		for(String key : dpCache.keySet()) {
			System.out.println(key+"\t"+dpCache.get(key));
		}
	}

}
