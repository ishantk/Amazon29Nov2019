import javax.swing.text.AbstractDocument.LeafElement;

public class ValueVsRef {

	void blackFridaySale(double product1Price, double product2Price) {
		
		System.out.println(">> product1 Price for BlackFriday BEFORE is: "+product1Price);
		System.out.println(">> product2 Price for BlackFriday BEFORE is: "+product2Price);
		
		product1Price = product1Price - (0.3 * product1Price);
		product2Price = product2Price - (0.5 * product2Price);
		
		System.out.println(">> product1 Price for BlackFriday AFTER is: "+product1Price);
		System.out.println(">> product2 Price for BlackFriday AFTER is: "+product2Price);
	}
	
	void blackFridaySale(double[] prices) {
		System.out.println(">> prices is: "+prices+" and length is: "+prices.length);
		
		for(int i=0;i<prices.length;i++) {
			prices[i] -= (0.2 * prices[i]); // prices[i] =  prices[i] - (0.2 * prices[i]);
		}
		
	}
	
	
	
	public static void main(String[] args) {
		
		double price1 = 1000.55;
		double price2 = 1700.99;
		

		//System.out.println(">> price1 BEFORE is: "+price1);
		//System.out.println(">> price2 BEFORE is: "+price2);
		
		ValueVsRef vRef = new ValueVsRef();
		System.out.println(">> vRef is: "+vRef);
		/*
		// VALUE COPY
		vRef.blackFridaySale(price1, price2); // execution statement
		
		System.out.println(">> price1 AFTER is: "+price1);
		System.out.println(">> price2 AFTER is: "+price2);
		*/
	
		double[] productPrice = {1200.12, 1500, 907, 567, 889.12};
		//productPrice is a Reference Variable which holds the HashCode of Array 
		System.out.println(">> productPrice is: "+productPrice+" and length is: "+productPrice.length);
	
		for(double element : productPrice) {
			System.out.print(element+"  ");
		}
		
		System.out.println();
		
		
		// REFERENCE COPY
		vRef.blackFridaySale(productPrice); 
		
		for(double element : productPrice) {
			System.out.print(element+"  ");
		}

	}

}
