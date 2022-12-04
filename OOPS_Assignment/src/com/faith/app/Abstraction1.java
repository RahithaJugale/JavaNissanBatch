package com.faith.app;

/*
 * Create a class MyAnimals, which implements the abstract class Animals . The class
MyAnimals should include a property called BodyTemp, which is of type int. Create
appropriate get/set assessors for the property. Also ensure the property would be called
when the GetBodyTemp method returns a value.
 */

import java.util.Scanner;

import com.faith.bean.Abstraction1MyAnimals;

public class Abstraction1 {

	public static void main(String[] args) {
		
		int bodyTemp = 0;
		
		try {
			
			Scanner scanner = new Scanner(System.in);
			System.out.print("Please enter the body temperature: ");
			bodyTemp = Integer.parseInt(scanner.nextLine());
			
			
			//creating object for MyAnimals Class
			Abstraction1MyAnimals myAnimals = new Abstraction1MyAnimals();
			
			myAnimals.setBodyTemp(bodyTemp);
			
			System.out.println("Body Temperature is " + myAnimals.getBodyTemp());
			
		}catch(Exception e) {
			System.out.println("Invalid entry");
		}
	}

}
