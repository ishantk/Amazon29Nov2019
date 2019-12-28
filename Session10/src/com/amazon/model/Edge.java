package com.amazon.model;

public class Edge<T> {
	
	public T vertex1;
	public T vertex2;
	public int weight;
	
	public Edge() {
		vertex1 = null;
		vertex1 = null;
		weight = 0;
	}
	
	
	public Edge(T vertex1, T vertex2, int weight) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return vertex1.toString() +"----("+weight+")--->"+vertex2.toString();
	}

}
