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
	
	Graph(int v) {
		
		this.v = v;
		adjacencyList = new LinkedList[v];
		
		// Initialize all the LinkedLists in Array so that we may put up data in it :)
		for(int i=0;i<v;i++) {
			adjacencyList[i] = new LinkedList<Integer>();
			System.out.println(">> adjLists["+i+"] is: "+adjacencyList[i]);
		}
		
	}
	
	// Add an Edge in Undirected Graph
	// Add from v1 to v2 (vertex1 to vertex2)
	// Since, its undirected we can save time by adding from v2 to v1 as well (vertex2 to vertex1)
	void addEdge(int v1, int v2) {
		System.out.println("[EDGE] Added in Graph "+v1+"------"+v2);
		adjacencyList[v1].add(v2);
		adjacencyList[v2].add(v1);
	}

	// Print Adjacency List Representation of Graph
	void printAdjacencyListOfGraph() {
		
		for(int i=0;i<adjacencyList.length;i++) {
			//System.out.println("Adjacency List for Vertex "+i);
			System.out.println("-----------------");
			System.out.print(i+" | ");
			
			for(int vertex : adjacencyList[i]) {
				System.out.print(vertex+"  ");
			}
			System.out.println();
			System.out.println("----------------");
			System.out.println();
		}
	}
	
	void bfs(int v) {
		
	}

	
}

public class GraphApp {

	public static void main(String[] args) {
		
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
		
		graph.bfs(0);
		
	}

}
