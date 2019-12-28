package com.amazon.datastructures;

import java.util.HashMap;
import java.util.LinkedList;

import com.amazon.model.User;

//PS: https://visualgo.net/en/graphds
//PS: Its a Directed i.e. Directional Graph

class DirectedGraph<T>{
	
	// We can use a HashMap of key value pairs to make our graph dynamic
	// We can now have any number of vertices :)
	// Each Vertex shall be a Key and will maintain its Adjacency List
	HashMap<T, LinkedList<T>> map;
	HashMap<T, Boolean> visitedVertices;
	
	DirectedGraph() {
		map = new HashMap<>();
		visitedVertices = new HashMap<>();
	}
	
	// Creating a Vertex will also add AdjacencyList to it
	private void addVertex(T vertex) {
		// Add Vertex to HashMap as Key and Value is LinkedList i.e. Adjacency List of Vertices
		map.put(vertex, new LinkedList<>());
		
	}
	
	// map is directed
	void addEdge(T v1, T v2) {
		
		if(!map.containsKey(v1)) {
			addVertex(v1);
		}
		
		if(!map.containsKey(v2)) {
			addVertex(v2);
		}
		
		// First of all get the LinkedList on HashMap from key and then add the Adjacent Vertex
		map.get(v1).add(v2);
		
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
		
		return count;
	}
	
	@Override
	public String toString() {
	
		StringBuffer buffer = new StringBuffer();
		buffer.append("DIRECTED GRAPH\n");
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
	
	void DFS(T vertex) {
		
		visitedVertices.put(vertex, true);
		
		// Print the Vertex which you have visited
		System.out.print(vertex+"  ");
		
		// Fetch Adjacency List of the Vertex and thereafter visit those nodes
		// map.get(vertex) -> Get LinkedList of Adjacent Vertices
		for(T vtx : map.get(vertex)) {
			// Check if Vertex is already visited dont re-visit
			if(!visitedVertices.containsKey(vtx)) {
				DFS(vtx); // Recursively keep on visiting all the adjacent vertices
			}
		}
		
	}
	
	void BFS(T vertex) {
		
		visitedVertices.put(vertex, true);
		
		// Create a Queue (Use LinkedList as Queue)
		LinkedList<T> queue = new LinkedList<T>();
		
		// Add the Vertex to be processed in Queue
		queue.add(vertex);
		
		// Iterate in Queue and keep on the vertices
		while(queue.size()!=0) {
			
			vertex = queue.poll();
			System.out.print(vertex+"  ");
			
			// Fetch Adjacency List of the Vertex and thereafter add those nodes in queue 
			// Make a check if they are visited before or not
			for(T vtx : map.get(vertex)) {
				// Check if Vertex is already visited dont re-visit
				if(!visitedVertices.containsKey(vtx)) {
					visitedVertices.put(vtx, true);
					queue.add(vtx);
				}
			}
		}
		
	}
	
	void clearVisitedVertices() {
		if(visitedVertices.size()>0) {
			visitedVertices.clear();
		}
	}
	
}
 

public class DirectedGraphApp {

	public static void main(String[] args) {
		

		DirectedGraph<Integer> graph = new DirectedGraph<Integer>();
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(2, 5);
		
		graph.addEdge(3, 4);
		
		graph.addEdge(7, 6);
		
		System.out.println(graph);
		
		
		graph.clearVisitedVertices();
		System.out.println(">> MST with DFS Approach");
		graph.DFS(0);
		System.out.println();
		System.out.println();
		
		graph.clearVisitedVertices();
		System.out.println(">> MST with BFS Approach");
		graph.BFS(0);
		System.out.println();
		System.out.println();
		
		
		
		User uRef0 = new User("0. Sia", "sia@example.com", "+91 99999 88888");
		User uRef1 = new User("1. Kim", "kim@example.com", "+91 99889 18888");
		User uRef2 = new User("2. Joe", "joe@example.com", "+91 97899 82288");
		User uRef3 = new User("3. Leo", "leo@example.com", "+91 99911 81188");
		User uRef4 = new User("4. Mike", "mike@example.com", "+91 91999 23888");
		User uRef5 = new User("5. Dave", "dave@example.com", "+91 94499 46798");
		User uRef6 = new User("6. Fionna", "fionna@example.com", "+91 93999 12888");
		User uRef7 = new User("7. Jim", "jim@example.com", "+91 93669 44888");
		
		DirectedGraph<User> userGraph = new DirectedGraph<User>();
		userGraph.addEdge(uRef0, uRef1);
		userGraph.addEdge(uRef0, uRef2);
		
		userGraph.addEdge(uRef1, uRef2);
		userGraph.addEdge(uRef1, uRef3);
		
		userGraph.addEdge(uRef2, uRef0);
		userGraph.addEdge(uRef2, uRef3);
		userGraph.addEdge(uRef2, uRef5);
		
		userGraph.addEdge(uRef3, uRef4);
		
		userGraph.addEdge(uRef7, uRef6);

		
		System.out.println(userGraph);

		userGraph.clearVisitedVertices();
		System.out.println(">> MST with DFS Approach");
		userGraph.DFS(uRef0);
		System.out.println();
		System.out.println();
		
		userGraph.clearVisitedVertices();
		System.out.println(">> MST with BFS Approach");
		userGraph.BFS(uRef0);
		System.out.println();
		System.out.println();
				
		
	}

}
