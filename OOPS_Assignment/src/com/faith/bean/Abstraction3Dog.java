package com.faith.bean;

public class Abstraction3Dog extends Abstraction3Animal{

	@Override
	public String cry() {
		return "Dogs say Bow Wow";
	}

	@Override
	public void fly() {
		System.out.println("Sorry, I cannot fly");
	}
	
	@Override
	public void walk() {
		noOfLegs = 4;
		System.out.println("I walk with "+ noOfLegs+ " legs");
	}

}
