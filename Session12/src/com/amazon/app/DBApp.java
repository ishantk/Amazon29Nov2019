package com.amazon.app;

import com.amazon.db.DBHelper;
import com.amazon.model.Product;

public class DBApp {

	public static void main(String[] args) {
		
		// Creating the Object which has data
		Product product = new Product(0, "Alphabounce Shoe", "Adidas", 5000);
		System.out.println(">> product is: "+product);
		
		// The moment App will finish, data in object will be lost
		// we must persist the state of object
		// 1. Files ->  .txt, .csv, .dat, .xml
		// 2. DataBase -> MySQL, Oracle, MongoDb, Firebase, Neo4J, Amazon Family of Databses
		
		DBHelper db = new DBHelper();
		db.createConnection();
		db.saveProduct(product);
		db.closeConnection();
	}

}
