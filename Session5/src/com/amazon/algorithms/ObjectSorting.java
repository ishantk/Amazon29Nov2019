package com.amazon.algorithms;

class Product{
	
	int pid;
	String title;
	int price;
	
	public Product() {
		
	}
	
	public Product(int pid, String title, int price) {
		this.pid = pid;
		this.title = title;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", title=" + title + ", price=" + price + "]";
	}
	
}

class ProductSort{
	
	// Applied Insertion Sort
	// Exercise: Apply Merge Sort :)
	
	// Sorting Product on the basis of price from Low to High (Ascending)
	static void sortPrice(Product[] products) {
		for(int i=1; i<products.length; i++) {
			Product key = products[i]; 			
			int j = i-1;		 			
			
			while(j>=0 && products[j].price > key.price) {  
				products[j+1] = products[j];
				j--;
			}
			products[j+1] = key;			    
		}
	}
	
	// Sorting Product on the basis of pid from Low to High (Ascending)
	static void sortId(Product[] products) {
		for(int i=1; i<products.length; i++) {
			Product key = products[i]; 			
			int j = i-1;		 			
			
			while(j>=0 && products[j].pid > key.pid) {  
				products[j+1] = products[j];
				j--;
			}
			products[j+1] = key;			    
		}
	}
	
	static int search(Product[] products, int pid) {
		
		int idx = 0;
		
		
		return idx;
	}
	
}

public class ObjectSorting {

	public static void main(String[] args) {
		
		// Array
		Product[] products = new Product[5];
		products[0] = new Product(101, "Adidas Alphabounce", 10000);
		products[1] = new Product(301, "iPonneX", 70000);
		products[2] = new Product(201, "Samsung LED", 50000);
		products[3] = new Product(501, "Samsung Fold", 100000);
		products[4] = new Product(401, "Adidas BackPack", 3000);
		
		for(Product product : products) {
			System.out.println(product);
		}
		
		ProductSort.sortPrice(products); // on the basis of price
		
		System.out.println();
		
		
		for(Product product : products) {
			System.out.println(product);
		}
		
		ProductSort.sortId(products);  // on the basis of pid
		
		System.out.println();
		
		
		for(Product product : products) {
			System.out.println(product);
		}

	}

}
