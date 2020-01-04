package com.amazon.dynamicprogramming;

public class Recursion {
	
	// Direct Recursion
	void fun() {
		
		//...
		
		// Recursion
		fun();  // execute a function within a function
		// this might run in an infinite loop
		
	}
	
	// In-Direct Recursion
	void fun1() {
		fun2();
	}
	
	void fun2() {
		fun1();
		fun2();
	}
	
	// Tail Recursion
	void fun3() {
		//....
		//....
		
		fun3(); // in the end we make a recursive call
	}
	
	
//	void printNumbers(int n) {
//		for(int i=1;i<=n;i++) {
//			System.out.println(i);
//		}
//	}

	void printNumbers(int n) {
		
		// Base Conditions
		if(n<1) {
			return;
		}else { // Actual Logic
			System.out.println(n);
			printNumbers(n-1);
		}
		
		
	}
	
	public static void main(String[] args) {
		
		Recursion rRef = new Recursion();
		rRef.printNumbers(5);

	}

}
