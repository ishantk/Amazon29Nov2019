import java.util.Scanner;

/*class Cab{
	
	int baseFare;
	
	Cab(){
		baseFare = 100;
		System.out.println(">> Cab Object Constructed");
	}
	
	void bookCab(String source, String destination) {
		System.out.println(">> Cab booked from "+source+" to "+destination);
		System.out.println(">> Please Pay: \u20b9"+baseFare);
	}
}*/

abstract class Cab{
	
	int baseFare;
	
	Cab(){
		baseFare = 100;
		System.out.println(">> Cab Object Constructed");
	}
	
	// abstract function has no definition
	// abstract function can be created in abstract class
	// abstract function is a RULE i.e. PROTOCOL created by parent and must be defined by Child
	// if child has n number of abstract functions, all of them must be defined by children
	abstract void bookCab(String source, String destination); 
	
	void show() {
		System.out.println(">> This is show in Cab");
	}
	
}

class UberPremier extends Cab{
	
	UberPremier() {
		baseFare += 100;
		System.out.println(">> UberPremier Object Constructed");
	}
	
	// Same Function with Same Signature Re-Defined in Child Object
	void bookCab(String source, String destination) {
		System.out.println(">> UberPremier Cab booked from "+source+" to "+destination);
		System.out.println(">> Please Pay: \u20b9"+baseFare+ " for Premier Cab");
	}
}

class UberAuto extends Cab{
	
	UberAuto() {
		baseFare += 50;
		System.out.println(">> UberAuto Object Constructed");
	}
	
	// Same Function with Same Signature Re-Defined in Child Object
	void bookCab(String source, String destination) {
		System.out.println(">> Uber Auto booked from "+source+" to "+destination);
		System.out.println(">> Please Pay: \u20b9"+baseFare+ " for Uber Auto");
	}
}

class UberGo extends Cab{
	
	UberGo() {
		baseFare += 80;
		System.out.println(">> UberGo Object Constructed");
	}
	
	// Same Function with Same Signature Re-Defined in Child Object
	void bookCab(String source, String destination) {
		System.out.println(">> UberGo Cab booked from "+source+" to "+destination);
		System.out.println(">> Please Pay: \u20b9"+baseFare+ " for UberGo Cab");
	}
}

// Run Time Polymorphism
public class RTP {

	public static void main(String[] args) {
		
		/*
		Cab cRef; 		  // cRef is a Reference Variable and not an Object
		cRef = new Cab(); // Object Construction Statement
		
		cRef.bookCab("Country Homes", "Redwood Shores");
		*/
		
		/*
		UberPremier uRef;
		uRef = new UberPremier();
		
		uRef.bookCab("Country Homes", "Redwood Shores");
		*/
		
		// Ref Var of Parent can point to Object of Child
		// But Vice-Versa is not possible
		
		/*
		Cab cRef = null; // Initialization Before Use Principle
		
		System.out.println(">> Select 1. for UberPremier Cab");
		System.out.println(">> Select 2. for UberAuto");
		System.out.println(">> Select 3. for UberGo Cab");
		
		System.out.println(">> Enter your Choice: ");
		Scanner scanner = new Scanner(System.in);
		
		int choice = scanner.nextInt();
		
		switch (choice) {
			case 1:
				cRef = new UberPremier();
				break;
	
			case 2:
				cRef = new UberAuto();
				break;
				
			case 3:
				cRef = new UberGo();
				break;
		}
		
		cRef.bookCab("Country Homes", "Redwood Shores");
		*/
		
		
		Cab cRef = null;
		
		cRef = new UberPremier(); 
		cRef.bookCab("Country Homes", "Redwood Shores");
		
		System.out.println();
		
		cRef = new UberAuto();
		cRef.bookCab("Country Homes", "Redwood Shores");
		
		System.out.println();
		
		cRef = new UberGo();
		cRef.bookCab("Country Homes", "Redwood Shores");
		
		
		
		// Challenge #1 : Everytime Parent Object will be in the memory !!
		
		// Challenge #2 : If we create Object of cab Directly, it will have no meaning
		//Cab cRef;
		//cRef = new Cab();	// We dont want this object here
		//cRef.bookCab("Country Homes", "Redwood Shores"); // and nor this method
		// So, we will optimize the code

		// Make class as abstract : Abstract class we cannot create objects. But Runtime Environment will create object
		//							To follow Rule of Inheritance
		
	}

}
