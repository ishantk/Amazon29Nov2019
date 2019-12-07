package com.amazon.atlas.exceptions;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		System.out.println(">> App Started");
		
		int a = 10;
		int b = 0;
		int c = 0;
		
		
		int[] arr = {10, 20, 30, 40, 50};
		Scanner scanner = new Scanner(System.in);
		System.out.println(">> Enter an Index to Read Value from Array: ");
		int idx = scanner.nextInt();
		
		/*
		try {
			c = a/b;
			System.out.println(">> c is: "+c);
			System.out.println(">> Element at "+idx+" is: "+arr[idx]);
		}catch(ArrayIndexOutOfBoundsException aRef) {
			System.out.println(">> OOPS !! Some Array Error Occured: "+aRef);
		}catch(ArithmeticException aRef) {
			System.out.println(">> OOPS !! Some Arithmetic Error Occured: "+aRef);
		}finally { // will be executed regardless of exception being handled or not
			System.out.println(">> Finally Will Always Work");
		}
		*/
		
		try {
			try {
				c = a/b;
			}catch(ArithmeticException aRef) {
				System.out.println(">> OOPS !! Some Arithmetic Error Occured: "+aRef);
			}
			System.out.println(">> c is: "+c);
			System.out.println(">> Element at "+idx+" is: "+arr[idx]);
		}catch(ArrayIndexOutOfBoundsException aRef) {
			System.out.println(">> OOPS !! Some Array Error Occured: "+aRef);
		}finally { // will be executed regardless of exception being handled or not
			System.out.println(">> Finally Will Always Work");
		}

		/*
		try {
			try {
				
			}catch() {
				
			}finally {
				
			}
		}catch() {
			try {
				
			}catch() {
				
			}finally {
				
			}
		}finally {
			try {
				
			}catch() {
				
			}finally {
				
			}
		}*/
		
		System.out.println(">> Work Hard, Get Luckier !!");

		System.out.println(">> App Finished");
	}

	// Exception : error at run time : Crash the Program abnormally : Abnormal Termination of Process itself
	//			   Shall hamper performance of system and Bad User Experience
	//			   As a solution handle errors using try catch
	
}
