
public class BitwiseOperators {

	public static void main(String[] args) {
		
		int num1 = 8;			// 	0 0 0 0 1 0 0 0
		int num2 = 12;      	//  0 0 0 0 1 1 0 0
		int num3 = num1 & num2;	//	0 0 0 0 1 0 0 0 
		int num4 = num1 | num2;	//	0 0 0 0 1 1 0 0
		int num5 = num1 ^ num2;	//	0 0 0 0 0 1 0 0
		
		System.out.println(">> num3 is: "+num3);	// 8
		System.out.println(">> num4 is: "+num4);    // 12
		System.out.println(">> num5 is: "+num5);    // 12
		
		// Shift Operators
		int num6 = num1 >> 2;	// _ _ 0 0 0 0 1 0  -> // 0 0 0 0 0 0 1 0
		System.out.println(">> num6 is: "+num6);
		
		int num7 = num1 << 3;
		System.out.println(">> num7 is: "+num7); // 0 1 0 0 0 0 0 0
		
		int num8 = -11 >> 2;
		// 11 : 1 0 1 1
		//      0 1 0 0
		//			  1
		//		0 1 0 1 >> 2
		//      _ _ 0 1
		//      1 1 0 1
		//      0 0 1 0
		//			  1
		//      0 0 1 1 -> -3
		System.out.println(">> num8 is: "+num8);
		 // >>> only on positive numbers
		
		int johnsAge = 10;
		int jacksAge = 20;
		
		// Ternary Operator | Short Hand if/else
		int greaterAge = (johnsAge>jacksAge) ? johnsAge : jacksAge;
		System.out.println(">> Greater Age is: "+greaterAge);

	}

}
