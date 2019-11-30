
public class ArrayReadWriteUpdate {

	public static void main(String[] args) {
		
		int[] array = new int[5];
		
		// Read Single Element
		System.out.println(">> array[3] is: "+array[3]);
		
		// Read All
		// Basic For loop
		System.out.println(">> BASIC FOR LOOP");
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+"  ");
		}
		
		System.out.println();
		
		int[] numbers = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100}; 
		int  sum = 0;
		// Enhanced For loop
		System.out.println(">> ENHANCED FOR LOOP");
		for(int element : numbers) {
			System.out.print(element+"  ");
			sum += element;
		}
		
		System.out.println();
		
		System.out.println(">> Sum is: "+sum);
		
		// Write/Update
		numbers[3] = 333;
		numbers[5] = 555;
		
		System.out.println();
		
		for(int element : numbers) {
			System.out.print(element+"  ");
			sum += element;
		}
		
		// GARBAGE COLLECTOR IN JAVA
		// It will delete the data from Heap Area !!
		// GC is like a watchman. Will keep on coming and checking again and again what is not useful n the heap
		// Algo : Mark and Sweep
		
		System.gc(); // Execution of Garbage Collector as in when needed

	}

}
