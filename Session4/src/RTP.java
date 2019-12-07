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

// Abstract Class : We Cannot create its Objects. It cannot be Instantiated !!
// 					BUT Run Time Environment will create its objects to follow Rule of Inheritance
//					Parent Object -> Child Object
/*
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
	
	// Can have Regular/Concrete Methods
	void show() {
		System.out.println(">> This is show in Cab");
	}
	
}
*/

// interface : 	    We Cannot create its Objects. It cannot be Instantiated !!
// 					Even Run Time Environment cannot create its objects hence NO Inheritance
//					Rule Book / Policy ->  Object

interface Cab{
	
	// Attribute : Property of Interface
	// 			   They are final. Values cannot be Modified
	int baseFare = 100; // -> public static final int baseFare = 100;
	
	// Interfaces cannot have constructors : Interfaces cannot have Objects !!
	/*
	Cab(){
		baseFare = 100;
		System.out.println(">> Cab Object Constructed");
	}*/
	
	// abstract function has no definition
	// abstract function can be created in abstract class or interface
	// abstract function is a RULE i.e. PROTOCOL created by interface and must be defined by object which implements it
	// if interface has n number of abstract functions, all of them must be defined by object which implements it
	void bookCab(String source, String destination); // public abstract void bookCab(String source, String destination);
	
	// Cannot have Regular/Concrete Methods
	/*void show() {
		System.out.println(">> This is show in Cab");
	}*/
	
}


class UberPremier implements Cab{ //extends Cab{
	
	int fare = 100;
	
	UberPremier() {
		fare += baseFare;
		System.out.println(">> UberPremier Object Constructed");
	}
	
	// Same Function with Same Signature Re-Defined in Child Object
	public void bookCab(String source, String destination) {
		System.out.println(">> UberPremier Cab booked from "+source+" to "+destination);
		System.out.println(">> Please Pay: \u20b9"+fare+ " for Premier Cab");
	}
}

class UberAuto implements Cab{ //extends Cab{
	
	int fare = 50;
	
	UberAuto() {
		fare += baseFare;
		System.out.println(">> UberAuto Object Constructed");
	}
	
	// Same Function with Same Signature Re-Defined in Child Object
	public void bookCab(String source, String destination) {
		System.out.println(">> Uber Auto booked from "+source+" to "+destination);
		System.out.println(">> Please Pay: \u20b9"+fare+ " for Uber Auto");
	}
}

class UberGo implements Cab{ //extends Cab{
	
	int fare = 80;
	
	UberGo() {
		fare += baseFare;
		System.out.println(">> UberGo Object Constructed");
	}
	
	// Same Function with Same Signature Re-Defined in Child Object
	public void bookCab(String source, String destination) {
		System.out.println(">> UberGo Cab booked from "+source+" to "+destination);
		System.out.println(">> Please Pay: \u20b9"+fare+ " for UberGo Cab");
	}
	
	void fetchWifiDetails() {
		System.out.println(">> Username: ubergo1 | Password: pass123");
	}
}



public class RTP {

	public static void main(String[] args) {
		
		Cab cRef; // Ref Var of Interface and Not an Object
		
		//cRef = new Cab(); // Error : interface cannot have objects
		
		// Polymorphic Statement : Ref Var of Interface can point to the Object which implements it
		cRef = new UberPremier(); 
		cRef.bookCab("Country Homes", "Pristine Magnum");
		
		System.out.println();
		
		cRef = new UberAuto(); // Polymorphic Statement
		cRef.bookCab("Country Homes", "Pristine Magnum");
		
		System.out.println();
		
		cRef = new UberGo(); // Polymorphic Statement
		cRef.bookCab("Country Homes", "Pristine Magnum");
		
		//cRef.fetchWifiDetails(); // error : we can only access methods defined in Child from Interface.
		
	}

}

// PS: Property of Object -> Accessed by Its Reference Variable (Non Static Context)
//     Property of Class -> Accessed by Clas Name (Static Context)
//     Property of Interface -> Accessed by Interface Name (Interface static Context)
