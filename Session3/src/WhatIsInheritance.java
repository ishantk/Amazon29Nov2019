class Parent{
	
	// Attribute : Property of Parent Object
	int wealth;
	String vehicle;
	
	static String company;
	
	Parent(){
		wealth = 100000;
		vehicle = "Maruti Swift Dzire";
		System.out.println(">> Parent Object Constructed");
	}
	
	void showDetails() {
		System.out.println(">> Parent has wealth: "+wealth+" and vehcile: "+vehicle);
	}
	
	static void showCompanyDetails() {
		System.out.println(">> Company Name: "+company);
	}
	
}

class Child extends Parent{ // IS-A Relationship 
	
	static String company;
	
	// Attribute : Property of Child Object
	int wealth;
	
	Child(){
		wealth = 10000;
		System.out.println(">> Child Object Constructed");
	}
	
	void show() {
		System.out.println(">> Child has wealth: "+wealth+" and vehcile: "+vehicle);
	}
	
	static void sShow() {
		System.out.println(">> Child Company Name: "+company);
	}
	
}

public class WhatIsInheritance {

	public static void main(String[] args) {
		
		// Object Construction Statement
		//Parent pRef = new Parent();
		//pRef.showParentDetails();
		
		Child cRef = new Child();
		
		// RULE #1 OF INHERITANCE: Before the Object of Child, Parent Object is constructed in the memory.
		
		cRef.wealth = 50000;
		cRef.showDetails();
		cRef.show();
		
		// RULE #2 OF INHERITANCE: If child has no attribute or method as requested, it will access from Parent
		//						   In case it has, it will access its own
		
		Child.company = "ABC Ventures Pvt Ltd";
		Child.showCompanyDetails(); // ?
		Child.sShow();
		
		// RULE# 3 OF INHEITANCE : It works as in Object to Object and Class to Class separately

	}

}
