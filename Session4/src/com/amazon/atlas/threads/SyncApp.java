package com.amazon.atlas.threads;import javax.print.attribute.standard.Destination;

class Printer{
	
	String status = "Available";
	
	//synchronized void printDocument(String docName, int copies) {
	void printDocument(String docName, int copies) {
		
		status = "Busy";
		
		System.out.println(">> Printing "+docName+" !!");
		
		for(int i=1;i<=copies;i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(docName+" Copy#"+i);
		}	
		
		status = "Available";		
	}
	
	void getPrinterStatus() {
		System.out.println(">> Printer State: "+status);
	}
	
}

class Desktop extends Thread{
	
	Printer pRef;
	
	void attachPrinter(Printer pRef) {
		this.pRef = pRef;
	}
	
	
	public void run() {
		synchronized (pRef) {
			
			try {
				pRef.wait();
				//pRef.wait(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			pRef.printDocument("## Harry'sResume.pdf ##", 10);
			pRef.getPrinterStatus();
		}
	}
}

class Laptop extends Thread{
	
	Printer pRef;
	
	void attachPrinter(Printer pRef) {
		this.pRef = pRef;
	}
	
	
	public void run() {
		synchronized (pRef) {
			pRef.printDocument("^^ LearningJava.pdf ^^", 10);
			pRef.notify();
			//pRef.notifyAll();
		}
	}
}

public class SyncApp {

	public static void main(String[] args) {
		
		Printer printer = new Printer();
		
		Desktop desktop = new Desktop();
		Laptop laptop = new Laptop();
		
		desktop.attachPrinter(printer);
		laptop.attachPrinter(printer);
		
		// Use Case : 2 Different threads i.e. Multiple threads are working on the Same Object
		//			  We need Synchronization
		
		
		/*
		desktop.start();
		try {
			desktop.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		laptop.start();
		*/
		
		desktop.start();
		laptop.start();
		
		//Thread.State -> NEW, RUNNABLE, TERMINATED  | WAITING, TIMED_WAITING, BLOCKED
		System.out.println(desktop.getState());
		
		

	}

}
