package com.amazon.atlas.model;

public class Customer {
	
	public static final int CID = 101;
	
	// Attributes
	private int a; // private
	int b;		   // default
	protected int c; // protected
	public int d;  // public
	
	// Methods
	// private is accessible only within the class block
	private void pvtShowCustomer() {
		System.out.println(">> Customer in private show Method");
	}
	
	void defShowCustomer() {
		System.out.println(">> Customer in default show Method");
	}
	
	protected void protShowCustomer() {
		System.out.println(">> Customer in protected show Method");
	}
	
	public void pubShowCustomer() {
		System.out.println(">> Customer in public show Method");
	}
	
}

// ERROR:
// Java says if you create a public class -> name of source file should be same name as that of class name
/*public class Restaurant{
	
}*/

//ERROR : private class not allowed
/*private class Restaurant{
	
}*/

// ERROR : protected class not allowed
/*protected class Restaurant{
	
}*/

// We can create any number of Default Classes in the same source file 
class Restaurnat{
	
	// Attributes
	private int a; // private
	int b;		   // default
	protected int c; // protected
	public int d;  // public
	
	// Methods
	private void pvtShowRestaurnat() {
		System.out.println(">> Restaurnat in private show Method");
	}
	
	void defShowRestaurnat() {
		System.out.println(">> Restaurnat in default show Method");
	}
	
	protected void protShowRestaurnat() {
		System.out.println(">> Restaurnat in protected show Method");
	}
	
	public void pubShowRestaurnat() {
		System.out.println(">> Restaurnat in public show Method");
	}
	
}

// OK : Multiple default classes allowed
/*
class Menu{
	
}

class Dish{
	
}
*/
