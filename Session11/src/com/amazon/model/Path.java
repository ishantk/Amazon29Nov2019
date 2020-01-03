package com.amazon.model;

// Path serves the purpose of Edge
public class Path<T>{// implements Comparable<Integer>{
	
	public T location1;
	public T location2;
	public int distance;
	public boolean isJammed;
	
	public Path() {
	
	}

	public Path(T location1, T location2, int distance) {
		this.location1 = location1;
		this.location2 = location2;
		this.distance = distance;
	}

	@Override
	public String toString() {
		//return "Path [location1=" + location1 + ", location2=" + location2 + ", distance=" + distance + ", isJammed="+ isJammed + "]";
		return "Path: "+location1+"-----"+distance+"-----"+location2;
	}

}
