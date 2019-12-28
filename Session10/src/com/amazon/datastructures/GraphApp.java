package com.amazon.datastructures;

import java.util.LinkedList;

// PS: https://visualgo.net/en/graphds | Graph
// PS: https://visualgo.net/en/dfsbfs  | BFS
// PS: Its an Undirected i.e. Bi-Directional Graph

class Graph{
	
	// Number of Vertices
	int v;

	// Adjacency Matrix
	// int[][] adjMatrix = new int[v][v];

	// Adjacency List
	// Array of LinkedList with size as Vertices
	LinkedList<Integer>[] adjacencyList;
	
	// Implementing DFS we need to remember which nodes were visited
	boolean[] visitedVertices;
	
	Graph(int v) {
		
		this.v = v;
		adjacencyList = new LinkedList[v]; // Array of Adjacency List for every Vertex
		visitedVertices = new boolean[v];  // Array of booleans to remember visited Vertices
		
		// Initialize all the LinkedLists in Array so that we may put up data in it :)
		for(int i=0;i<v;i++) {
			adjacencyList[i] = new LinkedList<Integer>();
			System.out.println(">> adjLists["+i+"] is: "+adjacencyList[i]);
		}
		
	}
	
	// Add an Edge in Undirected Graph
	// Add from v1 to v2 (vertex1 to vertex2)
	void addEdge(int v1, int v2, boolean isDirected) {
		System.out.println("[EDGE] Added in Graph "+v1+"------"+v2);
		adjacencyList[v1].add(v2);
		
		// Since, its undirected we can save time by adding from v2 to v1 as well (vertex2 to vertex1)
		if(!isDirected) {
			adjacencyList[v2].add(v1);
		}
	}

	// Print Adjacency List Representation of Graph
	void printAdjacencyListOfGraph() {
		
		for(int i=0;i<adjacencyList.length;i++) {
			//System.out.println("Adjacency List for Vertex "+i);
			System.out.print(i+" | ");
			
			for(int vertex : adjacencyList[i]) {
				System.out.print(vertex+"  ");
			}
			System.out.println();
		}
	}
	
	void BFS(int v) {
		
		visitedVertices[v] = true;
		
		// Create a Queue (Use LinkedList as Queue)
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		// Add the Vertex to be processed in Queue
		queue.add(v);
		
		// Iterate in Queue and keep on the vertices
		while(queue.size()!=0) {
			
			v = queue.poll();
			System.out.print(v+"  ");
			
			// Fetch Adjacency List of the Vertex and thereafter add those nodes in queue 
			// Make a check if they are visited before or not 
			for(int adjVertex : adjacencyList[v]) {
				if(!visitedVertices[adjVertex]) {
					visitedVertices[adjVertex] = true;
					queue.add(adjVertex);
				}
			}
		}
		
	}
	
	void DFS(int v) {
		
		visitedVertices[v] = true;
		
		// Print the Vertex which you have visited
		System.out.print(v+"  ");
		
		// Fetch Adjacency List of the Vertex and thereafter visit those nodes
		for(int adjVertex : adjacencyList[v]) {
			if(!visitedVertices[adjVertex]) {
				DFS(adjVertex);
			}
		}
	}

	
}

public class GraphApp {

	public static void main(String[] args) {
		
		/*
		int vertices = 7;
		
		Graph graph = new Graph(vertices);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		
		graph.addEdge(2, 4);
		
		graph.addEdge(3, 4);
		
		graph.addEdge(4, 5);
		
		graph.addEdge(5, 6);
		
		System.out.println();
		
		graph.printAdjacencyListOfGraph();
		*/
		
		int vertices = 8;
		Graph graph = new Graph(vertices);
		
		graph.addEdge(0, 1, true);
		graph.addEdge(0, 2, true);
		
		graph.addEdge(1, 2, true);
		graph.addEdge(1, 3, true);
		
		graph.addEdge(2, 3, true);
		graph.addEdge(2, 5, true);
		
		graph.addEdge(3, 4, true);
		
		graph.addEdge(7, 6, true);
		
		graph.printAdjacencyListOfGraph();
		
		System.out.println();
		
		//System.out.println(">> MST with *DFS* Approach");
		//graph.DFS(0);
		
		System.out.println(">> MST with *BFS* Approach");
		graph.BFS(0);
		
	}

}
