package com.amazon.misc;

class Employee{
	
	int eid;
	String name;
	
	// this is a reference variable which is property of class
	// it will hold the reference of that object which is in action
	Employee(){
		//System.out.println(">> Employee Object Constructed: "+Employee.this);
		System.out.println(">> Employee Object Constructed and this is: "+this); // Property of class can be accessed by Object
	}

	public Employee(int eid, String name) {
		this.eid = eid;
		this.name = name;
	}
	
	void showEmployeeDetails() {
		System.out.println(">> Emplyoee: "+eid+" "+name);
	}
}

class PermanetEmployee extends Employee{
	
	int floorNum;
	
	public PermanetEmployee() {
		System.out.println(">> PermanetEmployee Object Constructed");
		floorNum = 0;
	}
	
	PermanetEmployee(int floorNum){
		System.out.println(">> PermanetEmployee Object Constructed with Parameterized Constructor");
		this.floorNum = floorNum;
	}
	
	PermanetEmployee(int floorNum, int eid, String name){
		// super(); -> Added by compiler to execute default constructor in parent
		super(eid, name); // When we wish to have custom parent object construction
		System.out.println(">> PermanetEmployee Object Constructed with Parameterized Constructor");
		this.floorNum = floorNum;
		//this.eid = eid;   // Parent
		//this.name = name; // Parent
	}
	
	// Overriding
	void showEmployeeDetails() {
		super.showEmployeeDetails();
		//System.out.println(">> Emplyoee: "+eid+" "+name);
		System.out.println(">> Floor Number is: "+floorNum);
	}
	
}

public class ThisAndSuper {

	public static void main(String[] args) {
		
		/*
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		Employee e3 = new Employee(101, "Harry");
		
		System.out.println(">> e1 is: "+e1);
		System.out.println(">> e2 is: "+e2);*/
		
		
		PermanetEmployee pRef = new PermanetEmployee(5, 101, "Harry");
		pRef.showEmployeeDetails();

	}

}

// PS: super is a reference variable which point to the Parent Object
// with super from child object we can access parent object's attributes and methods
// with super as a function call we can request which constructor in the parent should be used for inheritance rule !!
