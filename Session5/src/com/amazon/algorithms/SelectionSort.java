package com.amazon.algorithms;

public class SelectionSort {

	static int getMinimumIndex(int[] prices, int start, int stop) {
		
		int minIdx = start;
		
		for(int i=start; i<stop; i++) {
			if(prices[i] < prices[minIdx]) {
				minIdx = i;
			}
		}
		
		return minIdx;
	}
	
	static void swapElements(int[] prices, int i, int j) {
		int temp = prices[i];
		prices[i] = prices[j];
		prices[j] = temp;
	}
	
	static void printPrices(int[] prices) {
		
		for(int element : prices) {
			System.out.print(element+"  ");
		}
		
		System.out.println();
	}

	
	public static void main(String[] args) {
		
		int[] prices = {2345, 9876, 1231, 3212, 5432};
		
		/*
		int minIdx = getMinimumIndex(prices, 0, prices.length);
		System.out.println(">> minIdx is: "+minIdx); // 2
		
		swapElements(prices, minIdx, 0);
		
		for(int element : prices) {
			System.out.print(element+" ");
		}
		//1231, 9876, 2345 , 3212, 5432

		// Till here we have 0th index with smallest value :)
		System.out.println();
		
		minIdx = getMinimumIndex(prices, 1, prices.length);
		System.out.println(">> minIdx is: "+minIdx); //  2
		
		swapElements(prices, minIdx, 1);
		
		for(int element : prices) {
			System.out.print(element+" ");
		}
		
		// 1231, 2345, 9876, 3212, 5432
		*/
		
		for(int i=0;i<prices.length;i++) {
			
			int minIdx = getMinimumIndex(prices, i, prices.length);
			System.out.println(">> minIdx is: "+minIdx);
			
			swapElements(prices, minIdx, i);
			
			printPrices(prices);
		}
	}

}
