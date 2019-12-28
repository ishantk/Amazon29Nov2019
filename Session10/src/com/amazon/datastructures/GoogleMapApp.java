package com.amazon.datastructures;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.amazon.model.Location;
import com.amazon.model.Path;

class GoogleMap<T>{
	
	// We can use a HashMap of key value pairs to make our graph dynamic
	// We can now have any number of vertices :)
	// Each Vertex shall be a Key and will maintain its Adjacency List
	HashMap<T, LinkedList<T>> map;
	List paths;
	
	GoogleMap() {
		map = new HashMap<>();
		paths = new LinkedList();
	}
	
	// Creating a Vertex will also add AdjacencyList to it
	private void addLocation(T location) {
		// Add Vertex to HashMap as Key and Value is LinkedList i.e. Adjacency List of Vertices
		map.put(location, new LinkedList<T>());
		
	}
	
	// map is directed
	// Add up Vertex and Edge
	void addPath(Path<T> path, boolean isDirectional) {
		
		paths.add(path);
		
		if(!map.containsKey(path.location1)) {
			addLocation(path.location1);
		}
		
		if(!map.containsKey(path.location2)) {
			addLocation(path.location2);
		}
		
		// First of all get the LinkedList on HashMap from key and then add the Adjacent Vertex
		map.get(path.location1).add(path.location2);
		
		if(!isDirectional)
			map.get(path.location2).add(path.location1);
		
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
	int locations() {
		return map.size(); 
	}

	// Return Number of Edges
	int paths() {
		
		int count=0;
		
		for(T key : map.keySet()) {
			count += map.get(key).size();
		}
		
		return count;
	}
	
	@Override
	public String toString() {
	
		StringBuffer buffer = new StringBuffer();
		buffer.append("Google Map [DIRECTED WEIGHTED GRAPH]\n");
		buffer.append("Locations [Vertices] : "+locations()+"\nPaths [Edges] : "+paths()+"\n\n");
		
		for(T key : map.keySet()) {
			
			buffer.append("Adjacent Locations for: "+key+"\n");
			
			for(T element : map.get(key)) {
				buffer.append(element+"\n");
			}
			
			buffer.append("\n");
		}
		
		return buffer.toString();
		
	}
	
	void sortPaths() {
		paths.sort(new Comparator<T>() {
			@Override
			public int compare(T o1, T o2) {
				Path p1 = (Path)o1;
				Path p2 = (Path)o2;
				
				if(p1.distance>p2.distance)			return 1;
				else if(p1.distance<p2.distance) 	return -1;
				else								return 0;
			}
		});
	}

	// PS : https://visualgo.net/en/mst
	// Apply Kruskal's Algorithm to get MST
	GoogleMap<Location> kruskals() {
		
		GoogleMap<Location> mst = new GoogleMap<Location>();
		
		sortPaths();
		
		for(Object path : paths) {
			System.out.println(path);
			
			//mst.addPath((Path)path, false);
			// What should'nt be added ??
			
		}
		
		return mst;
		
	}
	
	// PS : https://visualgo.net/en/mst
	// Apply Prim's Algorithm to get MST
	GoogleMap<Location> prims() {
		
		GoogleMap<Location> mst = new GoogleMap<Location>();
		
		sortPaths();
		
		for(Object path : paths) {
			System.out.println(path);
	
			
		}
		
		return mst;
		
	}
	
	
}

public class GoogleMapApp {

	public static void main(String[] args) {
	
		// Vertices for Graph
		Location lRef0 = new Location(75.234, 74.113, "[0] Redwood Shores");
		Location lRef1 = new Location(85.134, 33.333, "[1] Country Homes");
		Location lRef2 = new Location(15.214, 23.213, "[2] Pristine Magnum");
		Location lRef3 = new Location(35.324, 39.543, "[3] New Era Heights");
		Location lRef4 = new Location(51.143, 71.166, "[4] Eastern Shores");
		
		// Edges for Graph 
		Path<Location> path0 = new Path<Location>(lRef0, lRef1, 9);
		Path<Location> path1 = new Path<Location>(lRef0, lRef2, 75);
		
		Path<Location> path2 = new Path<Location>(lRef1, lRef2, 95);
		Path<Location> path3 = new Path<Location>(lRef1, lRef3, 19);
		Path<Location> path4 = new Path<Location>(lRef1, lRef4, 42);
		
		Path<Location> path5 = new Path<Location>(lRef2, lRef3, 51);
		
		Path<Location> path6 = new Path<Location>(lRef3, lRef4, 31);
	
		
		// Create Graph
		GoogleMap<Location> map = new GoogleMap<Location>();
		
		// Add Edges to Graph
		map.addPath(path0, false);
		map.addPath(path1, false);
		map.addPath(path2, false);
		map.addPath(path3, false);
		map.addPath(path4, false);
		map.addPath(path5, false);
		map.addPath(path6, false);
		
		System.out.println(map);
		
		//map.sortPaths();
		
		//for(Object path : map.paths) {
		//	System.out.println(path);
		//}
		
		map.kruskals();

	}

}
