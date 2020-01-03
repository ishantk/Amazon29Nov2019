package com.amazon.dynamicprogramming;

class EqualSubsetSumPartition{
	
	boolean canPartition(int[] numbers) {
		    
		// Lets add all the elements in numbers array
		int sum=0;
		for(int element : numbers) {
			sum += element;
		}
		
		// Check if sum is odd and return false right away
		if(sum%2 != 0)
			return false;
		
		// Apply Recursive Approach :)
		return canPartitionSoln(numbers, sum/2, 0);
		
	}
	
	boolean canPartitionSoln(int[] numbers, int sum, int idx) {
	    
		// Base Checks
		if(sum == 0)
			return true; 
		
		if(numbers.length == 0 || idx>=numbers.length)
			return false;
		
		// We need to recursively execute canPartitionSoln by selecting a number at idx
		// And in case the number at the idx will be more than sum, we should not proceed
		if(numbers[idx] <= sum) {
			if(canPartitionSoln(numbers, sum-numbers[idx], idx+1)) {
				return true;
			}
		}
		
		// We will now recursively call excluding the number at current index
		return canPartitionSoln(numbers, sum, idx+1);
		
	}
	
	// Implement Top Down Memoization
	// Implement Cache of Boolean
	// Cache of Booleans shall be a 2 dimensional Array.
	// 1st dimension : different subsets in array
	// 2nd dimension : different sums that we are calculating in subsets
	
	boolean canPartitionMemoization(int[] numbers) {
	    
		// Lets add all the elements in numbers array
		int sum=0;
		for(int element : numbers) {
			sum += element;
		}
		
		// Check if sum is odd and return false right away
		if(sum%2 != 0)
			return false;
		

		// Create Cache for our Memoization feature
		Boolean[][] dpCache = new Boolean[numbers.length][(sum/2) + 1];

		// Apply Recursive Approach :)
		return canPartitionMemoizationSoln(dpCache, numbers, sum/2, 0);
		
	}
	
	boolean canPartitionMemoizationSoln(Boolean[][] dpCache, int[] numbers, int sum, int idx) {
	    
		// Base Checks
		if(sum == 0)
			return true; 
		
		if(numbers.length == 0 || idx>=numbers.length)
			return false;
		
		// We need to recursively execute canPartitionSoln by selecting a number at idx
		// And in case the number at the idx will be more than sum, we should not proceed
		if(dpCache[idx][sum] == null) {
			if(numbers[idx] <= sum) {
				if(canPartitionSoln(numbers, sum-numbers[idx], idx+1)) {
					dpCache[idx][sum] = true;
					return dpCache[idx][sum];
				}
			}
		}

		// We will now recursively call excluding the number at current index and will store the boolean value
		dpCache[idx][sum] = canPartitionSoln(numbers, sum, idx+1);

		return dpCache[idx][sum];
		
	}

}

public class DynamicProgramming3 {

	public static void main(String[] args) {
		
		EqualSubsetSumPartition eRef = new EqualSubsetSumPartition();
		int[] numbers1 = {1, 2, 3, 4};
		int[] numbers2 = {1, 1, 3, 4, 7};
		int[] numbers3 = {2, 3, 4, 6};

//		System.out.println("Can Partition {1, 2, 3, 4}: "+eRef.canPartition(numbers1));
//		System.out.println("Can Partition {1, 1, 3, 4, 7}}: "+eRef.canPartition(numbers2));
//		System.out.println("Can Partition {2, 3, 4, 6}}: "+eRef.canPartition(numbers3));
		
		System.out.println("Can Partition {1, 2, 3, 4}: "+eRef.canPartitionMemoization(numbers1));
		System.out.println("Can Partition {1, 1, 3, 4, 7}}: "+eRef.canPartitionMemoization(numbers2));
		System.out.println("Can Partition {2, 3, 4, 6}}: "+eRef.canPartitionMemoization(numbers3));
		

	}

}
