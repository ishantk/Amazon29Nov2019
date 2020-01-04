package com.amazon.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.amazon.model.Product;

/*
 
 	DataBase
	MySQL
	
	
	ORM : Object Relational Mapping
	      Object and its Attributes are Mapped to Table and Columns
	      Object becomes Table
	      Attributes becomes Columns
	
	      In Case Objects are Related to Each Other
	      We say, tables are rleated to each other
	
	
	JAVA:
	class Product{
		
		int pid;
		String name;
		String brandName;
		int price;
	
		Prduct(){
	
		}
	
		Prduct(int pid, String name, String brandName,int price){
		
		}
	} 

	Product pRef = new Product(1, "iPhoneX", "Apple", 70000);
	
	SQL:
	
	create table Product(
		pid int primary key auto_increment,
		name varchar(256),
		brandName varchar(256),
		price int
	)    

	insert into Product values(1, 'iPhoneX', 'Apple', 70000) 
 
 
 */

/*
 	
 	JDBC Procedure:
 	1. Load the Library i.e. Driver
 	   You need to download JDBC Type4 Driver first : https://dev.mysql.com/downloads/connector/j/
 	   Link it in your project
 	   
 	   API: Class.forname()
 	   
 	2. Create Connection with DataBase
 	   username, password, url, database name
 	   
 	   API: Connection and DriverManager
 	   
 	3. Write SQL Statement and Execute it
 		API: Statement and PreparedStatement
 	
 	4. Close the Connection to release memory resources 
 	   API: execute close() function on Connection
 	
 */

public class DBHelper {
	
	Connection con;
	Statement stmt;
	
	public DBHelper() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println(">> Driver Loaded");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void createConnection() {
		try {
			
			String user = "root";
			String password = "";
			String url = "jdbc:mysql://localhost/auridb";
			
			con = DriverManager.getConnection(url, user, password);
			System.out.println(">> Connection Created");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void saveProduct(Product product) {
		try {
			
			String sql = "insert into Product values(null, '"+product.name+"', '"+product.brandName+"', "+product.price+")";
			stmt  = con.createStatement();
			int i = stmt.executeUpdate(sql);
			System.out.println(">> SQL Statement Executed: "+i+" Row(s) Inserted");
			System.out.println(">> "+product.name+" Saved in Db");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void closeConnection() {
		try {
			con.close();
			System.out.println(">> Connection Closed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
}
