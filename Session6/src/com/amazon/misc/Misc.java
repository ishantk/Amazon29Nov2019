package com.amazon.misc;

class One{
	
	void show() {
		System.out.println(">> This is show of One");
	}
	
	// Inner or Nested Class
	// Object in an Object (Containment)
	class Two{
		void show() {
			System.out.println(">> This is show of Two");
		}
	}
}

// SINGLETON : Only One Object Per Class :)
class Connection{
	
	static Connection con = new Connection(); // Self References
	
	private Connection(){
		System.out.println(">> Connection Object Constructed: "+this);
	}
	
}

public class Misc {

	public static void main(String[] args) {
		
		/*
		One oRef  = new One();
		oRef.show();
		
		One.Two tRef = oRef.new Two();
		tRef.show();
		*/
		
		/*
		Connection c1 = new Connection();
		Connection c2 = new Connection();
		Connection c3 = new Connection();*/
		
		Connection c1 = Connection.con;
		Connection c2 = Connection.con;
		Connection c3 = Connection.con;
		
	}

}
