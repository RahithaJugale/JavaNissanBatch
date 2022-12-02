package com.nissan.app;

import com.nissan.lib.Question1Utilities;

/*
 * a. Write a program that collects information of employees in an organization. 
 * When the user gives the input make sure that employee’s age should be between 18 and 60. 
 * If otherwise, throw exception
 */

public class Question1 {

	public static void main(String[] args) {
		
		Question1Utilities employee = new Question1Utilities();
		
		String employeeName = employee.getEmployeeName();
		int employeeAge = employee.getEmployeeAge();
		
		System.out.println("\n-----Employee Details------");
		System.out.println("Name: " + employeeName);
		System.out.println("Age: " + employeeAge);
	}

}
