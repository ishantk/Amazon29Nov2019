
public class AsignmentOperators {

	public static void main(String[] args) {
		
		int num1 = 10;
		//num1 = num1 + 10; // Update Operations
		//num1 += 10;
		num1 %= 3; // num1 = num1 % 3;
		System.out.println(">> num1 is "+num1); // 1
		
		int num2 = 20;
		// POST-FIX
		num2++; // num2 = num2 + 1;
		// PRE-FIX
		++num2; // num2 = num2 + 1;
		num2++;
		--num2;
		num2--;
		num2 += num1;
		System.out.println(">> num2 is: "+num2);
		
		//int num3 = num1++;
		int num3 = ++num1;
		System.out.println(">> num3 is: "+num3+" and num1 is: "+num1);

	}

}
