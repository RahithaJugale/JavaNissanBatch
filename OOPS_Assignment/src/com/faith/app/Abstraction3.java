package com.faith.app;

/*
 * Create a hierarchy classes for Animal, cat, dog, goat, crow and chicken. The attribute of the
class is noOfLegs, color etc. Define abstract methods cry(),fly() and walk() and redefine in the
respective derived classes. Implement the concept of abstract classes in this problem. Need
to use the following methods [Make abstract Class]&[Abstract Methods] cry() [Will return
the string like Meow in case of cat] fly() [Inside specify the height that can reach] walk()
[println(walking with no of legs)]
 */

import java.util.Scanner;

import com.faith.bean.Abstraction3Cat;
import com.faith.bean.Abstraction3Chicken;
import com.faith.bean.Abstraction3Crow;
import com.faith.bean.Abstraction3Dog;
import com.faith.bean.Abstraction3Goat;

public class Abstraction3 {

	public static void main(String[] args) {
		
		int choice = 0;
		try {
			System.out.print("1. Cat\n2. Dog\n3. Goat\n4. Crow\n5. Chicken\nSelect whose characteristics you want to view: ");
			
			//getting input
			Scanner scanner = new Scanner(System.in);
			choice = Integer.parseInt(scanner.nextLine());
			displayCharacteristics(choice);
			
		}catch(Exception e) {
			System.out.println("Invalid entry");
		}
	}
	
	private static void displayCharacteristics(int choice) {
		
		switch(choice) {
		
		case 1:
			//creating object for cat
			Abstraction3Cat cat = new Abstraction3Cat();
			System.out.println(cat.cry());
			cat.fly();
			cat.walk();
			break;
		case 2:
			//creating object for Dog
			Abstraction3Dog dog = new Abstraction3Dog();
			System.out.println(dog.cry());
			dog.fly();
			dog.walk();
			break;
		case 3:
			//creating object for Goat
			Abstraction3Goat goat = new Abstraction3Goat();
			System.out.println(goat.cry());
			goat.fly();
			goat.walk();
			break;
		case 4:
			//creating object for crow
			Abstraction3Crow crow = new Abstraction3Crow();
			System.out.println(crow.cry());
			crow.fly();
			crow.walk();
			break;
		case 5:
			//creating object for Chicken
			Abstraction3Chicken chicken = new Abstraction3Chicken();
			System.out.println(chicken.cry());
			chicken.fly();
			chicken.walk();
			break;
			
		default: 
			System.out.println("Invalid selection");
		}
	}

}
