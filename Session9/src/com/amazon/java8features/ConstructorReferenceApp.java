package com.amazon.java8features;

// Functional Interface
interface IMessage{
	// Returns a Message Object
	Message getMessage(String text, String dateTime);
}

class Message{
	
	Message(String text, String dateTime){
		System.out.println(">> Message : "+text+" | "+dateTime);
	}
	
}

public class ConstructorReferenceApp {

	public static void main(String[] args) {
		
		// Message mRef = new Message("Lets go for a Break !!", "11:15AM");
		
		// Constructor Reference
		IMessage iRef = Message :: new; 
		iRef.getMessage("Lets go for a Break !!", "11:15AM");

	}

}
