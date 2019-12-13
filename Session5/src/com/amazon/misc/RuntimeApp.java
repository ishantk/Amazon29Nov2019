package com.amazon.misc;

class Product implements Cloneable{
	
	int pid;
	String name;
	int price;
	
	Product(){
		System.out.println(">> Product Object Constructed");
	}
	
	public Product(int pid, String name, int price) {
		this.pid = pid;
		this.name = name;
		this.price = price;
	}


	// Java 9 and above please refer : Cleaner / AutoCloseable 
	// https://docs.oracle.com/javase/9/docs/api/java/lang/ref/Cleaner.html
	@Override
	protected void finalize() throws Throwable {
		System.out.println(">> Object : "+pid+" - "+name+" Finalized");
	}
	
	// Shallow Copy Implementation
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

class MyThread extends Thread{
	@Override
	public void run() {
		System.out.println(">> JVM Shut Down Hook");
	}
}

public class RuntimeApp {

	public static void main(String[] args) {
		
		/*
		System.out.println(">> App Started");
		
		Product p1 = new Product(101, "iPHoneXI", 70000);
		Product p2 = new Product(201, "iPHoneXIMax", 85000);
		Product p3 = new Product(301, "Samsung Fold", 100000);
		
		Runtime rt = Runtime.getRuntime(); // Get the Reference of JVM
		System.out.println(">> availableProcessors: "+rt.availableProcessors());
		System.out.println(">> Max Memory: "+rt.maxMemory());
		System.out.println(">> Free Memory: "+rt.freeMemory());
		System.out.println(">> Total Memory: "+rt.totalMemory());
		
		p1 = null;
		p2 = null;
		p3 = null;
		
		MyThread mRef = new MyThread();
		rt.addShutdownHook(mRef);
				
		
		System.out.println();
		System.out.println(">> After Garbage Collection");
		
		rt.gc(); // System.gc();
		
		System.out.println(">> Max Memory: "+rt.maxMemory());
		System.out.println(">> Free Memory: "+rt.freeMemory());
		System.out.println(">> Total Memory: "+rt.totalMemory());
		
		System.out.println(">> App Finished");
		*/
		
		Product p1 = new Product(101, "iPHoneXI", 70000);
		Product p2 = null;
		try {
			p2 = (Product)p1.clone(); 
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		System.out.println(">> p1 is: "+p1+" "+p1.pid+" | "+p1.name+" | "+p1.price);
		System.out.println(">> p2 is: "+p2+" "+p2.pid+" | "+p2.name+" | "+p2.price);
		
		// Explore Deep Copy and Shallow Copy with clone function
		
	}

}
