package com.amazon.java8features;

// Some App to Track User's Location 
// Functional Interface

@FunctionalInterface
interface LocationListener{
	void onLocationChanged(double latitude, double longitude);
}

@FunctionalInterface
interface Email{
	String sendEmail(String from, String to);
}


interface Hello{
	void hello();
}

class TrackingApp implements LocationListener{
	
	int x;
	
	@Override
	public void onLocationChanged(double latitude, double longitude) {
		System.out.println(">> New Location Found: "+latitude+" : "+longitude);
	}
}

public class LambdExpressionApp {

	public static void main(String[] args) {
		
//		LocationListener listener = new TrackingApp();
//		listener.onLocationChanged(75.5633, 73.123);
		
		// Lets write Anonymous Class for the same :)
		// For Anonymous class, it has no name !!
		// we will have an object created and hashcode of that object will be available in ref var listener
		
		/*
		LocationListener listener1 = new LocationListener() {
			
			// Attribute to Anonymous Class
			int x;
			// static int y; | Not Allowed
			
			// Initializer Block which serves as constructor for us :)
			{
				x = 100;
			}
		
			@Override
			public void onLocationChanged(double latitude, double longitude) {
				System.out.println(">> New Location Found: "+latitude+" : "+longitude);
			}
		
		};

		listener1.onLocationChanged(75.5633, 73.123);
		
		// PS: Where Anonymous Classes are Preferred ?
		//     Where we have only 1 single object requirement 
		
		*/
		
		
		// Let us Use Lambda Expression instead of Anonymous Class
		// Quite reduction in syntax and lines of code
		LocationListener listener2 = (double latitude, double longitude)->{ 
			System.out.println(">> New Location Found: "+latitude+" : "+longitude);
		};
		
		listener2.onLocationChanged(75.5633, 73.123);
		
//		Email email = (from, to) -> {
//			String message = "Email Sent to "+to+" from "+from;
//			return message;
//		};
		
		Email email = (a, b) -> {
			String message = "Email Sent to "+a+" from "+b;
			return message;
		};
		
//		Email email = (String from, String to) -> {
//			String message = "Email Sent to "+to+" from "+from;
//			return message;
//		};
		
		String message = email.sendEmail("jack@example.com", "kim@example.com");
		System.out.println(">> Message: "+message);
		
		Hello hello = ()->{
			System.out.println(">> Hello from Java 8");
		};
		
		hello.hello();
		
		
	}

}
