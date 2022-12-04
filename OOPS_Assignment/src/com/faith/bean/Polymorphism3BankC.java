package com.faith.bean;

public class Polymorphism3BankC extends Polymorphism3BankA{

private float interestRate = 7;
	
	public float getInterestRate() {
		return interestRate;
	}
	
	public void displayDetails() {
		System.out.println("Principal Amount: " + principal);
		System.out.println("No. of years: " + years);
		System.out.println("Rate of interest in Bank C per year: " + interestRate + "%");
		System.out.println("Total interest in Bank C for Rs." + principal + " for a period of " + years
				+ " years is Rs. " + calculateInterest());
	}
}
