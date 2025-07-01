package com.tnsif.daytwo.jumpdemo;

public class SwitchDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int userinput=5;
		
		switch(userinput)
		{
		case 1: System.out.println("Current recharge details");
		break;
		
		case 2: System.out.println("Current recharge expiry date");
		break;
		
		case 3: System.out.println("New offers");
		break;
		
		case 4: System.out.println("Talk to our customer support person");
		break;
		
		default : 
			System.out.println(userinput + " Its not an valid input given by you");
		}
		

	}

}
