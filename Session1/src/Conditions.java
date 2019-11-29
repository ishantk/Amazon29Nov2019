import java.util.Scanner; // import the class Scanner to be used in our program

public class Conditions {

	public static void main(String[] args) {
		
		// Get the Amount from User
		// if amount is greater than 500, apply flat 50% Discount
		// if amount is greater than 300 but less than 500, apply flat 30% Discount
		// otherwise offer a flat 10%
		
		//int amount = 700; // Hard Code
		
		double amount = 0;
		double discountedPrice = 0;
		System.out.println(">> Enter Your Amount: ");
		
		Scanner scanner = new Scanner(System.in);
		amount = scanner.nextDouble();
		
		System.out.println(">> You Eneterd: \u20b9"+amount);
		
		/*
		// if/else
		if(amount>=500) {
			discountedPrice = amount - (0.5 * amount);
			System.out.println(">> Please Pay: \u20b9"+discountedPrice);
			System.out.println(">> You Saved \u20b9"+ (amount - discountedPrice));
		}else {
			System.out.println(">> Sorry No Discounts for You !!");
		}*/
		
		double discount = 0.0;

		// Ladder if/else
		if(amount>=500) {
			discount = 0.5;
		}else if(amount>=300 && amount < 500) {
			discount = 0.3;
		}else {
			discount = 0.1;
		}
		
		discountedPrice = amount - (discount * amount);
		System.out.println(">> Please Pay: \u20b9"+discountedPrice);
		System.out.println(">> You Saved \u20b9"+ (amount - discountedPrice));
		
		// Nested if/else
		boolean isInternetOn = true;
		boolean isGPSOn = false;
		
		if(isInternetOn) {
			System.out.println(">> You can browse Google Maps");
			
			if(isGPSOn) {
				System.out.println(">> You can navigate using Google Maps");
			}else {
				System.out.println(">> Please enable GPS and try again later");
			}
			
		}else {
			System.out.println(">> Please enable internet and try again later");
		}
		
		// Switch Case
		final int netBanking = 1;
		int payTm = 2;
		int amazonPay = 3;
		int creditDebitCard = 4;
		int cashOnDelivery = 5;
		
		int choice = netBanking;
		/*
		if(choice == netBanking) {
			System.out.println(">> Please process Payment from Net Banking");
		}else if(choice == payTm) {
			System.out.println(">> Please process Payment from PayTm");
		}else if(choice == amazonPay) {
			System.out.println(">> Please process Payment from Amazon Pay");
		}else if(choice == creditDebitCard) {
			System.out.println(">> Please process Payment from Credit or Debit Card");
		}else if(choice == cashOnDelivery) {
			System.out.println(">> Please pay Cash on Delivery");
		}else {
			System.out.println(">> Please Select Payment Method First !!");
		}*/
		
		switch(choice) {
			case netBanking:
				System.out.println(">> Please process Payment from Net Banking");
				break;
				
			case 2:
				System.out.println(">> Please process Payment from PayTm");
				break;
				
			case 3:
				System.out.println(">> Please process Payment from Amazon Pay");
				break;
				
			case 4:
				System.out.println(">> Please process Payment from Credit or Debit Card");
				break;
				
			case 5:
				System.out.println(">> Please pay Cash on Delivery");
				break;
				
			default:
				System.out.println(">> Please Select Payment Method First !!");
				break;
		}
		
		
	}

}
