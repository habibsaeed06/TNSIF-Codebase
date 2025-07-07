package com.tnsif.dayeight.abstractionclassdemo;

public class Square extends Shape {
	
	
	float side;
	

	public Square() {
		this.side=2.0f;
	}
	
	

	public Square(float side) {
		super();
		this.side = side;
	}

	@Override
	public String toString() {
		return "Square [side=" + side + "]";
	}


	@Override
	public void calArea() {
		// TODO Auto-generated method stub
		this.area=side*side;
	}

}
