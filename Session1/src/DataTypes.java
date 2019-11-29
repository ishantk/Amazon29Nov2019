
public class DataTypes {

	public static void main(String[] args) {
		
		// Single Value Storage Containers : Primitives
		// 2. Storage Container Creation Statement
		// Local Variable, created in Scope of main
		int amount = 1000;  // 32 bits
		byte jacksAge = 20; // 8bits -> 2 power 8 -> 256 -> -128 to 0 to 127
		
		// 3. Storage COntainer Updation Statements
		jacksAge = 30;
		
		System.out.println("Jacks Age is: "+jacksAge+" years");
		System.out.println("Jacks is "+jacksAge+" years old");
		
		char gender = 'M';
		char alphabet = 97;
		char rupee = '\u20b9';
		char hindiA = '\u0905';
		
		System.out.println("Gender is: "+gender);
		System.out.println("Alphabet is: "+alphabet);
		System.out.println("Rupee is: "+rupee);
		System.out.println("hindiA is: "+hindiA);
		
		String name = "\u0905shish";
		System.out.println("name is: "+name);
		
		String quote = "Be Happy, Live Life !!";
		
		//float discountPercent = 0.20f; // 32 bits
		double discountPercent = 0.20;   // 64 bits
		
		boolean isInternetOn = true;
		
		System.out.println(">> This is END of PROGRAM");

	}

}
