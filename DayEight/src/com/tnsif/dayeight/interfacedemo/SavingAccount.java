package com.tnsif.dayeight.interfacedemo;

public class SavingAccount extends Customer implements Bank{
	
	
	private int accNo;
	private float balance;
	
	
	// para constructor
	public SavingAccount(String name, String city, int accNo, float balance) {
		super(name, city);
		this.accNo = accNo;
		this.balance = balance;
	}
	
	// getter and setter

	public int getAccNo() {
		return accNo;
	}



	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}



	public float getBalance() {
		return balance;
	}



	public void setBalance(float balance) {
		this.balance = balance;
	}



	@Override
	public void deposit(float amount) {
		// TODO Auto-generated method stub
		if(amount<0 || amount > Deposit_Limit)
		{
			System.out.println("Please deposit valid amount");
		}
		else
		{
			balance+= amount;
			System.out.println("amount is deposited succesfully :"+ amount);
		}
		
	}

	@Override
	public void withdraw(float amount) {
		// TODO Auto-generated method stub
		if(amount <+balance-MINBAL)
		{
			balance-=amount;
			System.out.println("RS : "+ amount + "Withdrawal successfully");
		}
		else
		{
			System.out.println("Insufficent Balance");
		}
	}

	@Override
	public String toString() {
		return "SavingAccount [accNo=" + accNo + ", balance=" + balance + ", getName()=" + getName() + ", getCity()="
				+ getCity() + "]";
	}
	

}
