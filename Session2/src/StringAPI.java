
// API : Application Programming Interfaces
//		 Built In Code. may be a Class, May be a Method, May be an Interface etc...
//		 OR Someone else developed code and we use it
public class StringAPI {

	public static void main(String[] args) {
		
		// Syntax #1 : Interned Strings 
		String str1 = "HeLLo";
		String str2 = "Hello";
		
		// Syntax #2 : Objects
		String str3 = new String("HeLLo");
		String str4 = new String("Hello");
		
		System.out.println(">> Strings without toString method");
		
		System.out.println(">> str1 is: "+str1);
		System.out.println(">> str2 is: "+str2);
		System.out.println(">> str3 is: "+str3);
		System.out.println(">> str4 is: "+str4);
		
		System.out.println(">> Strings with toString method");
		
		
		System.out.println(">> str1.toString() is: "+str1.toString());
		System.out.println(">> str2.toString() is: "+str2.toString());
		System.out.println(">> str3.toString() is: "+str3.toString());
		System.out.println(">> str4.toString() is: "+str4.toString());
		
		// PS: Due to toString() we don't see the HashCode
		// toString() returns the data
		// BUT, str1, str2, str3 and str4 are reference variables
		
		// == operator is not comparing data. it is comparing references !!
		if(str1 == str2) {
			System.out.println(">> str1 == str2");
		}else {
			System.out.println(">> str1 != str2");
		}
		
		if(str3 == str4) {
			System.out.println(">> str3 == str4");
		}else {
			System.out.println(">> str3 != str4");
		}
		
		if(str1 == str3) {
			System.out.println(">> str1 == str3");
		}else {
			System.out.println(">> str1 != str3");
		}
		
		if(str1.equals(str2)) {
			System.out.println(">> Strings 1 and 2 are Equal");
		}else {
			System.out.println(">> Strings 1 and 2 are not Equal");
		}
		
		if(str2.equals(str4)) {
			System.out.println(">> Strings 2 and 4 are Equal");
		}else {
			System.out.println(">> Strings 2 and 4 are not Equal");
		}
		
		if(str1.equals(str3)) {
			System.out.println(">> Strings 1 and 3 are Equal");
		}else {
			System.out.println(">> Strings 1 and 3 are not Equal");
		}

		
		if(str1.equalsIgnoreCase(str2)) {
			System.out.println(">> Strings 1 and 2 are equal after ignoring case");
		}else {
			System.out.println(">> Strings 1 and 2 are not equal after ignoring case");
		}
		
		if(str1.compareTo(str2) == 0) {
			System.out.println(">> str1 compared to str2");
		}else {
			System.out.println(">> str1 not compared to str2");
		}
		
	}

}
