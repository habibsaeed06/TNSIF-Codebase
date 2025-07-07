package com.tnsif.dayeight.abstractionclassdemo;

public class Rectangular extends Shape {
	
	float width;
	float height;
	public Rectangular() {
		width=3.2f;
		height=2.0f;
	}
	public Rectangular(float width, float height) {
		super();
		this.width = width;
		this.height = height;
	}
	@Override
	public String toString() {
		return "Rectangular [width=" + width + ", height=" + height + "]";
	}
	@Override
	public void calArea() {
		// TODO Auto-generated method stub
		this.area=width*height;
		
	}
	
	
	
	
	

}
