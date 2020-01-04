package com.amazon.designpatterns;

// Create a Rule Book for Any Type of Plan
interface Plan{
	String showDescription();
	int getPrice();
}

class Plan2G implements Plan{
	
	int data;
	int price;
	
	Plan2G(){
		data = 5; // 5 GB of 2G Data 
		price = 200;
	}

	@Override
	public String showDescription() {
		return "Plan2G Shall Offer "+data+" GB of data !!";
	}

	@Override
	public int getPrice() {
		return price;
	}
	
}

class Plan3G implements Plan{
	
	int data;
	int price;
	
	Plan3G(){
		data = 10; // 10 GB of 3G Data 
		price = 400;
	}

	@Override
	public String showDescription() {
		return "Plan3G Shall Offer "+data+" GB of data !!";
	}

	@Override
	public int getPrice() {
		return price;
	}
	
}

class Plan4G implements Plan{
	
	int data;
	int price;
	
	Plan4G(){
		data = 20; // 20 GB of 4G Data 
		price = 400;
	}

	@Override
	public String showDescription() {
		return "Plan4G Shall Offer "+data+" GB of data !!";
	}

	@Override
	public int getPrice() {
		return price;
	}
	
}

class PlanFactory{
	
	static Plan getPlan(int type) {
		
		Plan plan = null;
		
		switch (type) {
			case 2:
				plan = new Plan2G();
				break;
				
			case 3:
				plan = new Plan3G();
				break;
				
			case 4:
				plan = new Plan4G();
				break;
		}
		
		return plan;
	}
	
	static void showPlan(int type) {
		
		Plan plan = null;
		
		switch (type) {
			case 2:
				plan = new Plan2G();
				break;
				
			case 3:
				plan = new Plan3G();
				break;
				
			case 4:
				plan = new Plan4G();
				break;
		}
		
		System.out.println("Description: "+plan.showDescription());
		System.out.println("Price: \u20b9"+plan.getPrice());
		
	}
	
}


public class FactoryPattern {

	public static void main(String[] args) {
		
//		Plan plan = PlanFactory.getPlan(4);
//		System.out.println("Description: "+plan.showDescription());
//		System.out.println("Price: \u20b9"+plan.getPrice());
		
		PlanFactory.showPlan(2);
		

	}

}
