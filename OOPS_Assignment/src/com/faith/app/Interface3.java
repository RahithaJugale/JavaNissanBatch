package com.faith.app;

import java.util.Scanner;

import com.faith.bean.Interface3Imammals;
import com.faith.bean.Interface3MyAnimals;

public class Interface3 {

	public static void main(String[] args) {
		
		try {
			
			//creating object
			Interface3Imammals animals = new Interface3MyAnimals();
			
			//getting input
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter body temperature: ");
			//animals.setBodyTemp(Integer.parseInt(scanner.nextLine()));
			
			System.out.println("Body temperature is " + animals.getBodyTemp(scanner.nextLine()));
			
			scanner.close();
			
		}catch(Exception e) {
			System.out.println("Invalid entry");
		}
		
	}

}
