class Customer{
	
	Customer(){
		System.out.println(">> This is Customer Constructor");
	}
	
	// Initializer Block
	{
		System.out.println(">> This is Customer Block1");
	}
	
	// Initializer Block
	{
		System.out.println(">> This is Customer Block2");
	}
	
	// Static Initializer Block
	static {
		System.out.println(">> This is static Customer Block");
	}
}


public class Blocks {

	public static void main(String[] args) {
		
		System.out.println(">> This is main");
		
		/*Customer cRef1 = new Customer();
		
		System.out.println();
		
		Customer cRef2 = new Customer();*/
			

	}

}
