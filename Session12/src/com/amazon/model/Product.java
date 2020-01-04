package com.amazon.model;

// Model
public class Product {

	public int pid;
	public String name;
	public String brandName;
	public int price;
	
	public Product() {
		
	}
	
	public Product(int pid, String name, String brandName, int price) {
		this.pid = pid;
		this.name = name;
		this.brandName = brandName;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Prdouct [pid=" + pid + ", name=" + name + ", brandName=" + brandName + ", price=" + price + "]";
	}
	
	
	
}
