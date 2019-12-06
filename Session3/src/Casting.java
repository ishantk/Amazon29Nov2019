
public class Casting {

	public static void main(String[] args) {
		
		byte age = 20;
		// In the memory age is created as a 8 bit container in stack
		// 20 is data i.e. literal. Literal is created in Constant Pool (32 bits memory)
		
		byte jacksAge = 20;
		
		int fionnasAge = 128;
		
		byte joesAge = (byte)fionnasAge; // DownCasting
		
		System.out.println(">> joes Age is: "+joesAge);
		
		long salary = 10000000000l;		 // Literal is created in Constant Pool (64 bits memory)
		
		double discount = 200.22;		 // Double Literal is created in 64 bits in Constant pool
		
		float newDicount = 200.22f;		 // Floating Point Literal in 32 bits in Constant pool
		
		float myDicount = (float)200.22; // DownCasting	

	}

}
