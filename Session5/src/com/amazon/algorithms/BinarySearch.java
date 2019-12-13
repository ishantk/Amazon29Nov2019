package com.amazon.algorithms;

public class BinarySearch {
	
	static int searchPrice(int[] prices, int price) {
		
		int left = 0;
		int right = prices.length-1;
		
		while(left <= right) {
			
			int mid = left + (right-left)/2;
			
			if(prices[mid] == price) {
				return mid;
			}
			
			if(prices[mid] < price) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		
		return -1; // in case we did'nt find the element
	}

	public static void main(String[] args) {
		
		int[] prices = {2345, 9876, 1231, 3212, 5432};
		int priceToFind = 1231;
		
		int idx = searchPrice(prices, priceToFind);
		System.out.println(">> "+priceToFind+" found at index: "+idx);

	}

}
