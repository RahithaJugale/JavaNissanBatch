package com.nissan.lib;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Question1Utilities {
	
	public static String getEmployeeName(){
		
		String employeeName="";
		
		try {
			
			Scanner scanner = new Scanner(System.in);
			System.out.print("Please enter your name: ");
			employeeName = getValidName(scanner.nextLine());
			
		} catch (Exception e) {
			System.out.println("Invalid entry");
		}
		
		return employeeName;
	}
	
	private static String getValidName(String name) {
		
		try {
			//creating object for BufferedReader
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			//creating pattern using regular expression
			Pattern pattern = Pattern.compile("[^A-Za-z ]");
			
			do {
				
				//Match
				Matcher matcher = pattern.matcher(name);
				boolean finder = matcher.find();		//find() returns false if the string matches the pattern
				
				if(finder) {
					System.out.print("Name must contain only alphabets. Please re-enter name: ");
					name = br.readLine();
				}
				else if(name.length() < 3) {
					System.out.print("Name should contain minimum 3 characters. Please re-enter name: ");
					name = br.readLine();
				}
				else if(name.length() > 30){
					System.out.print("Name contains more than 30 characters. Please re-enter name: ");
					name = br.readLine();
				}
				else {
					break;
				}
				
			}while(true);
			
		}catch(Exception e) {
			System.out.println("Invalid name");
		}
		
		return name;
	}
	
	public static int getEmployeeAge() {
		
		int age = 0;
		
		try {
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("Please enter your age: ");
			age = getValidAge(scanner.nextLine());
		}catch(Exception e) {
			System.out.println("Invalid entry");
		}
		
		return age;
	}

	private static int getValidAge(String age) {
		int newAge = 0;

		try {
			BufferedReader brAge = new BufferedReader(new InputStreamReader(System.in));
			
			//creating pattern using regular expression
			Pattern patternAge = Pattern.compile("[^0-9]");
			
			do {
				Matcher matcherAge = patternAge.matcher(age);
				boolean ageFinder = matcherAge.find();
				//System.out.println(ageFinder);
				//newAge = Integer.parseInt(age);
				
				if(ageFinder) {
					System.out.print("Age should contain only positive numeric values. Please re-enter age: ");
					age = brAge.readLine();
				}
				else if((Integer.parseInt(age) < 18)||(Integer.parseInt(age) > 60)) {
					System.out.print("Age should be be between 18 and 60. Please re-enter: ");
					age = brAge.readLine();
				}
				else {
					break;
				}
				
			}while(true);
			
			
			
		}catch(Exception e) {
			System.out.println("Invalid age");			
		}
		
		newAge = Integer.parseInt(age);
		
		return newAge;
	}
}
