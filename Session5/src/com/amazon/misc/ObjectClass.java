package com.amazon.misc;

// Object is parent to all the classes in Java :)
//class Customer extends Object{

class Customer{
	
	int cid;
	String name;
	
	Customer(){
		System.out.println(">> Customer Object Constructed - DEFAULT");
	}

	public Customer(int cid, String name) {
		System.out.println(">> Customer Object Constructed - PARAMETERIZED");
		this.cid = cid;
		this.name = name;
	}
	
	void show() {
		System.out.println(cid+" : "+name);
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", name=" + name + "]";
	}
	
	@Override
	public boolean equals(Object obj) { // As per RTP obj as reference variable can point to any object
	
		boolean check = true;
		
		if(obj instanceof Customer) { // if obj is basically a ref which is pointing to object of Customer
			
			Customer c = (Customer)obj; // DownCasting c and c4 will now point to same object
			if(cid == c.cid && name.equals(c.name)) {
				check = true;
			}else {
				check = false;
			}
			
		}else {
			check = false;
		}
		
		return check;
	}
	
	@Override
	public int hashCode() {
		return 11*cid;
	}
	
	/*
	@Override
	public String toString() {
		//return cid+" : "+name+" : "+super.toString();
		return cid+" : "+name+" : ";
	}*/
	
	
	
}

public class ObjectClass {

	public static void main(String[] args) {
		
		Customer c1 = new Customer();
		Customer c2 = new Customer(101, "Harry");
		
		c1.show();
		c2.show();
		
		System.out.println(">> c1 is: "+c1);
		System.out.println(">> c2 is: "+c2);
		
		System.out.println(">> c1.toString() is: "+c1.toString());
		System.out.println(">> c2.toString() is: "+c2.toString());

		System.out.println(">> c1.hashCode() is: "+c1.hashCode());
		System.out.println(">> c2.hashCode() is: "+c2.hashCode());
		
		System.out.println(">> c1.getClass() is: "+c1.getClass());
		System.out.println(">> c2.getClass() is: "+c2.getClass());
		
		System.out.println(">> c1.getClass() is: "+c1.getClass().getSimpleName());
		System.out.println(">> c2.getClass() is: "+c2.getClass().getSimpleName());
		
		Customer c3 = new Customer(102, "Fionna");
		Customer c4 = new Customer(102, "Fionna");
		
		System.out.println(">> c3 hashCode: "+c3.hashCode());
		System.out.println(">> c4 hashCode: "+c4.hashCode());
		
		if(c3 == c4) {
			System.out.println(">> c3 == c4");
		}else {
			System.out.println(">> c3 != c4");
		}
		
		if(c3.equals(c4)) {
			System.out.println(">> c3 equals c4");
		}else {
			System.out.println(">> c3 not equals c4");
		}
		
		System.out.println(">> c3 is: "+c3);
		System.out.println(">> c4 is: "+c4);
		
	}

}
