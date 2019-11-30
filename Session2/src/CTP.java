// Compile Time Polymorpihsm
// Static Polymorphism
// Early Binding

// Binding is linking of execution statement with definition of function/method
// Binding will be done by Compiler at the time of Compilation

public class CTP {

	// 1. NUMBER OF INPUTS
	void add(int num1, int num2) {
		int sum = num1 + num2;
		System.out.println(">> Sum is: "+sum);
	}
	
	void add(int num1, int num2, int num3) {
		int sum = num1 + num2 + num3;
		System.out.println("** Sum is: "+sum);
	}
	
	// 2. TYPE OF INPUTS
	void add(double num1, double num2) {
		double sum = num1 + num2;
		System.out.println("## Sum is: "+sum);
	}
	
	
	// 3. SEQUENCE OF INPUTS
	void add(int num1, double num2) {
		double sum = num1 + num2;
		System.out.println("## Sum is: "+sum);
	}
	
	void add(double num1, int num2) {
		double sum = num1 + num2;
		System.out.println("## Sum is: "+sum);
	}
	
	// ERROR
	/*double add(double num1, int num2) {
		double sum = num1 + num2;
		return sum;
	}*/
	
	// Rule to Overload:
	// 1. Method Name should be Same
	// 2. Inputs must be UNIQUE : For 1, 2 and 3 we can see Method Signature is UNIQUE
	//    2.1 Number of Inputs (Increase or Decrease)
	//    2.2 Type of Inputs (Data Type Change)
	//    2.1 Sequence of Inputs (Change in order wit types)
	// 3. Return Type has No Partcipation
	
	
	boolean login(String email, String password) {
	
		boolean check = false;
		
		if(email.equals("john@example.com") && password.equals("pass123")) {
			check = true;
		}
		
		return check;
	}
	
	boolean login(String phoneNumber, int OTP) {
		
		boolean check = true;
		
		
		
		return check;
	}
	
	
	
	public static void main(String[] args) {
		
		CTP cRef = new CTP();
		cRef.add(10, 20);
		cRef.add(10, 20, 30);
		cRef.add(10, 2.2);
		cRef.add(31.3, 20);
		cRef.add(2.2, 3.3);
		
		cRef.login("+91 99999 88888", 3027); // Line #78 should execute the definition for Line#60
		cRef.login("fionna@example.com", "fionna123");

	}

}
