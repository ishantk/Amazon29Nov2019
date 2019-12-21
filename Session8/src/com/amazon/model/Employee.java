package com.amazon.model;

public class Employee {
	
	public Integer eid;
	public String name;
	public Integer salary;
	
	public Employee() {
		
	}
	
	public Employee(Integer eid, String name, Integer salary) {
		this.eid = eid;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", salary=" + salary + "]";
	}

}
