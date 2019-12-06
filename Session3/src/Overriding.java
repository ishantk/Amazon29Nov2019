class Father{
	
	void purchaseBike() {
		System.out.println(">> Lets Purchase Bajaj Pulsar");
	}
	
	static void purchaseCar() {
		System.out.println(">> Lets buy Maruti Swift");
	}
	
	void purchaseHome() {
		
	}
}

class Son extends Father{
	
	// What is Overriding : Re-Defining the Function which Parent has in Child again (Same name and Inputs)
	// Why Overriding : We need customized output from function
	void purchaseBike() {
		System.out.println(">> Lets Purchase Royal Enfield");
	}
	
	// Hiding
	static void purchaseCar() {
		System.out.println(">> Lets buy Honda City");
	}
	
	/*
	static void purchaseHome() {
		
	}*/
}

public class Overriding {

	public static void main(String[] args) {
		
		Son sRef = new Son();
		sRef.purchaseBike();
		
		Son.purchaseCar();
		
	}

}
