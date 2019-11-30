
public class MutableStrings {

	public static void main(String[] args) {
		
		String salutation = "Mr. ";
		String firstName = "Harry ";
		String lastName = "Watson";
		
		// We concatenate the data
		//String fullName = salutation + firstName + lastName;
		String fullName = salutation.concat(firstName).concat(lastName);
		
		System.out.println(">> Full Name is: "+fullName);
		
		// Strings are IMMUTABLE
		String str = new String("Hello");
		String anotherStr = str.concat(" World");
		System.out.println(">> str is: "+str); // Hello
		System.out.println(">> anotherStr is: "+anotherStr); // Hello World
		
		// MUTABLE Strings :  you can manipulate data in the same location
		// Here no new String is created, rather old string is manipulated at the same location
		StringBuilder sBuilder = new StringBuilder("Hello");
		
		// StringBuffer is THREAD-SAFE as well
		StringBuffer sBuffer = new StringBuffer("Hello");
		
		sBuilder.append(" World");
		sBuffer.append(" World");
		
		System.out.println(">> sBuilder is: "+sBuilder);
		System.out.println(">> sBuffer is: "+sBuffer);
		
		// For More methods on StringBuffer and StringBuilder : explore
		// Explore capacity Vs Length
		
		// Explore and Tell What is StringTokenizer ?
		
		
		

	}

}
