/*
 	
 	1. Think of Object and Relationships
 	Write as many as attributes you can for a better software 
 	Dish
		name
		price
		quantity

	Menu	
		dishes[]

	Restaurant
		name
		phone
		email
		address
		menu
 	
 */

// 2. Create Class which is representation of Object
//	  What we code in class is Property of Object and not of Class


class Dish{
	// Attributes or State or Instance Variable or Data Memebers of Object and not of class
	// Property of Object
	String name;
	int price;
	int quantity;
	
	// Default Constructor - Property of Object
	Dish(){
		name = "NA";
		price = 0;
		quantity = 0;
	}
	
	// Parameterized Constructor - Property of Object
	Dish(String name, int price, int quantity){
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	// Methods
	// 1. Setter Method -> To update data in Object
	void setDishDetails(String name, int price, int quantity){
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	//2. Reader/View Method
	void showDishDetails() {
		System.out.println("==========="+name+"==========");
		System.out.println("Price: \u20b9"+price);
		System.out.println("Quantity: "+quantity+" grams");
		System.out.println("=============================");
	}
}

class Menu{
	
	// Attribute : Property of Menu Object
	String title;
	Dish[] dishes; // 1 to many Relationship | HAS-A Relation
	
	Menu(){
		title = "NA";
		dishes = null;
	}
	
	Menu(String title, Dish[] dishes){
		this.title = title;
		this.dishes = dishes;
	}
	
	void setMenuDetails(String title, Dish[] dishes){
		this.title = title;
		this.dishes = dishes;
	}
	
	void showMenuDetails() {
		System.out.println("^^^^^^^Menu: "+title+"^^^^^^^");
		// Basic For Loop
		/*for(int i=0;i<dishes.length;i++) {
			dishes[i].showDishDetails();
		}*/
		
		// Enhanced For Loop / For-Each Loop
		for(Dish dish : dishes) {
			dish.showDishDetails();
		}
		
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	}
	
}

class Restaurant{
	
	String name;
	String phone;
	String email;
	String address;
	Menu menu; // Has-A Relationship | 1 to 1 Relationship
	
	Restaurant(){
		name = "NA";
		phone = "NA";
		email = "NA";
		address = "NA";
		menu = null;
	}
	
	Restaurant(String name, String phone, String email, String address, Menu menu){
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.menu = menu;
	}
	
	void setRestaurantDetails(String name, String phone, String email, String address, Menu menu){
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.menu = menu;
	}
	
	void showRestaurantDetails() {
		System.out.println("********"+name+"********");
		System.out.println("Phone: "+phone);
		System.out.println("Email: "+email);
		System.out.println("Address: "+address);
		
		menu.showMenuDetails();
		
		System.out.println("************************");
	}
	
}

// Customer will place an Order from Restaurant. Order will have Dishes!!

class Customer{
	
	String name;
	String phone;
	String email;
	String address;
	
	Customer() {
		name = "NA";
		phone = "NA";
		email = "NA";
		address = "NA";
	}
	
	Customer(String name, String phone, String email, String address) {
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}
	
	void setCustomerDetails(String name, String phone, String email, String address) {
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}
	
	void showCustomerDetails() {
		System.out.println("########"+name+"########");
		System.out.println("Phone: "+phone);
		System.out.println("Email: "+email);
		System.out.println("Address: "+address);
		System.out.println("########################");
	}
	
}

class Order{
	
	int oid;
	String dateTimeStamp;
	Restaurant restaurant; // 1 to 1
	Customer customer;	   // 1 to 1
	Dish[] dishes;		   // 1 to many
	
	Order(){
		oid = 0;
		dateTimeStamp = "NA";
		restaurant = null;
		customer = null;
		dishes = null;
	}
	
	Order(int oid, String dateTimeStamp, Restaurant restaurant, Customer customer, Dish[] dishes){
		this.oid = oid;
		this.dateTimeStamp = dateTimeStamp;
		this.restaurant = restaurant;
		this.customer = customer;
		this.dishes = dishes;
	}
	
	void setOrderDetails(int oid, String dateTimeStamp, Restaurant restaurant, Customer customer, Dish[] dishes){
		this.oid = oid;
		this.dateTimeStamp = dateTimeStamp;
		this.restaurant = restaurant;
		this.customer = customer;
		this.dishes = dishes;
	}
	
	void showOrderDetails() {
		System.out.println("$$$$$ ORDER ID: [ "+oid+" ]$$$$$$");
		System.out.println("DateTime: "+dateTimeStamp);
		System.out.println("Restaurant: "+restaurant.name);
		System.out.println("Customer: "+customer.name+" "+customer.address+" "+customer.phone);
		
		int total = 0;
		
		for(Dish dish : dishes) {
			dish.showDishDetails();
			total += dish.price;
		}
		
		System.out.println("@@@ Please Pay: \u20b9"+total);
		
		System.out.println("$$$$$$$$$$$$$$$$$$");
	}
	
	// Business Method
		double applyPromoCode(double amount, int promoCode) {
			
			double priceToPay = 0.0;
			double discount = 0.0;
			
			if( (amount>=100 && amount<200)) {
				if(promoCode == 1) {
					discount = 0.1;
				}else {
					System.out.println(">> You must Use Promo Code 1 to get 10% OFF");
				}
			}else if ( (amount>=200 && amount<500) ) {
				if(promoCode == 2) {
					discount = 0.2;
				}else {
					System.out.println(">> You must Use Promo Code 2 to get 20% OFF");
				}
			}else if(amount>=500){
				if(promoCode == 3) {
					discount = 0.5;
				}else {
					System.out.println(">> You must Use Promo Code 3 to get 50% OFF");
				}
			}else {
				discount = 0;
				System.out.println(">> SORRY NO DISCOUNTS");
			}
			
			priceToPay = amount - (discount*amount);
			
			return priceToPay;
			
		}
	
}

public class HASARelationship {

	public static void main(String[] args) {
		
		/*
		
		//Dish dish1 = new Dish(); // Dish(); -> Execution of Default Constructor
		Dish dish1 = new Dish("Yellow Dal", 150, 200);
		Dish dish2 = new Dish("Paneer", 300, 300);
		Dish dish3 = new Dish("Dosa", 200, 1);
		Dish dish4 = new Dish("Noodles", 100, 1);
		Dish dish5 = new Dish("Burger", 50, 1);
		
		Dish[] dishes = new Dish[5];
		dishes[0] = dish1; // Reference Copy
		dishes[1] = dish2; // Reference Copy
		dishes[2] = dish3; // Reference Copy
		dishes[3] = dish4; // Reference Copy
		dishes[4] = dish5; // Reference Copy
		
		System.out.println(">> dish1 is: "+dish1);
		System.out.println(">> dishes[0] is: "+dishes[0]);
		
		System.out.println(">> dish2 is: "+dish2);
		System.out.println(">> dishes[1] is: "+dishes[1]);
		
		*/
		
		// Array of Dishes
		Dish[] dishes = new Dish[5];
		dishes[0] = new Dish("Yellow Dal", 150, 1);
		dishes[1] = new Dish("Paneer", 300, 1);
		dishes[2] = new Dish("Dosa", 200, 1);
		dishes[3] = new Dish("Noodles", 100, 1);
		dishes[4] = new Dish("Burger", 50, 1);
		
		Menu menu = new Menu("Groovy Gravy", dishes); // 1 to many Relationship linking
		
		Restaurant restaurant = new Restaurant("Harry's Wonder Cafe", "+91 99999 88888", "cafe19@example.com", "Redwood Shores", menu); // 1 to 1 Relationship Linking
		
		//restaurant.showRestaurantDetails();
		
		Customer customer = new Customer("Fionna", "+91 98765 00900", "fionna@example.com", "Country Homes");
		
		Dish[] myDishes = new Dish[2];
		myDishes[0] = dishes[2];
		myDishes[1] = dishes[4];
		
		Order order = new Order(1, "6th Dec, 2019 / 12:11", restaurant, customer, myDishes);
		order.showOrderDetails();
				

	}

}
