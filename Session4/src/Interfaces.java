interface AmazonPayCallbacks{
	void onSuccess();
	void onFailure();
}

interface GooglePayCallbacks{
	void onPaymentSuccess();
	void onFailure();
}

// Multiple Inheritance -> Supported by Interfaces
// Interface to Interface Inheritance | Not Class to Class or Object to Object
interface CallBacks extends AmazonPayCallbacks, GooglePayCallbacks{
	void notifyForPayment();
}

//Multiple Implementation and NOT Multiple Inheritance
class ZomatoPayments implements CallBacks{ //AmazonPayCallbacks, GooglePayCallbacks{
	
	public void onSuccess() {
		System.out.println(">> Payment Success");
	}
	
	public void onPaymentSuccess() {
		System.out.println(">> Payment Success");
	}
	
	public void onFailure(){
		System.out.println(">> Payment Failed");
	}
	
	public void notifyForPayment() {
		System.out.println(">> Send a Notification in Email/SMS/Push");
	}
}


public class Interfaces {

	public static void main(String[] args) {
		
		/*
		AmazonPayCallbacks aCB = new ZomatoPayments();
		aCB.onSuccess();
		aCB.onFailure();
		//aCB.onPaymentSuccess(); // error
		
		System.out.println();
		
		GooglePayCallbacks gCB = new ZomatoPayments();
		gCB.onPaymentSuccess();
		gCB.onFailure();
		
		//gCB.onSuccess(); // error
		*/
		
		CallBacks cb = new ZomatoPayments();
		cb.onSuccess();
		cb.onPaymentSuccess();
		cb.onFailure();
		

	}

}

// PS: Three Different Ways to Inherit
//     1. Object to Object
//     2. Class to Class
//	   3. Interface to Interface

// class CA extends CB implements Inf{}
// class CA extends CB implements Inf1, Inf2{}