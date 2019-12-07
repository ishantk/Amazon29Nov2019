package com.amazon.atlas.model;

public class App {

	public static void main(String[] args) {
		
		// PS: if classes resides in same package, we can create objects easily
		Customer cRef = new Customer();
		Restaurnat rRef = new Restaurnat();
		
		// cRef.pvtShowCustomer(); error
		cRef.defShowCustomer();
		cRef.protShowCustomer();
		cRef.pubShowCustomer();
		
		// rRef.pvtShowRestaurnat(); error
		rRef.defShowRestaurnat();
		rRef.protShowRestaurnat();
		rRef.pubShowRestaurnat();
	}

}
