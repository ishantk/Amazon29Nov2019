package com.amazon.designpatterns;

import java.util.Date;

interface State{
	String getState();
}

class Placed implements State{
	
	public String getState() {
		Date date = new Date();
		return "Order Is PLACED ["+date.toString()+"]";
	}
}

class Shipment implements State{
	
	public String getState() {
		Date date = new Date();
		return "Order Is In SHIPMENT ["+date.toString()+"]";
	}
}

class Delivered implements State{
	
	public String getState() {
		Date date = new Date();
		return "Order Is DELIVERED ["+date.toString()+"]";
	}
}

interface OrderStateListener{
	void orderStateChanged(State state);
}

class Order{
	
	OrderStateListener listener;
	
	void registerCustomerForOrderStateChanges(OrderStateListener listener) {
		this.listener = listener;
	}
	
	// Has-A Relationship
	State state;
	
	void changeState(State state) {
		this.state = state;
		listener.orderStateChanged(state);
	}
		
}

// Customer should register for change in state of order i.e. we need to notify customer on order state change

class Customer implements OrderStateListener{

	@Override
	public void orderStateChanged(State state) {
		System.out.println("[CUSTOMER NOTIFICATION RECEIVED]");
		System.out.println(state.getState()); // Simply Print the State of Order in Customer Object
		System.out.println("-------------------");
		System.out.println();
	}
	
}

public class StateAndObserverPattern {

	public static void main(String[] args) {
		
		// We can have 3 State Objects at any point of time
		Placed placedState = new Placed();
		Shipment shipmentState = new Shipment();
		Delivered deliveredState = new Delivered();
				
		Customer customer = new Customer();
		
		Order order = new Order();
		order.registerCustomerForOrderStateChanges(customer);
		
		order.changeState(placedState);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		order.changeState(shipmentState);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		order.changeState(deliveredState);
	}
	

}

// Observer			Customer
// Observable 		State

// PS: Explore java.util.Observer and java.util.Observable


