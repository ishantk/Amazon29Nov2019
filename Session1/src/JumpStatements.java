
public class JumpStatements {

	public static void main(String[] args) {
		
		int myFloor = 7;
		
		for(int floor=1; floor<=10; floor++) {
			
			System.out.println(">> Floor #"+floor+" Arrived");
			
			if(floor == myFloor) {
				System.out.println("** Your Floor Arrived **");
				break; // Terminate the Loop
			}
			
		}
		
		System.out.println();
		
		int[] products = {1205, 3452, 1191, 7654, 1212, 6785};
		
		int findProductWithPrice = 1191;
		
		for(int idx=0;idx<products.length;idx++) {
			
			System.out.println(">> Searching for next product at "+idx);
			
			if(products[idx] == findProductWithPrice) {
				System.out.println("** Product Found**");
				break;
			}
		}
		
		System.out.println();

		for(int i=1;i<=10;i++) {
			
			if(i<5) {
				continue;
			}
			
			System.out.println(">> i is: "+i);
		}
		
		// PS: break shall break the loop
		//     continue shall skip the statements and move the loop into next iteration
		
	}

}
