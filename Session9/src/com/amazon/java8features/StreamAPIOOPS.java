package com.amazon.java8features;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPIOOPS {

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
		
		// Implement map on products list for a flat 50% off
		
		// Filter on Products List
//		List<Product> filteredProducts = products.stream().filter(p-> p.price>30000).collect(Collectors.toList()); 
//		for(Product product : filteredProducts) {
//			System.out.println(product);
//		}
		
		// Filter on Products List and thereafter for each loop
		products.stream().filter(p-> p.price>30000).forEach(product->System.out.println(product));
		
		// Reduce the Price of Products to 1 single total amount
//		Integer totalPrice = products.stream().map(p->p.price).reduce(0, (sum, price) -> sum+price);
//		System.out.println(">> Total Price: "+totalPrice);
		
		Integer totalPrice = products.stream().collect(Collectors.summingInt(p->p.price));
		System.out.println(">> Total Price: "+totalPrice);
	}

}
