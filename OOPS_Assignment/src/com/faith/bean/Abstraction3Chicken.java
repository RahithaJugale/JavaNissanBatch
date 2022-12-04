package com.faith.bean;

public class Abstraction3Chicken extends Abstraction3Animal {
	
	@Override
	public String cry() {
		return "Chickens say cluck cluck";
	}

	@Override
	public void fly() {
		System.out.println("I can fly upto 10 ft");
	}

	@Override
	public void walk() {
		noOfLegs = 2;
		System.out.println("I walk with "+ noOfLegs+ " legs");
	}

}