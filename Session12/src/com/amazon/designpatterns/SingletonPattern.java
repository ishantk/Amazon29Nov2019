package com.amazon.designpatterns;

class Connection{
	
	private static Connection connection = new Connection();
	
	private Connection(){
		System.out.println(">> Connection Constructed "+this);
	}
	
	public static Connection getConnection() {
		return connection;
	}
	
	//void closeConnection()
	
}

public class SingletonPattern {

	public static void main(String[] args) {
		
		Connection con1 = Connection.getConnection();
		Connection con2 = Connection.getConnection();
		Connection con3 = Connection.getConnection();
		
		System.out.println(">> con1 is: "+con1);
		System.out.println(">> con2 is: "+con2);
		System.out.println(">> con3 is: "+con3);
		

	}

}
