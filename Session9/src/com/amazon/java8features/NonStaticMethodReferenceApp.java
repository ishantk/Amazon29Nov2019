package com.amazon.java8features;

interface Order{
	String getState(int state);
}

class CustomerOrder{
	
	// Non Static Method : Property of Object
	String getOrderState(int state) {
		if (state == 1) 	return "ORDER PLACED";
		else				return "ORDER DELIVERED";
	}
}

public class NonStaticMethodReferenceApp {

	public static void main(String[] args) {
		
		CustomerOrder order = new CustomerOrder();
		//System.out.println(order.getOrderState());
		
		// Non-Static Method Reference :)
		Order oRef = order::getOrderState;  // PS: Use Object's Reference to Refer Method
		System.out.println(oRef.getState(0));

	}

}
