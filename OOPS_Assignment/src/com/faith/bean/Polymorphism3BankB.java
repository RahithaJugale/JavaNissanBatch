package com.faith.bean;

public class Polymorphism3BankB extends Polymorphism3BankA{

	private float interestRate = 9;
	
	public float getInterestRate() {
		return interestRate;
	}
	
	public void displayDetails() {
		System.out.println("Principal Amount: " + principal);
		System.out.println("No. of years: " + years);
		System.out.println("Rate of interest in Bank B per year: " + interestRate + "%");
		System.out.println("Total interest in Bank B for Rs." + principal + " for a period of " + years
				+ " years is Rs. " + calculateInterest());
	}
}
