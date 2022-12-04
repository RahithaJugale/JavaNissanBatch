package com.faith.app;

/*
 * 3. Create a superclass, Student, and two subclasses, Undergrad and Grad.
The superclass Student should have the following data members: name, ID, grade, age, and address.
The superclass, Student should have at least one method: boolean isPassed (double grade)
The purpose of the isPassed method is to take one parameter, grade (value between 0 and 100) and
check whether the grade has passed the requirement for passing a course. In the Student class this
method should be empty as an abstract method.
• The two subclasses, Grad and Undergrad, will inherit all data members of the Student class and
override the method isPassed. For the UnderGrad class, if the grade is above 70.0, then isPassed
returns true, otherwise it returns false. For the Grad class, if the grade is above 80.0, then isPassed
returns true, otherwise returns false.
• Create a test class for your three classes. In the test class, create one Grad object and one
Undergrad object. For each object, provide a grade and display the results of the isPassed method.
 */

import java.util.Scanner;

import com.faith.bean.Inheritance3Grad;
import com.faith.bean.Inheritance3UnderGrad;

public class Inheritance3Test {

	public static void main(String[] args) {

		int choice;
		try {

			Scanner scanner = new Scanner(System.in);
			System.out.print("1. UnderGraduate\n2. Graduate\nSelect an option: ");
			choice = Integer.parseInt(scanner.nextLine());

			switch (choice) {
			case 1:
				underGradDetails();
				break;
			case 2:
				gradDetails();
				break;
			default:
				System.out.println("Invalid selection");

			}
		} catch (Exception e) {
			System.out.println("Invalid entry");
		}
	}

	private static void underGradDetails() {

		try {
			
			Scanner scanner = new Scanner(System.in);
			// creating object for UnderGrad class
			Inheritance3UnderGrad underGrad = new Inheritance3UnderGrad();

			// getting name, ID, grade, age, address from user
			System.out.print("Please enter name: ");
			underGrad.setName(scanner.nextLine());

			System.out.print("Please enter ID: ");
			underGrad.setId(Integer.parseInt(scanner.nextLine()));

			System.out.print("Please enter age: ");
			underGrad.setAge(Integer.parseInt(scanner.nextLine()));

			System.out.print("Please enter Address: ");
			underGrad.setAddress(scanner.nextLine());

			System.out.print("Please enter Grade: ");
			underGrad.setGrade(Double.parseDouble(scanner.nextLine()));

			underGrad.printDetails();

		} catch (Exception e) {
			System.out.println("Invalid entry");
		}

	}
	
	private static void gradDetails() {

		try {
			
			Scanner scanner = new Scanner(System.in);
			// creating object for Grad class
			Inheritance3Grad grad = new Inheritance3Grad();

			// getting name, ID, grade, age, address from user
			System.out.print("Please enter name: ");
			grad.setName(scanner.nextLine());

			System.out.print("Please enter ID: ");
			grad.setId(Integer.parseInt(scanner.nextLine()));

			System.out.print("Please enter age: ");
			grad.setAge(Integer.parseInt(scanner.nextLine()));

			System.out.print("Please enter Address: ");
			grad.setAddress(scanner.nextLine());

			System.out.print("Please enter Grade: ");
			grad.setGrade(Double.parseDouble(scanner.nextLine()));

			grad.printDetails();

		} catch (Exception e) {
			System.out.println("Invalid entry");
		}

	}


}
