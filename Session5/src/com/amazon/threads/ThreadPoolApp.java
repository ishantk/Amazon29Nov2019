package com.amazon.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Ticket{
	
	static int ticketCount = 0;
	
	String pnr;
	String fname;
	String lname;
	int seatNumber;
	boolean checkedIn;
	
	public Ticket() {
		
	}

	public Ticket(String pnr, String fname, String lname, int seatNumber) {
		this.pnr = pnr;
		this.fname = fname;
		this.lname = lname;
		this.seatNumber = seatNumber;
	}

	@Override
	public String toString() {
		return "Ticket [pnr=" + pnr + ", fname=" + fname + ", lname=" + lname + ", seatNumber=" + seatNumber + ", checkedIn=" + checkedIn + "]";
	}
	
}

/*
class CheckInTask implements Runnable{
	
	Ticket ticket;
	
	CheckInTask(Ticket ticket){
		this.ticket = ticket;
	}
	
	@Override
	public void run() {
		// Background Task goes in here | And returns no result
		ticket.checkedIn = true;
		ticket.seatNumber = ++Ticket.ticketCount;
		System.out.println(">> "+ticket.fname+" allocated with seat number "+ticket.seatNumber);
	}
	
}*/

class CheckInTask implements Callable<String>{
	
	Ticket ticket;
	
	CheckInTask(Ticket ticket){
		this.ticket = ticket;
	}

	@Override
	public String call() throws Exception {
		// Background Task goes in here  | And returns result and that too of your expected type
		ticket.checkedIn = true;
		ticket.seatNumber = ++Ticket.ticketCount;
		System.out.println(">> "+ticket.fname+" Checked In Status: "+ticket.checkedIn);
		return ">> "+ticket.fname+" allocated with seat number "+ticket.seatNumber;
	}
	
}


public class ThreadPoolApp {

	public static void main(String[] args) {
		
		System.out.println(">> App Started");
		
		System.out.println(">> Processors: "+Runtime.getRuntime().availableProcessors());
		
		Ticket t1 = new Ticket("ABQF1", "Harry", "Watson", 0);
		Ticket t2 = new Ticket("QBQTT", "Kim", "Watson", 0);
		Ticket t3 = new Ticket("PBQF2", "Sia", "Flynn", 0);
		Ticket t4 = new Ticket("1XCF4", "Mike", "Watson", 0);
		Ticket t5 = new Ticket("GBQF9", "Leo", "Watson", 0);
		
		System.out.println(">> t1 is: "+t1);
		System.out.println(">> t2 is: "+t2);
		System.out.println(">> t3 is: "+t3);
		System.out.println(">> t4 is: "+t4);
		System.out.println(">> t5 is: "+t5);
		
		/*Runnable r = new CheckInTask(t1);
		Thread th = new Thread(r);
		th.start();*/
		
		/*
		new Thread(new CheckInTask(t1)).start();
		new Thread(new CheckInTask(t2)).start();
		new Thread(new CheckInTask(t3)).start();
		new Thread(new CheckInTask(t4)).start();
		new Thread(new CheckInTask(t5)).start();*/
		
		/*
		Runnable task1 = new CheckInTask(t1);
		Runnable task2 = new CheckInTask(t2);
		Runnable task3 = new CheckInTask(t3);
		Runnable task4 = new CheckInTask(t4);
		Runnable task5 = new CheckInTask(t5);
		
		// Challenege : We have occupied our CPU with all the cores
		// Solution   : We can create a Pool of 2 threads
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.execute(task1);
		service.execute(task2);
		service.execute(task3);
		service.execute(task4);
		service.execute(task5);
		
		service.shutdown();
		*/
		
		Callable task1 = new CheckInTask(t1);
		Callable task2 = new CheckInTask(t2);
		Callable task3 = new CheckInTask(t3);
		Callable task4 = new CheckInTask(t4);
		Callable task5 = new CheckInTask(t5);
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		Future<String> future1 = service.submit(task1);
		Future<String> future2 = service.submit(task2);
		Future<String> future3 = service.submit(task3);
		Future<String> future4 = service.submit(task4);
		Future<String> future5 = service.submit(task5);
		
		try {
			System.out.println(future1.get()); // blocking instruction
			System.out.println(future2.get());
			System.out.println(future3.get());
			System.out.println(future4.get());
			System.out.println(future5.get());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		service.shutdown();
		
		System.out.println(">> App Finshed");

	}

}

// Write a Code Snippet exhibiting deadlocks !!
