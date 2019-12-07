interface PaymentsListener{
	
	void onSuccess(String message);
	void onFailure(String message);
	
}

class AmazonPay{
	
	// Attribute : Property of AmazonPay Object
	PaymentsListener pRef; // Has-A | 1 to 1
	
	//void setAmazonPayDetails(PaymentsListener pRef) {
	void initializePaymentsListener(PaymentsListener pRef) {
		this.pRef = pRef;
	}
	
	void pay(int amount) {
		
		System.out.println(">> Transacting Payments from Connected Bank");
		
		try {
			Thread.sleep(2000); // Delay of 2 seconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Considering that transaction went OK from Bank !!
		pRef.onSuccess("[OK] Transaction Successfully Done for \u20b9"+amount);
		//pRef.onFailure("Payments Failed");
	}
	
}


class ZomatoPayment implements PaymentsListener{
	
	public void onSuccess(String message) {
		if(message.startsWith("[OK]")) {
			System.out.println(">> FROM AmazonPay: "+message);
			System.out.println(">> Thank You For Transaction. We will Process Your Order Soon !!");
		}
	}
	
	public void onFailure(String message) {
		System.out.println(">> Please Try again: "+message);
	}
}

public class ZomatoAppPayments {

	public static void main(String[] args) {
		
		// Ref Var of PaymentsListener points to the Object of ZomatoPayment as it implements it !!
		//PaymentsListener listener = new ZomatoPayment(); // Polymorhic Statement
		//System.out.println(">> listener is: "+listener);
		
		/*PaymentsListener pRef = new PaymentsListener() {
			
			public void onSuccess(String message) {
				if(message.startsWith("[OK]")) {
					System.out.println(">> FROM Anaonymous AmazonPay: "+message);
					System.out.println(">> Thank You For Transaction. We will Process Your Order Soon !!");
				}
			}
			
			public void onFailure(String message) {
				System.out.println(">> Please Try again: "+message);
			}
		};*/
		
		AmazonPay aRef = new AmazonPay();
		//aRef.initializePaymentsListener(listener);
		//aRef.initializePaymentsListener(pRef);
		
		aRef.initializePaymentsListener(
				new PaymentsListener() {
					
					public void onSuccess(String message) {
						if(message.startsWith("[OK]")) {
							System.out.println(">> FROM Anaonymous AmazonPay: "+message);
							System.out.println(">> Thank You For Transaction. We will Process Your Order Soon !!");
						}
					}
					
					public void onFailure(String message) {
						System.out.println(">> Please Try again: "+message);
					}
				});
		
		aRef.pay(500);
		
	}

}
