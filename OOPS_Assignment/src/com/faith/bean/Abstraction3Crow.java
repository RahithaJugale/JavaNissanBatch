package com.faith.bean;

public class Abstraction3Crow extends Abstraction3Animal {
	

	@Override
	public String cry() {
		return "Crows say caw caw";
	}

	@Override
	public void fly() {
		System.out.println("I can fly upto 26,500 ft");
	}

	@Override
	public void walk() {
		noOfLegs = 2;
		System.out.println("I walk with "+ noOfLegs+ " legs");
	}

}
