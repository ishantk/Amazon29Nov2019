package com.amazon.misc;

/*
 	class Integer{
 		
 		int value;
 		
 		Integer(int value){
 			this.value = value;
 		}
 	}
 */

public class WrapperClasses {

	public static void main(String[] args) {
		
		// In java we have primitives and references
		int i = 10; 					// Primitive
		char ch = 'A';
		double d = 2.2;
		
		// BOXING : When we wrap primitive into an Object
		Integer iRef = new Integer(i);  // Reference
		Character cRef = new Character(ch);
		Double dRef = new Double(d);
		
		// Integer, Character, Double are known as Wrapper Classes in Java
		// With the help of Wrapper classes we wrap primitive into object
		
		// UNBOXING : Extracting primitive from Object
		int i1 = iRef.intValue(); 
		char ch1 = cRef.charValue();
		double d1 = dRef.doubleValue();
		
		// Design Pattern Implementation came up for java 9
		//Integer iRef = Integer.valueOf(i); // Java 9 and above
		
		// AUTO-BOXING
		Integer iRef1 = i;
		// AUTO-UNBOXING
		int i2 = iRef1;

		// Use Case for Wrappers -> Data Structure Implementation only happens with References
		
	}

}
