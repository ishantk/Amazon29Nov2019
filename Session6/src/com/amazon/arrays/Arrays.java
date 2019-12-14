package com.amazon.arrays;

import com.amazon.model.Product;

class ShoppingCart{
	
	static int idx = 0;
	
	Product[] products; // Has-A Relationship | 1 to many
	
	ShoppingCart(){
		// having size as 5 is a limitation. What if customer wish to add another product
		products = new Product[5]; // We crated array of products with size as 5
		System.out.println(">> Cart Array created at HashCode: "+products +" LENGTH: "+products.length);
	}
	
	void addProduct(Product product) {
		products[idx] = product;
		idx++;
	}
	
	void showProductsInCart() {
		System.out.println(">> SIZE: "+idx);
		for(int i=0;i<idx;i++) {
			System.out.println(products[i]);
		}
	}
	
	void removeProduct(Product product) {
		for(int i=0;i<idx;i++) {
			if(products[i].pid == product.pid) {
				products[i] = null;
			}
		}
	}
	
	void resizeCart() {
		// RESIZING is Creating a New Array
		// OLD Array is deleted and new Array is created
		Product[] temp = products;
		products = new Product[10];
		System.out.println(">> Cart Array Resized =and HashCode: "+products +" LENGTH: "+products.length);
		
		/*
		for(int i=0;i<temp.length;i++) {
			products[i] = temp[i];
		}
		
		temp = null;*/
		
		System.arraycopy(temp, 0, products, 0, temp.length);
	}
}

public class Arrays {

	public static void main(String[] args) {
		
		int[] arr1 = new int[5];
		int[] arr2 = {10, 20, 30, 40, 50};
		
		Product p1 = new Product(101, "Adidas Alphabounce", 10000);
		Product p2 = new Product(301, "iPonneX", 70000);
		Product p3 = new Product(201, "Samsung LED", 50000);
		Product p4 = new Product(501, "Samsung Fold", 100000);
		Product p5 = new Product(401, "Adidas BackPack", 3000);
		Product p6 = new Product(701, "Nike BackPack", 3300);
		
		ShoppingCart cart = new ShoppingCart();
		cart.addProduct(p1);
		cart.addProduct(p4);
		cart.addProduct(p6);
		cart.addProduct(p2);
		cart.addProduct(p3);
		//cart.addProduct(p5);
		
		cart.showProductsInCart();

		//cart.removeProduct(p4);
		
		cart.resizeCart();
		
		cart.showProductsInCart();
		
	}

}

// PS: Arrays are Fixed in Size. We cannot dynamically change the Size
//     Changing size means creating a new Array in the memory !! AND do not forget to copy array
