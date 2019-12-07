package com.amazon.atlas.model;

// Inheritance in the Same Package
// Other than provate child can access anything :)
class Parent{
	private int wealth; // Err
	
	//String vehicle; // OK
	//protected String vehicle; // OK
	public String vehicle; // OK
}

class Child extends Parent{
	
}

public class Inheritance {

	public static void main(String[] args) {
		Child ch = new Child();
		//ch.wealth = 100000; // error
		ch.vehicle = "Swift Dzire";

	}

}
