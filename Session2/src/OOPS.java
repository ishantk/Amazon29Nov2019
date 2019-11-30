/*
 
 	-----------------
	Principle of OOPS
	-----------------
	1. Think of an Object
	2. Create its Class i.e. Drawing
	3. From Class i.e Drawing create a Real Object
	
 */


// 1. Think of an Object
// Restaurant is an Object
// attributes: name, email, phone, address, pricePerPerson, rating


// 2. Create its Textual Representation i.e. Class
class Restaurant{
	
	// Attributes of Object : Restaurant | Data Member or Instance Variable or State of Object
	// Property of Object and not of class : 
	// i.e. if we coded them in class its not the property of class, its the property of object
	String name;
	String email;
	String phone;
	String address;
	int pricePerPerson;
	double rating;
	
	// Constructor : Special Method -> Same Name as of Class Name and No Return Type
	//               If we create objects, let object have some default data rather than nulls and 0's
	// The moment we create object in memory -> Constructor is executed automatically in first place
	// Constructor with No Inputs : Default Constructor
	Restaurant(){
		name = "NA";
		email = "NA";
		phone = "NA";
		address = "NA";
		pricePerPerson = 100;
		rating = 3.0;
	}
	
	// Constructor Overloading
	
	// Constructor with Inputs : Parameterized Constructor
	Restaurant(String name, String email, String phone, String address, int pricePerPerson, double rating) {
		// this is a reference variable which will hold the HashCode of current object
		// LHS this.name is attribute of object
		// RHS name is input to method
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.pricePerPerson = pricePerPerson;
		this.rating = rating;
	}
	
	// PS: if you will not create constructor, compiler will create it
	//	   and will put all nulls and 0's in it.
	
	// Method : non static
	// Which belongs to Object and not to Class
	void writeDataInRestaurant(String name, String email, String phone, String address, int pricePerPerson, double rating) {
		// this is a reference variable which will hold the HashCode of current object
		// LHS this.name is attribute of object
		// RHS name is input to method
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.pricePerPerson = pricePerPerson;
		this.rating = rating;
	}
	
	void readDataFromRestaurant() {
		System.out.println("----------------------------");
		System.out.println("| "+name+"  \u20b9"+pricePerPerson);
		System.out.println("| "+address);
		System.out.println("| "+phone+"  "+email);
		System.out.println("----------------------------");
	}
	
}

public class OOPS {

	public static void main(String[] args) {
		
		// 3. From Class lets create real Object in memory
		// Object Construction Statement
		Restaurant restuarant1 = new Restaurant();
		// restuarant1 is a Reference Variable in Stack, which will have the HashCode of Restaurant Object
		// new create Restaurant Object in the memory at run time i.e. dynamically in the Heap
		
		Restaurant restuarant2 = new Restaurant();
		
		// Reference Copy
		Restaurant restuarant3 = restuarant1; 
		
		System.out.println(">> restuarant1 is: "+restuarant1);
		System.out.println(">> restuarant2 is: "+restuarant2);
		System.out.println(">> restuarant3 is: "+restuarant3);
		
		// OPERATIONS ON OBJECTS
		
		// 1. Write Data in Object
		/*
		restuarant1.name = "Fionnas Coffee Shop";
		restuarant1.email = "fionna@example.com";
		restuarant1.phone = "+91 99999 88888";
		restuarant1.address = "Redwood Shores";
		restuarant3.pricePerPerson = 300;
		restuarant3.rating = 4.5;
		
		restuarant2.name = "Jacks Pizzeria";
		restuarant2.email = "@example.com";
		restuarant2.phone = "+91 98765 88888";
		restuarant2.address = "Country Homes";
		restuarant2.pricePerPerson = 200;
		restuarant2.rating = 4.75;
		*/
		
		restuarant1.writeDataInRestaurant("Fionnas Coffee Shop", "fionna@example.com", "+91 99999 88888", "Redwood Shores", 300, 4.5);
		restuarant2.writeDataInRestaurant("Jacks Pizzeria", "jack@example.com", "+91 98765 88888", "Country Homes", 200, 4.75);
		
		// 2. Update Data in Object
		restuarant3.phone = "+91 91991 81881";
		
		// 3. Read Data from Object
		//System.out.println(">> "+restuarant1.name+" is located at "+restuarant3.address);
		//System.out.println(">> "+restuarant3.name+" will have \u20b9"+restuarant1.pricePerPerson+" Price Per Person");
		
		restuarant1.readDataFromRestaurant();
		
		
		System.out.println();
		
		restuarant2.readDataFromRestaurant();
		
		//System.out.println(">> "+restuarant2.name+" is located at "+restuarant2.address);
		//System.out.println(">> "+restuarant2.name+" will have \u20b9"+restuarant2.pricePerPerson+" Price Per Person");
		
		// 4. Delete Data from Object or Delete Object
		// We cannot delete data from Object once created
		// We cannot delete Object, but GC will take care of it or we can execute System.gc();
		
		// CHALLENGE:
		// If we now create n-number of Objects and write and read in them, it will be lot of code hence.
		// As a Solution we will create methods in the object
		
		System.out.println();
		
		Restaurant restaurant4 = new Restaurant();
		restaurant4.readDataFromRestaurant();
		
		System.out.println();
		
		Restaurant restuarant5 = new Restaurant("Jim's Burger", "jim@example.com", "+91 99999 66666", "Eastern Shores", 100, 5.0);
		restuarant5.writeDataInRestaurant("Jim's Awesome Burger", "jim@example.com", "+91 98709 66666", "Eastern Shores", 150, 5.0);
		
		restuarant5.readDataFromRestaurant();

	}

}
