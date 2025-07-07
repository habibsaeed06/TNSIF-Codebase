package com.tnsif.dayseven.overriding;



// parent class
public class Colour {
	Colour s;
	protected Colour getcolour()
	{
		Colour s=new Colour();
		return s;
	}

}


//child class
class Blue extends Colour{
	//@override
	protected Blue getColour()
	{
		Blue s=new Blue();
		return s;
	}
}
