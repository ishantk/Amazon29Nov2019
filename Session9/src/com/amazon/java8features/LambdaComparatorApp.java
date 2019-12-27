package com.amazon.java8features;

import java.util.Comparator;
import java.util.LinkedList;

class Product{
	
	int pid;
	String name;
	int price;
	
	Product(){
		
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

// Comparator is a Functional Interface with only 1 Function called compare

class SortProducts implements Comparator<Product>{

	public int compare(Product o1, Product o2) {
		if (o1.price > o2.price)		return 1;
		else if (o1.price < o2.price)	return -1;	
		else							return 0;
	}
}

public class LambdaComparatorApp {

	public static void main(String[] args) {
		
		Product p1 = new Product(101, "Adidas Alphabounce", 5000);
		Product p2 = new Product(201, "Adidas BackPack", 300);
		Product p3 = new Product(701, "Nike Track Suit", 2000);
		Product p4 = new Product(301, "Apple iPhone", 50000);
		Product p5 = new Product(501, "Samsung LED TV", 45000);
		
		LinkedList<Product> products = new LinkedList<Product>();
		products.add(p1);
		products.add(p2);
		products.add(p3);
		products.add(p4);
		products.add(p5);
		
		/*
		Comparator<Product> comparator = new Comparator<Product>() {
			@Override
			public int compare(Product o1, Product o2) {
				return 0;
			}
		};*/
		
		// Write a Lambda Expression on Comparator and Sort the Data :)
		
		/*
		products.sort(new SortProducts());
		
		for(Product product : products) {
			System.out.println(product);
		}*/
		
		// Lambda Expression for Comparator
		/*
		Comparator<Product> comparator = (Product o1, Product o2) ->{
			if (o1.price > o2.price)		return 1;
			else if (o1.price < o2.price)	return -1;	
			else							return 0;
		};
		
		products.sort(comparator);
		*/
		
		products.sort(
				(Product o1, Product o2) ->{
					if (o1.price > o2.price)		return 1;
					else if (o1.price < o2.price)	return -1;	
					else							return 0;
				}	
		);
		
		/*
		for(Product product : products) {
			System.out.println(product);
		}*/
		
		products.forEach(
				(product)->System.out.println(">> "+product)
			);
		
		
		

	}

}
