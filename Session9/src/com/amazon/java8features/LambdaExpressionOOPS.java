package com.amazon.java8features;

import java.util.ArrayList;
import java.util.List;

class Customer{
	
	String name;
	String email;
	int age;
	
	String getCustomerDetails() {
		return ">> Details: "+name+" | "+email+" | "+age;
	}
}

@FunctionalInterface
interface Member{
	String makeMember(Customer customer);
}

public class LambdaExpressionOOPS {

	public static void main(String[] args) {
		
		// Lambda Expression
		Member member = (customer)->{
			String message = "Thank You "+customer.name+" for being a Member with us !!\n"+customer.getCustomerDetails();
			return message;
		};
		
		Customer customer = new Customer();
		customer.name = "Anna";
		customer.email = "anna@example.com";
		customer.age = 20;
		
		String message = member.makeMember(customer);
		System.out.println(">> Message After Making Member is: "+message);
		
		
		List<String> names = new ArrayList<String>();
		names.add("Kia");
		names.add("Fionna");
		names.add("Mike");
		names.add("Leo");
		names.add("Dave");
		names.add("Anna");
	
		
		// Enhanced For Loop OR for Each Loop
		for(String name : names) {
			System.out.println(">> "+name);
		}
		
		System.out.println();

		// Lambda Expression on forEach Loop with Collections 
		names.forEach(
			(name)->System.out.println(">> "+name)
		);
		
	}

}
