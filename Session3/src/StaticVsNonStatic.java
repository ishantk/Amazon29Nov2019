import java.util.Date;
/*
class CustomerOrder{
	
	static int orderId=0;
	String dateTime;
	
	CustomerOrder(){
		orderId++;
		Date date = new Date();
		dateTime = date.toString();
	}
	
	void showOrder() {
		System.out.println(">> OrderId: "+orderId+" placed at "+dateTime);
	}
}
*/


class Counter{
	
	// Non-Static Attribute : Property of Object and goes in the Object Container
	int count;
	
	// Static Attribute : Property of Class and goes in the Class Container
	static int sCount;
	
	// non static
	Counter(){
		count = 1;
		sCount++;
	}
	
	void incrementCount() {
		count++;
		sCount++;
	}
	
	void decrementCount() {
		count--;
		sCount--;
	}
	
	void showCount() {
		System.out.println(">> count is: "+count+" and sCount is: "+sCount);
	}
	
	// static methods
	static void showSCount() {
		System.out.println(">> sCount is: "+sCount);
		//System.out.println(">> count is: "+count); // ERROR
	}
}

public class StaticVsNonStatic {

	public static void main(String[] args) {

		/*
		CustomerOrder c1 = new CustomerOrder();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		CustomerOrder c2 = new CustomerOrder();
		
		
		
		c1.showOrder();
		c2.showOrder();
		*/
		
		Counter c1 = new Counter();
		Counter c2 = new Counter();
		Counter c3 = c1;
		
		c1.incrementCount();	// 2
		c2.incrementCount();	// 2
		c2.incrementCount();	// 3
		c2.incrementCount();	// 4
		c3.incrementCount();	// 3
		
		//c2.decrementCount();	// 3
		
		Counter c4 = new Counter();
		
		c1.showCount(); // >> count is: 3 and sCount is: 8 
		c2.showCount(); // >> count is: 4 and sCount is: 8
		c3.showCount(); // >> count is: 3 and sCount is: 8
		c4.showCount(); // >> count is: 1 and sCount is: 8
		
		Counter.showSCount();
		
		//System.out.println(">> Total Quantity: "+(c1.count+c2.count));
		
		// RULE : Object i.e. non static can access static
		//		 Property of Object can access the Property of Class
		//       But Property of Class cannot access the Property of Object
	}

}
