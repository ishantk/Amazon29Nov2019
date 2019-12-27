package com.amazon.java8features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Stream API processes Java Objects in a Collection
// map filter reduce etc are some of the key capabilities

public class StreamAPI {
	
	/*void add(int n1, int n2) {
		
	}
	
	void add(int n1, int n2, int n3) {
		
	}*/
	
	/*void add(int[] arr) {
		
	}*/
	
	// Variable Arguments in Java
	void add(int... numbers) {
		
	}

	public static void main(String[] args) {
		
		StreamAPI sRef = new StreamAPI();
		sRef.add(10, 20, 30, 40, 50, 60, 70, 80, 90, 100);
		sRef.add(10, 20, 30, 40);
		/*
		List list = ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		*/
		
		// 1. Stream API : map | Map the resultant data as per our inputs
		
						// VarArgs -> Avriable Arguments as Input
		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5); 
	
		System.out.println(">> List1 is: "+list1);
		//System.out.println(">> list size: "+list.size());
		
		List<Integer> list2 = (List<Integer>) list1.stream().map(x-> x*x).collect(Collectors.toList()); 
		
//		Stream<Integer> stream = list1.stream();
//		stream = stream.map(x-> x*x);
//		stream.collect(Collectors.toList());
		
		System.out.println(">> List2 is: "+list2);
		
		System.out.println(">> FOR EACH with STREAM");
		
		// Stream Implementation with for each loop
		list1.stream().map(x-> x*x).forEach(y->System.out.println(y));
		
		System.out.println();
		
		
		// 1. Stream API : filter | filter will result into filtered data as per our inputs

//		List<String> names = Arrays.asList("Kia", "Anna", "Dave", "Harry", "Kim", "Kristine");
//		System.out.println(">> names: "+names);
//		List<String> filteredNames = names.stream().filter(s->s.startsWith("K")).collect(Collectors.toList()); 
//		System.out.println(">> filteredNames: "+filteredNames);
		
		List<String> texts = Arrays.asList("Hello", "This is hi from Kia", "Hello Again", "hi", "Bye", "Nice to See Yous");
		System.out.println(">> texts: "+texts);
		List<String> filterHellos = texts.stream().filter(s->s.contains("hi")).collect(Collectors.toList()); 
		System.out.println(">> filterHellos: "+filterHellos);
		
		List<String> sortedTexts = texts.stream().sorted().collect(Collectors.toList()); 
		System.out.println(">> sortedTexts: "+sortedTexts);
		
		// collect method -> return back the result collected by corresponding method on stream api
		
		// reduce : Explore :)
		
		
		
		
		
		
	}

}
