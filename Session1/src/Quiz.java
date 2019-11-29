
public class Quiz {

	public static void main(String[] args) {
		
		/*
		  On Fri : Mobile Phone		10575.55		17.5k 		532.88
		  On Sat : Mobile Phone		10575.55		21.75k 
		 */
		
		double mobilePhonePrice = 10575.55;
		double amazonProfits = 532.88;
		int salesOnFri = 17500;
		int salesOnSat = 21750;
		
		double totalProfitsOnFriAndSat = (salesOnFri + salesOnSat) * amazonProfits;
		System.out.println(">> TOTAL PROFITS: \u20b9"+totalProfitsOnFriAndSat);

	}

}
