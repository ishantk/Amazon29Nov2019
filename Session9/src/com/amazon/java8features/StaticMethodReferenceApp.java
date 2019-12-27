package com.amazon.java8features;

interface ClickListener{
	void onClick(int state);
}

class MyApp{
	
	// Static Method : Property of Class
	public static void clickHandler(int state) {
		if(state == 1) {
			System.out.println(">> Button Click Captured");
		}else {
			System.out.println(">> Button Press Captured");
		}
	}
	
}

public class StaticMethodReferenceApp {

	public static void main(String[] args) {
		
		/*
		ClickListener listener = (state)->{
			
		};
		*/
		
		// Static Method Reference :)
		ClickListener listener = MyApp::clickHandler; // PS: Use Class Name to Refer Method
		listener.onClick(1);
		
	}

}
