package com.amazon.datastructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.amazon.model.Product;

class EComApp{
	
	ArrayList<Product> products = new ArrayList<Product>();
	ArrayList<Product> cart = new ArrayList<Product>();
	
	void populateProducts() {
		
		Product p1 = new Product(101, "Adidas Alphabounce", 10000);
		Product p2 = new Product(301, "iPonneX", 70000);
		Product p3 = new Product(401, "Samsung LED", 50000);
		Product p4 = new Product(501, "Adidas backPack", 5000);
		Product p5 = new Product(701, "Nike BackPack", 3000);
		
		products.add(p1);
		products.add(p2);
		products.add(p3);
		products.add(p4);
		products.add(p5);
	}
	
	/*
	void showProducts() {
		for(Product product : products) {
			product.showProduct();
		}
	}*/
	
	void addProductToCart(Product product) {
		cart.add(product);
	}
	
	void removeProductFromCart(Product product) {
		cart.remove(product);
		//cart.remove(idx);
	}
	
	/*
	void showCart() {
		for(Product product : cart) {
			product.showProduct();
		}
	}*/
	
	void show(List<Product> list) { // RTP
		for(Product product : list) {
			product.showProduct();
		}
	}
	
	class SortProducts implements Comparator<Product>{
		@Override
		public int compare(Product o1, Product o2) {
			if(o1.price == o2.price)
				return 0;
			else if(o1.price > o2.price)
				return 1;
			else
				return -1;
		}
	}
	
	void applyFilter(int option) {
		if(option == 1) { 		// Price LOW to HIGH
			
			//Collections.sort(products, new SortProducts());
			
			Collections.sort(products, new Comparator<Product>() {
				@Override
				public int compare(Product o1, Product o2) {
					if(o1.price == o2.price)
						return 0;
					else if(o1.price > o2.price)
						return 1;
					else
						return -1;
				}
			});
			
		}else if(option == 2) { // Price HIGH to LOW
			Collections.sort(products, new Comparator<Product>() {
				@Override
				public int compare(Product o1, Product o2) {
					if(o1.price == o2.price)
						return 0;
					else if(o1.price < o2.price)
						return 1;
					else
						return -1;
				}
			});
		}else if(option == 3) { // Alphabetically Sorting
			Collections.sort(products, new Comparator<Product>() {
				@Override
				public int compare(Product o1, Product o2) {
					return o1.name.compareToIgnoreCase(o2.name);
				}
			});
		}else {
			
		}
	}
	
}

public class ShoppingCartApp {

	
	public static void main(String[] args) {
		
		EComApp app = new EComApp();
		app.populateProducts();
		//app.showProducts();
		app.show(app.products);
		
		
		Product product = app.products.get(0);
		app.addProductToCart(product);
		
		//product = app.products.get(2);
		app.addProductToCart(app.products.get(2));
		
		System.out.println(">> CART");
		app.show(app.cart);

		System.out.println(">> You Cart : "+app.cart.size());
		
		app.removeProductFromCart(app.products.get(0));
		
		
		System.out.println(">> CART");
		app.show(app.cart);

		System.out.println(">> You Cart : "+app.cart.size());
		
		System.out.println();
		
		System.out.println(">> Applying Filter on Price");
		app.applyFilter(1);
		System.out.println(">> After Filter");
		app.show(app.products);
		
		System.out.println(">> Applying Filter on Name");
		app.applyFilter(3);
		System.out.println(">> After Filter");
		app.show(app.products);
		
	}

}
