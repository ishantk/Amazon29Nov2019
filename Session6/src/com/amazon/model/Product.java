package com.amazon.model;

// Model or Bean or POJO (Plain Old Java Object) or Object
public class Product {
	
	public int pid;
	public String name;
	public int price;
	
	public int quantity;
	
	public Product() {
		
	}
	
	public Product(int pid, String name, int price) {
		this.pid = pid;
		this.name = name;
		this.price = price;
	}
	
	
	/*
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}*/
	
	public void showProduct() {
		System.out.println("===============================");
		System.out.println(name+" | \u20b9"+price);
		System.out.println("===============================");
		System.out.println();
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", name=" + name + ", price=" + price + "]";
	}

}
