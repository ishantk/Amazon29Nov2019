package com.amazon.atlas.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

/*
class CA{
	
	CA(){
	
	}

	CA(int x){
		
	}
}

class CB extends CA{
	CB(){
		super(10);
	}
}

CB cRef = new CB();
*/

// UNCHECKED Exception -> MyBankingException IS-A RuntimeException
class MyBankingException extends RuntimeException{
	MyBankingException(String message){
		super(message); // Execute Constructor with message as input for Parent Object
	}
}

//CHECKED Exception -> YourBankingException IS-A Exception
class YourBankingException extends Exception{
	YourBankingException(String message){
		super(message); // Execute Constructor with message as input for Parent Object
	}
	
	void lockAccount() {
		System.out.println(">> Account Locked");
	}
}

class BankAccount{
	
	int balance;
	int minBalance;
	int attempts;
	
	public BankAccount() {
		balance = 10000; // In Case user will open up a bank account this is the first deposit
		minBalance = 2000;
	}
	
	void showBalance() {
		System.out.println(">> Balance is: \u20b9"+balance);
	}
	
	//void withdraw(int amount) throws IOException, SomeOtherException1, SomeOtherException2{
	// If we extends from BankAccount another class lets say JointBankAccount
	// And if now you override withdraw method in Child JointBankAccount, your signature must be same in case you are throwing the Exception
	// i.e in JointBankAccount over-rided method withdraw should have throws IOException
	// //  OR should have throws child of IOException
	//void withdraw(int amount) throws IOException{
	void withdraw(int amount) throws YourBankingException{
		balance -= amount; // balance = balance - amount
		
		if(balance<=minBalance) { // Condition to Handle Balance Check
			attempts++;
			balance += amount;
			System.out.println(">> Withdraw Failed. Balance is Low \u20b9"+balance);
		}else {
			System.out.println(">> Withdrawl Success. New Balance is \u20b9"+balance);
		}
		
		if(attempts == 3) {
			// Throwing an UNCHECKED EXCEPTION
			//ArithmeticException aRef = new ArithmeticException(">> No More Attempts Allowed. Illegal Attempts "+attempts+" !!");
			//throw aRef;
			
			// Throwing a CHECKED EXCEPTION
			// We will get error by compiler and use throws keyword in the method's signature to eliminate error
			//IOException iRef = new IOException(">> No More Attempts Allowed. Illegal Attempts "+attempts+" !!");
			//throw iRef;
			
			
			// Throwing an UNCHECKED EXCEPTION - User Defined
			//MyBankingException mRef = new MyBankingException(">> No More Attempts Allowed. Illegal Attempts "+attempts+" !!");
			//throw mRef;
			
			YourBankingException yRef = new YourBankingException(">> No More Attempts Allowed. Illegal Attempts "+attempts+" !!");
			throw yRef;
		}
	}
}

/*
class JointBankAccount extends BankAccount{
	
	void withdraw(int amount) throws FileNotFoundException{
		System.out.println(">> Wow");
		
		FileNotFoundException fRef = new FileNotFoundException(">> No More Attempts Allowed. Illegal Attempts "+attempts+" !!");
		throw fRef;
		
	}
}*/

// PS: Use Case 1 : When we throw an Exception: No Checks and Compiler does not give error		 | UNCHECKED EXCEPTIONS (Runtime Exceptions)
// PS: Use Case 2 : When we throw an Exception: Checks Done By Compiler and it generates errors  | CHECKED EXCEPTIONS

public class Banking {

	public static void main(String[] args) {
		
		System.out.println(">> Banking Started");
		
		BankAccount fionnasAccount = new BankAccount();
		fionnasAccount.showBalance();
		
		// Challenge : Bank's Resources are occupied/wasted !!
		try {
			for(int i=1;i<=500;i++) {
				fionnasAccount.withdraw(3000);
			}
		}catch(YourBankingException yRef) {
			System.out.println(">> Exception is: "+yRef);
			yRef.lockAccount();
		}
		/*catch(Exception eRef) {
			System.out.println(">> Exception is: "+eRef);
			// eRef.lockAccount(); error
		}*/
		/*catch(IOException io) {
			System.out.println(">> Message: "+io);
		}*/
		
		System.out.println(">> Banking Finished");

	}

}
