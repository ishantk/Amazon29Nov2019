package com.amazon.datastructures;

import java.util.HashMap;
import java.util.LinkedList;

import com.amazon.model.Edge;

class DirectedWeightedGraph<T, U>{
	
	// We can use a HashMap of key value pairs to make our graph dynamic
	// We can now have any number of vertices :)
	// Each Vertex shall be a Key and will maintain its Adjacency List
	HashMap<T, LinkedList<U>> map;
	
	DirectedWeightedGraph() {
		map = new HashMap<>();
	}
	
	// Creating a Vertex will also add AdjacencyList to it
	private void addVertex(T vertex) {
		// Add Vertex to HashMap as Key and Value is LinkedList i.e. Adjacency List of Vertices
		map.put(vertex, new LinkedList<U>());
		
	}
	
	// map is directed
	void addEdge(Edge<T> edge) {
		
		if(!map.containsKey(edge.vertex1)) {
			addVertex(edge.vertex1);
		}
		
		if(!map.containsKey(edge.vertex2)) {
			addVertex(edge.vertex2);
		}
		
		// First of all get the LinkedList on HashMap from key and then add the Adjacent Vertex
		String adj = "("+edge.vertex2+","+edge.weight+")";
		map.get(edge.vertex1).add((U) adj);
		
	}
	
	void printAdjacencyListOfGraph() {
		
		for(T key : map.keySet()) {
			System.out.print(key+" | ");
			for(U element : map.get(key)) {
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
		buffer.append("DIRECTED WEIGHTED GRAPH\n");
		buffer.append("Vertices: "+vertices()+"\nEdges: "+edges()+"\n\n");
		
		for(T key : map.keySet()) {
			
			buffer.append(key+" | ");
			
			for(U element : map.get(key)) {
				buffer.append(element+"  ");
			}
			
			buffer.append("\n");
		}
		
		return buffer.toString();
		
	}
	
}

public class DirectedWeightedGraphApp {

	public static void main(String[] args) {
		
		DirectedWeightedGraph<Integer, String> graph = new DirectedWeightedGraph<Integer, String>();
		
		//Edge<Integer> edge0 = new Edge<Integer>(0, 1, 99);
		Edge<Integer> edge1 = new Edge<Integer>(0, 2, 50);
		Edge<Integer> edge2 = new Edge<Integer>(1, 2, 50);
		Edge<Integer> edge3 = new Edge<Integer>(1, 3, 50);
		Edge<Integer> edge4 = new Edge<Integer>(1, 4, 50);
		Edge<Integer> edge5 = new Edge<Integer>(2, 3, 99);
		Edge<Integer> edge6 = new Edge<Integer>(3, 4, 75);
		
		graph.addEdge(new Edge<Integer>(0, 1, 99));
		graph.addEdge(edge1);
		graph.addEdge(edge2);
		graph.addEdge(edge3);
		graph.addEdge(edge4);
		graph.addEdge(edge5);
		graph.addEdge(edge6);
		
		System.out.println(graph);
		

	}

}
