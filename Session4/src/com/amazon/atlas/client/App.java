package com.amazon.atlas.client;

import com.amazon.atlas.model.Customer;
import static com.amazon.atlas.model.Customer.CID; // Static Import
import com.amazon.atlas.model.*;

//import com.amazon.atlas.model.Restaurnat; // Error : default cannot be imported

// private and default in Parent is not Accessible by Child
// protected and public is accessible by the Child
// protected is accessible only in the child class 
class PremiumCustomer extends Customer{
	
	
	void show() {
		//pvtShowCustomer(); err
		//defShowCustomer(); err
		protShowCustomer(); // protected accessible only in the Child Class
		pubShowCustomer();
	}
}

public class App {

	public static void main(String[] args) {
		
		//Customer cRef = new Customer();
		//cRef.pvtShowCustomer(); // error
		//cRef.defShowCustomer(); // error
		//cRef.protShowCustomer(); // error
		//cRef.pubShowCustomer(); // OK
		
		PremiumCustomer pRef = new PremiumCustomer();
		//pRef.protShowCustomer(); // error : direct access is an error
		pRef.pubShowCustomer();  //OK
		pRef.show();
		
	}

}

// 1. public    : can be accessed outside the package : import and access
// 2. private   : only within class
// 3. default   : only within package
// 4. protected : only within package, but inherited outside the package and behaves like private in child class