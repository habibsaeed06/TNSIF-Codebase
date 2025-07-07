package com.tnsif.dayeight.interfacedemo;

public class Customer {
	
	private String name;
	private String city;
	public String getName() {
		return name;
	}
	
	
	//getter and setter
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

	// para constructor
	public Customer(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}

			// default constructor
	public Customer() {
		super();
	}
	
	
	

}
