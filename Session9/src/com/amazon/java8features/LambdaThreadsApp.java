package com.amazon.java8features;

// Runnable is a Functional Interface having only 1 method

class PrinterThread implements Runnable{
	public void run() {
		for(int i=1;i<=10;i++) {
			System.out.println(">> Printing Page#"+i);
		}
	}
}

public class LambdaThreadsApp {

	public static void main(String[] args) {
		
		System.out.println(">> Main Started");
		
		//Runnable r = new PrinterThread();
		
		/*
		Runnable r = () -> {
			for(int i=1;i<=10;i++) {
				System.out.println(">> Printing Page#"+i);
			}
		};
		
		Thread th = new Thread(r);
		th.start();
		*/
		
		new Thread(
				() -> {
					for(int i=1;i<=10;i++) {
						System.out.println(">> Printing Page#"+i);
					}
				}	
		).start();

		System.out.println(">> Main Finished");
	}

}
