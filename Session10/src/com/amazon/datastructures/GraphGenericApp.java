package com.amazon.datastructures;

import java.util.HashMap;
import java.util.LinkedList;

import com.amazon.model.User;

// PS: https://visualgo.net/en/graphds
// PS: Its an Undirected i.e. Bi-Directional Graph

class GenericGraph<T>{
	
	// We can use a HashMap of key value pairs to make our graph dynamic
	// We can now have any number of vertices :)
	// Each Vertex shall be a Key and will maintain its Adjacency List
	HashMap<T, LinkedList<T>> map;
	
	GenericGraph() {
		map = new HashMap<>();
	}
	
	// Creating a Vertex will also add AdjacencyList to it
	private void addVertex(T vertex) {
		// Add Vertex to HashMap as Key and Value is LinkedList i.e. Adjacency List of Vertices
		map.put(vertex, new LinkedList<>());
		
	}
	
	// map is undirected
	void addEdge(T v1, T v2) {
		
		if(!map.containsKey(v1)) {
			addVertex(v1);
		}
		
		if(!map.containsKey(v2)) {
			addVertex(v2);
		}
		
		// First of all get the LinkedList on HashMap from key and then add the Adjacent Vertex
		map.get(v1).add(v2);
		// Considering map to be bi-directional i.e. undirected :)
		map.get(v2).add(v1);
	}
	
	void printAdjacencyListOfGraph() {
		
		for(T key : map.keySet()) {
			System.out.print(key+" | ");
			for(T element : map.get(key)) {
				System.out.print(element+"  ");
			}
			System.out.println();
		}
		
	}
	
	// Return Number of Vertices
	int vertices() {
		return map.size(); 
	}

	// Return Number of Edges
	int edges() {
		
		int count=0;
		
		for(T key : map.keySet()) {
			count += map.get(key).size();
		}
		
		// As Graph is bi-directional
		count /= 2;
		
		return count;
	}
	
	@Override
	public String toString() {
	
		StringBuffer buffer = new StringBuffer();
		buffer.append("UNDIRECTED GRAPH\n");
		buffer.append("Vertices: "+vertices()+"\nEdges: "+edges()+"\n\n");
		
		for(T key : map.keySet()) {
			
			buffer.append(key+" | ");
			
			for(T element : map.get(key)) {
				buffer.append(element+"  ");
			}
			
			buffer.append("\n");
		}
		
		return buffer.toString();
		
	}
	
}

public class GraphGenericApp {

	public static void main(String[] args) {
		
		GenericGraph<Integer> graph = new GenericGraph<Integer>();
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		graph.addEdge(5, 6);
				
		//System.out.println(">> Number of Vertices: "+graph.vertices());
		//System.out.println(">> Number of Edges: "+graph.edges());
		
		//graph.printAdjacencyListOfGraph();
		
		System.out.println(graph);
		
		System.out.println();
		System.out.println();
		
		
		User uRef0 = new User("0. Sia", "sia@example.com", "+91 99999 88888");
		User uRef1 = new User("1. Kim", "kim@example.com", "+91 99889 18888");
		User uRef2 = new User("2. Joe", "joe@example.com", "+91 97899 82288");
		User uRef3 = new User("3. Leo", "leo@example.com", "+91 99911 81188");
		User uRef4 = new User("4. Mike", "mike@example.com", "+91 91999 23888");
		User uRef5 = new User("5. Dave", "dave@example.com", "+91 94499 46798");
		User uRef6 = new User("6. Fionna", "fionna@example.com", "+91 93999 12888");
		
		GenericGraph<User> userGraph = new GenericGraph<User>();
		userGraph.addEdge(uRef0, uRef1);
		userGraph.addEdge(uRef0, uRef2);
		userGraph.addEdge(uRef1, uRef2);
		userGraph.addEdge(uRef1, uRef3);
		userGraph.addEdge(uRef2, uRef4);
		userGraph.addEdge(uRef3, uRef4);
		userGraph.addEdge(uRef4, uRef5);
		userGraph.addEdge(uRef5, uRef6);
		
		System.out.println(userGraph);
		
	}

}
