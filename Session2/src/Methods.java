import java.util.Scanner; // import Scanner to use it

public class Methods {
	
	// NON-STATIC METHOD
	// Method
	// void -> Ack | Ack nothing
	// addNumbers1 is name of method
	void addNumbers1() {
		
		// new will create an object of Scanner in the Heap
		// scanner is Reference Variable which will have the HashCode of Scanner Object
		// we somehow wont be able to see the HashCode due to toString getting executed automatically here
		Scanner scanner = new Scanner(System.in);
		//System.out.println(">> scanner is: "+scanner);            // IMPLICIT
		//System.out.println(">> scanner is: "+scanner.toString()); // EXPLICIT
		//System.out.println(">> HashCode of scanner is: "+scanner.hashCode()); // Get the HashCode
		
		
		System.out.println(">> Enter Number 1: ");
		int num1 = scanner.nextInt();
		
		System.out.println(">> Enter Number 2: ");
		int num2 = scanner.nextInt();
		
		int sum = num1 + num2;
		
		System.out.println(">> sum of "+num1+" and "+num2+" is: "+sum);
		
	}
	
	// STATIC METHOD
	static void addNumbers2() {
		
		// new will create an object of Scanner in the Heap
		// scanner is Reference Variable which will have the HashCode of Scanner Object
		// we somehow wont be able to see the HashCode due to toString getting executed automatically here
		Scanner scanner = new Scanner(System.in);
		//System.out.println(">> scanner is: "+scanner);            // IMPLICIT
		//System.out.println(">> scanner is: "+scanner.toString()); // EXPLICIT
		//System.out.println(">> HashCode of scanner is: "+scanner.hashCode()); // Get the HashCode
		
		
		System.out.println(">> Enter Number 1: ");
		int num1 = scanner.nextInt();
		
		System.out.println(">> Enter Number 2: ");
		int num2 = scanner.nextInt();
		
		int sum = num1 + num2;
		
		System.out.println(">> sum of "+num1+" and "+num2+" is: "+sum);
		
	}
	

	// main is a method
	// main is executed automatically
	// whenever program is executed, process is created and main thread executes the main method here
	// whatever we write in main will be executed in a sequence
	public static void main(String[] args) {
		
		// Execution of Methods
		// 1. NON-STATIC Methods
		//    We need to create the object for the class in which method resides
		Methods mRef = new Methods(); // Object Construction Statement
		System.out.println(">> mRef is: "+mRef);
		System.out.println("======non-static======");
		// We execute the method with reference variable
		mRef.addNumbers1();
		mRef.addNumbers1(); // execute it n-number of times you want it
		
		System.out.println("======static======");
		
		// 2. STATIC METHODS
		// Static Methods are Executed with Class Name
		Methods.addNumbers2();
		
		

	}

}
