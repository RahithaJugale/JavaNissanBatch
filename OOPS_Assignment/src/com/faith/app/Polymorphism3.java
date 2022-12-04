package com.faith.app;

/*
 * Write a java program to perform the arithmetic operations using the concept of method
overloading. Get two inputs Integer and the output must be a float. Get two inputs Float and
the output must be an Integer.Write a java program to perform the concept of method
overriding for calculatingsimple interest of 3 banks A,B,C. using dynamic method dispatch
Bank A’s rate of interest-10%, Bank’s B rate of interest-9%, Bank’C rate of interest -7%
 */

import java.util.Scanner;

import com.faith.bean.Polymorphism3ArithmeticOperations;
import com.faith.bean.Polymorphism3BankA;
import com.faith.bean.Polymorphism3BankB;

public class Polymorphism3 {

	public static void main(String[] args) {

		methodOverloading();
		methodOverriding();
	}

	private static void methodOverloading() {

		// declaring variables
		float number1, number2, floatOutput;
		int intOutput;

		try {
			System.out.println("------------Example for method overLoading-------------");

			// creating an object for the ArithmeticOperation class
			Polymorphism3ArithmeticOperations operations = new Polymorphism3ArithmeticOperations();

			// getting user input
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter the first number: ");
			number1 = Float.parseFloat(scanner.nextLine());
			System.out.print("Enter the second number: ");
			number2 = Float.parseFloat(scanner.nextLine());

			// performing float and int addition
			floatOutput = operations.add((int) number1, (int) number2);
			intOutput = operations.add(number1, number2);
			System.out.println("The integer result of addition is " + intOutput);
			System.out.println("The float result of addition is " + floatOutput);
			System.out.println();

			// performing float and int subtraction
			floatOutput = operations.subtract((int) number1, (int) number2);
			intOutput = operations.subtract(number1, number2);
			System.out.println("The integer result of subtraction is " + intOutput);
			System.out.println("The float result of subtraction is " + floatOutput);
			System.out.println();

			// performing float and int multiplication
			floatOutput = operations.multiply((int) number1, (int) number2);
			intOutput = operations.multiply(number1, number2);
			System.out.println("The integer result of multiplication is " + intOutput);
			System.out.println("The float result of multiplication is " + floatOutput);
			System.out.println();

			// performing float and int division
			floatOutput = operations.divide((int) number1, (int) number2);
			intOutput = operations.divide(number1, number2);
			System.out.println("The integer result of division is " + intOutput);
			System.out.println("The float result of division is " + floatOutput);
			System.out.println();

			// performing float and int modulus
			floatOutput = operations.mod((int) number1, (int) number2);
			intOutput = operations.mod(number1, number2);
			System.out.println("The integer result of modulus is " + intOutput);
			System.out.println("The float result of modulus is " + floatOutput);

		} catch (Exception e) {
			System.out.println("Invalid entry");
		}
	}
	
	private static void methodOverriding() {
		
		double principalAmount = 0.0;
		float years = 0.0f;
		
		try {
			
			System.out.println();
			System.out.println("------------Example for method overriding-------------");
			
			Scanner scanner1 = new Scanner(System.in);
			
			//getting principal amount from the user
			System.out.print("Please enter the Principal amount: ");
			principalAmount = Double.parseDouble(scanner1.nextLine());
			
			//getting time from user
			System.out.print("Please enter the time in years: ");
			years = Float.parseFloat(scanner1.nextLine());
			
			//creating object for Bank B
			Polymorphism3BankA bankB = new Polymorphism3BankB();
			bankB.setPrincipal(principalAmount);
			bankB.setYears(years);
			bankB.displayDetails();
			
		}catch(Exception e) {
			System.out.println("Invalid entry");
		}
	}
}
