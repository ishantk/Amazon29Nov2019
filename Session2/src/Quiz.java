
public class Quiz {

	void calculateDiscount() {
		double amount = 1000;
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
	}
	
	static void sCalculateDiscount() {
		double amount = 1000;
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
	}
	
	
	public static void main(String[] args) {
		
		//Quiz qRef = new Quiz();
		//qRef.calculateDiscount();
		
		Quiz.sCalculateDiscount();
		

	}

}
