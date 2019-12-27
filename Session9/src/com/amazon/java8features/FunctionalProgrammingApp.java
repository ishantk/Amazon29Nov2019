package com.amazon.java8features;

// Taking AmzonPay Dummy Use Case

// Functional Interface : It has only 1 single abstract method
//						: Having only 1 Rule
// @FunctionalInterface : is an annotation in java. It restricts interface to have only 1 single abstract method

@FunctionalInterface
interface AmazonPay{
	void onResult(String message);
	//void onSuccess(); err
	//void onFailure(); err
}

//If some other interface extends Functional Interface, its now a Functional Interface
interface Inf extends AmazonPay{
	void hello();
	void bye();
}

@FunctionalInterface
interface GooglePay{
	void onResult(String message);
	
	// Belongs to Object class
	int hashCode(); 	// This is Allowed
	String toString();  // This is Allowed
}




//class ZomatoPayments extends Object implements AmazonPay{
class ZomatoPayments implements AmazonPay{
	
	@Override
	public void onResult(String message) {
		System.out.println(">> Message is: "+message);
		if(message.startsWith("SUCCESS")) {
			System.out.println(">> Payment Processing Done");
		}else {
			System.out.println(">> Payment Processing Failed");
		}
	}
}

public class FunctionalProgrammingApp {

	public static void main(String[] args) {
		
		AmazonPay pay = new ZomatoPayments();
		pay.onResult("SUCCESS - Payments Processed");

	}

}
