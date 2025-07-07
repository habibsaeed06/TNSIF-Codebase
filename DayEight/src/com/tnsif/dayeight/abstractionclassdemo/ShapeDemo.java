package com.tnsif.dayeight.abstractionclassdemo;

public abstract class ShapeDemo {
	
	public static void main(String[] args) {
		
		Shape  s;
		s=new Square();
		s.calArea();
		s.show();
		
		
		s=new Rectangular();
		s.calArea();
		s.show();
		
		s=new Square(25.89f);
		s.calArea();
		s.show();
		
		s=new Rectangular(2.1f, 33.2f);
		s.calArea();
		s.show();
		
	}

}
