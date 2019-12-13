package com.amazon.algorithms;



public class LinearSearching {

	static int searchPrice(int[] prices, int price) {
		
		for(int i=0;i<prices.length;i++) { // N
			
			if(prices[i] == price) {
				return i;
			}
		}
		
		return -1; // in case we didnt find the element
	}
	
	public static void main(String[] args) {
		
		int[] prices = {2345, 9876, 1231, 3212, 5432};
		int priceToFind = 5432;
		
		int idx = searchPrice(prices, priceToFind);
		System.out.println(">> "+priceToFind+" found at index: "+idx);
		
	}

	// Time Complexity : O(n)
	
}
