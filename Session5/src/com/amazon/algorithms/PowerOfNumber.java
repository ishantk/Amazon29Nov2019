package com.amazon.algorithms;

public class PowerOfNumber {

	// Computation : Algorithm to computer number power n
	static int power(int number, int n) {
		
		int result = 1;						// 1 
		int i = 1;							// 1 
		
		while(i <= n) {						// n+1
			result = result * number;		// n
			i++;							// n
		}
		
		return result;						// 1
	}
	
	// Time Complexity : 1 + 1 + n+1 + n + n + 1 -> 3N + 4 -> O(N)
	
	public static void main(String[] args) {
		
		// Compute 2 power 3 -> 2 * 2 * 2 -> 8
		
		System.out.println(PowerOfNumber.power(2, 30));

	}

}
