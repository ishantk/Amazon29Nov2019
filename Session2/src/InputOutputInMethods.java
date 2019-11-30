import java.util.Scanner;

public class InputOutputInMethods {

	void calculateDiscount(double amount) { // amount is Input of type double
		// amount is property of calculateDiscount method
		
		double discount = 0.0;

		// Ladder if/else
		if(amount>=500) {
			discount = 0.5;
		}else if(amount>=300 && amount < 500) {
			discount = 0.3;
		}else {
			discount = 0.1;
		}
		
		double discountedPrice = amount - (discount * amount);
		System.out.println(">> Please Pay: \u20b9"+discountedPrice);
		System.out.println(">> You Saved \u20b9"+ (amount - discountedPrice));
		System.out.println();
	}
	
	// Ack is specified as double
	// Method should acknowledege in the end
	double calculateDiscountAgain(double amount) { // amount is Input of type double
		// amount is property of calculateDiscount method
		
		double discount = 0.0;

		// Ladder if/else
		if(amount>=500) {
			discount = 0.5;
		}else if(amount>=300 && amount < 500) {
			discount = 0.3;
		}else {
			discount = 0.1;
		}
		
		double discountedPrice = amount - (discount * amount);
		
		return discountedPrice; // return statement will come whenever we have put an ack in method
	}
	
	// For Promo Code 1 : Give Discount of 10% but amount value must be between 100 to 199
	// For Promo Code 2 : Give Discount of 20% but amount value must be between 200 to 499
	// For Promo Code 3 : Give Discount of 50% but amount value must be between 500 and above
	
	// Suggest the user if he has applied a wrong promo code on wrong amount with correct promo code
	
	
	// Without Suggestion
	/*
	double applyPromoCode(double amount, int promoCode) {
		
		double priceToPay = 0.0;
		double discount = 0.0;
		
		if( (amount>=100 && amount<200) && promoCode == 1) {
			discount = 0.1;
		}else if ( (amount>=200 && amount<500) && promoCode == 2) {
			discount = 0.2;
		}else if(amount>=500 && promoCode == 3){
			discount = 0.3;
		}else {
			discount = 0;
			System.out.println(">> SORRY NO DISCOUNTS");
		}
		
		priceToPay = amount - (discount*amount);
		
		return priceToPay;
		
	}*/
	
	// With Suggestion
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
	
	public static void main(String[] args) {
		
		
		InputOutputInMethods iRef = new InputOutputInMethods();
		
		/*iRef.calculateDiscount(1000);
		iRef.calculateDiscount(700);
		iRef.calculateDiscount(1200);
		
		
		double discounts = iRef.calculateDiscountAgain(5000);
		System.out.println(">> You have got Discount of: "+discounts);*/
		
		Scanner scanner = new Scanner(System.in);
		System.out.println(">> Enter Amount : ");
		double amount = scanner.nextDouble();
		
		System.out.println(">> Enter Promo Code : ");
		int promoCode = scanner.nextInt();
		
		double priceToPay = iRef.applyPromoCode(amount, promoCode);
		System.out.println(">> Please Pay: \u20b9"+priceToPay);

	}

}
