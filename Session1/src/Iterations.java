
public class Iterations {

	public static void main(String[] args) {
		
		// 1. For Loop
		
		//for(int floor=1; floor<=10; floor++) {
		//	System.out.println(">> You Have Reached Floor# "+floor);
		//}
		
		int floor = 1;
		//for(;floor<=10;floor++) {
		for(;floor<=10;) {
			System.out.println(">> You Have Reached Floor# "+floor);
			floor++;
		}
		
		
		// While Loop
		int num = 5;
		int index = 13;
		
		while(index<=10) {
			System.out.println(">> "+num+" "+index+"'s are "+(num*index));
			index++;
		}
		
		System.out.println("***************");
		System.out.println("> index is: "+index);
		num = 7;
		
		// do - while
		do {
			System.out.println(">> "+num+" "+index+"'s are "+(num*index));
			index++;
		}while(index<=10);

	}

}
