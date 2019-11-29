
public class RelationalOperators {

	public static void main(String[] args) {
		
		double mobilePhonePrice = 10575.55;
		double amazonProfits = 532.88;
		int salesOnFri = 17500;
		int salesOnSat = 21750;
		
		double profitsOnFri = salesOnFri * amazonProfits;
		double profitsOnSat = salesOnSat * amazonProfits;
		
		System.out.println(">> Is Friday Sales Greater than Saturday: "+ (profitsOnFri > profitsOnSat) );
		System.out.println(">> Is Saturday Sales Greater than Friday: "+ (profitsOnSat > profitsOnFri) );
		
		// <, >=, <= == !=
		
		// Logical Operators
		
		boolean isInternetOn = false;
		boolean isGPSOn = true;
		
		System.out.println(">> Can i navigate on Google Maps: "+ (isInternetOn && isGPSOn) );
		System.out.println(">> Can i navigate on Google Maps: "+ (isInternetOn || isGPSOn) );
				

	}

}
