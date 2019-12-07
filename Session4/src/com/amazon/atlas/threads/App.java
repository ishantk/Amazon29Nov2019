package com.amazon.atlas.threads;

/*class MyTask{
	
	void printDocument(String docName, int copies) {
	
		for(int i=1;i<=copies;i++) {
			System.out.println("** Printing "+docName+" Copy#"+i);
		}
		
	}
}*/

// MyTask IS-A Thread
// Thread is a built in class in Java in java.lang package and hence, we need not to import it !!
class MyTask extends Thread{
	
	String docName;
	int copies;
	
	MyTask(String docName, int copies){
		this.docName = docName;
		this.copies = copies;
	}
	
	// Run is the method of Child Thread in which you write that task which is suppose to be executed parallely to the main thread
	// whatever is in run method is executed in the background i.e. parallely to the main
	public void run() {
		for(int i=1;i<=copies;i++) {
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("** Printing "+docName+" Copy#"+i);
		}
	}

}

class CA{
	
}

//class YourTask extends CA, Thread{ // Error : Multiple Inheritance not Supported Here !!
class YourTask extends CA implements Runnable{
	
	String docName;
	int copies;
	
	YourTask(String docName, int copies){
		this.docName = docName;
		this.copies = copies;
	}
	
	// Run is the method of Child Thread in which you write that task which is suppose to be executed parallely to the main thread
	public void run() {
		for(int i=1;i<=copies;i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("** Printing "+docName+" Copy#"+i);
		}	
	}

}

public class App {

	// Whatever we write in main, will be executed in a sequence.
	// i.e. one after the other
	// i.e. Sequentially 
	public static void main(String[] args) {
		
		// Task-1
		System.out.println(">> Main Started");
		
		// Task-2
		//MyTask mRef = new MyTask();
		//mRef.printDocument("LearningJavaThreads.pdf", 10);
		
		MyTask mRef = new MyTask("- LearningJavaThreads.pdf -", 10); // MyTask IS-A Thread
		
		//YourTask yRef = new YourTask("LearningPython.pdf", 10);
		//yRef.start(); // error
		
		// Polymorphic Statement Goes First
		Runnable r = new YourTask("# LearningPython.pdf #", 10); // YourTask is just an object which implements Runnable
		// Create Thread Object
		Thread yRef = new Thread(r);
		
		// new Thread(new YourTask("# LearningPython.pdf #", 10)).start();
		
		mRef.setName("Jack");
		yRef.setName("Joe");
		Thread.currentThread().setName("Charlie");
		
		
		// yRef.setDaemon(true);
		
		// Setting up Priority is a Request to JVM
		// In case JVM is occupied, please consider at that time !!
		mRef.setPriority(Thread.MAX_PRIORITY);  					// 10
		yRef.setPriority(Thread.NORM_PRIORITY); 					// 5
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY); 	// 1
		
		System.out.println(">> mRef Name is: "+mRef.getName()+" and Prioirty is: "+mRef.getPriority());
		System.out.println(">> yRef Name is: "+yRef.getName()+" and Prioirty is: "+yRef.getPriority());
		System.out.println(">> main's Name is: "+Thread.currentThread().getName()+" and Prioirty is: "+Thread.currentThread().getPriority());
		
		
		mRef.start(); // start is method in Thread Class. start method will internally execute run method
		
		try {
			mRef.join(); // execute join immediately after start, let other threads wait till i finished execution
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		yRef.start();
		
		// Task-3
		for(int i=1;i<=10;i++) {
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(">> Printing xmas-event.pdf Copy#"+i);
		}
		
		// Task-n
		System.out.println(">> Main Finished");
	}

}

// Parallel Execution of Threads : MyTask, YourTask and main
// Asynchronous Execution i.e. running all together
// Concurrent Programming :)
