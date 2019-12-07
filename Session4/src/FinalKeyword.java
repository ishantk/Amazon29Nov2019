// final class -> Cannot be Inherited
final class AmazonPaymentGateway{
	
	// final method -> Cannot be overrided by Child
	final void transact(int amount) {
		System.out.println(">> Transacting and Connecting to Bank");
	}
}

class ZomatoPaymentGateway{// extends AmazonPaymentGateway{
	// Overrided and doing something else
	/*void transact(int amount) { // error
		System.out.println(">> Processing Restaurant with Fee");
	}*/
}

public class FinalKeyword {

	public static void main(String[] args) {
		
		int age = 10;
		age = 20;
		
		// Final Variable
		//final int baseFare = 100;
		//baseFare = 200; // Cannot Change -> Constant -> Read Only
		
		// Blank Final Variable
		final int baseFare;
		baseFare = 100;
		

	}

}
