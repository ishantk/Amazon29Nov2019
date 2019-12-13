package com.amazon.misc;

class CA{
	CA(){
		this(10);
		System.out.println(">> CA1");
	}
	
	CA(int x){
		//this();
		System.out.println(">> CA2: "+x);
	}
}

class CB extends CA{
	CB(){
		//super(10);
		System.out.println(">> CB1");
	}
}

class CC extends CB{
	CC(){
		// super();
		System.out.println(">> CC1");
	}
}

public class ThisSuperQuiz {

	public static void main(String[] args) {
		
		CC cRef = new CC(); //  

	}

}
// PS: this is ref to current object and super is reference to parent object
//     this() is execution of constructor in the same object
//     super() is execution of constructor in the parent object
