package com.tnsif.dayeight.interfacedemo;


public class BankDemo {
	public static void main(String[] args) {
		
		SavingAccount s1=new SavingAccount("Saeed", "Pune", 12234, 100000);
		s1.deposit(10000);
		System.out.println(s1);
		
		
		s1.withdraw(10000);
		System.out.println(s1);
	}

}
