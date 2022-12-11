package com.nissan.app;

/*
 * 1. Define a new implementation for the Vehicle interface. You can use
whatever Vehicle you would like.
2. Reference your new implementation in the vehicle config file.
3. Test your application to verify you are retrieving information from your
new vehicle implementation.
 */

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nissan.service.Vehicle;

public class VehicleApp {

	public static void main(String[] args) {

		try {
			char exitChoice = 'n';
			int choice;
			Scanner scanner = new Scanner(System.in);
			Scanner scanner1 = new Scanner(System.in);
			//creating IOC Container
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			
			do {
				System.out.print("1. HONDA\n2. TATA\nPlease select to see available cars.");
				choice = Integer.parseInt(scanner.nextLine());
				
				switch(choice) {
				case 1:
					Vehicle vehicle = context.getBean("honda", Vehicle.class);
					System.out.println("Available " + vehicle.getBrandName() + " Cars:");
					vehicle.getVehicleName();
					break;
				case 2:
					Vehicle vehicle1 = context.getBean("tata", Vehicle.class);
					System.out.println("Available " + vehicle1.getBrandName() + " Cars:");
					vehicle1.getVehicleName();
					break;
				default:
					System.out.println("Invalid selection");
				}
				
				System.out.print("Continue?(Y/N): ");
				exitChoice = scanner1.next().charAt(0);
			}while((exitChoice == 'y')||(exitChoice == 'Y'));
			System.out.println("EXITING...");
		}catch(Exception e) {
			System.out.println("Invalid entry");
		}
		
	}

}
