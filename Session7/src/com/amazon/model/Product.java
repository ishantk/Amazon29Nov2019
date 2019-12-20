package com.amazon.model;

// Model or Bean or POJO (Plain Old Java Object)
public class Product {
	
	public int pid;
	public String name;
	public int price;
	
	public Product() {
		
	}
	
	public Product(int pid, String name, int price) {
		this.pid = pid;
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", name=" + name + ", price=" + price + "]";
	}

}
