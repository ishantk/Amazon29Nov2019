
public class ArraySyntaxes {

	public static void main(String[] args) {
		
		// IMPLICIT WAY
		// Syntax #1
		int[] a1 = {10, 20, 30, 40, 50};
		// a1 is a Reference Variable
		// a1 in Stack holds HashCode of Array in Heap
		System.out.println(">> a1 is: "+a1+" and length is: "+a1.length);

		// Syntax #2
		int a2[] = {10, 20, 30, 40, 50};
		System.out.println(">> a2 is: "+a2+" and length is: "+a2.length);
		
		// EXPLICIT WAY
		// Syntax #3
		int[] a3 = new int[]{10, 20, 30, 40, 50};
		// new is a keyword / an operator which creates Array dynamically i.e. in the Heap at run time

		// Syntax #4
		int a4[] = new int[]{10, 20, 30, 40, 50};
		
		// Syntax #5
		int[] a5 = new int[5]; // Mentioning the Size instead of data
		// a5 is a ref variable which gets created in stack and holds the HashCode of Array in Heap
		// Array in Heap will have 5 elements and all of them will be ZERO
		
		for(int i=0;i<a5.length;i++) {
			System.out.print(a5[i]+"  ");
		}
		
		// int[] a6 = new int[3] {10, 20, 30}; // ERROR
		
		//int a7[] = new int[5];
		
		int a7[], a8;
		a7 = new int[5]; // Array
		a8 = 10; // Regular Primitive
		
		int[] a9, a10;
		a9 = new int[5];
		a10 = new int[5];
	}

}
