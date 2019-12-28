package com.amazon.model;

// User Model

public class User {
	
	String name;
	String email;
	String phone;
	
	public User() {
		name = "NA";
		email = "NA";
		phone = "NA";
	}

	public User(String name, String email, String phone) {
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	@Override
	public String toString() {
		//return "User [name=" + name + ", email=" + email + ", phone=" + phone + "]";
		return "User [ name=" + name + "]";
	}

}
