package com.faith.bean;

public class Inheritance3Grad extends Inheritance3Student{

	@Override
	public boolean isPassed() {
		if(grade > 80.0)
			return true;
		else
			return false;
	}
	
	public void printDetails() {
		System.out.println("-----------Student Details - Graduate class-----------");
		System.out.println("Name: " + name);
		System.out.println("ID: " + id);
		System.out.println("Age: " + age);
		System.out.println("Address: " + address);
		System.out.println("Grade: " + grade);
		System.out.println("Pass/Fail: " + (isPassed() ? "Pass" : "Fail"));
	}
}
