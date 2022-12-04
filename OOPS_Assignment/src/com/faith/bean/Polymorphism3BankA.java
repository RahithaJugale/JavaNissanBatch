package com.faith.bean;

public class Polymorphism3BankA {
	
	public double principal;
	public float years;
	private float interestRate = 10;

	// getters and setters
	public double getPrincipal() {
		return principal;
	}

	public void setPrincipal(double principal) {
		this.principal = principal;
	}

	public float getYears() {
		return years;
	}

	public void setYears(float years) {
		this.years = years;
	}

	public float getInterestRate() {
		return interestRate;
	}

	public double calculateInterest() {
		return (principal * years * interestRate) / 100;
	}

	public void displayDetails() {
		System.out.println("Principal Amount: " + principal);
		System.out.println("No. of years: " + years);
		System.out.println("Rate of interest in Bank A per year: " + interestRate + "%");
		System.out.println("Total interest in Bank A for Rs." + principal + " for a period of " + years
				+ " years is Rs. " + calculateInterest());
	}

}
