package com.amazon.model;

// Location shall serve the purpose of Vertex
public class Location {
	
	public double latitude;
	public double longitude;
	public String address;
	
	public Location() {
	
	}

	public Location(double latitude, double longitude, String address) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.address = address;
	}

	@Override
	public String toString() {
		//return "[latitude=" + latitude + ", longitude=" + longitude + ", address=" + address + "]";
		return address;
	}

}
