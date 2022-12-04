package com.faith.bean;

public class Encapsulation1SavingsAccount {
	
	private double principal;
	private float years; 
	private float interestRate = 4;
	
	//getters and setters
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
		System.out.println("Principal Amount: "+ principal);
		System.out.println("No. of years: "+ years);
		System.out.println("Rate of interest per year: "+ interestRate +"%");
		System.out.println("Total interest for Rs." + principal + " for a period of " + years + " years is Rs. " + calculateInterest());
	}

}
