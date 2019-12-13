package com.amazon.misc;

// Polymorphic Behaviour

class Payment<T>{
	
	T amount;
	
	Payment(T amount){
		this.amount = amount;
	}
	
	void show() {
		System.out.println(">> Payment Amount is: "+amount);
	}
}

class DebitCard{
	String number;
	String name;
	String expiry;
	int cvv;
}

class Cab<T, U>{
	
}

public class Generics {

	public static void main(String[] args) {
		
		DebitCard dc1 = new DebitCard();
		
		Payment<Integer> p1 = new Payment<Integer>(100);
		Payment<Double> p2 = new Payment<Double>(100.22);
		Payment<String> p3 = new Payment<String>("INR 1000");
		Payment<DebitCard> p4 = new Payment<DebitCard>(dc1);
		
		Payment p5 = new Payment(7.5);
		
		p1.show();
		p2.show();
		p3.show();
		
		Cab<Integer, String> c1 = new Cab<Integer, String>();
		Cab<Integer, DebitCard> c2 = new Cab<Integer, DebitCard>();		

	}

}
