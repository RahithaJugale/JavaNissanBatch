package com.nissan.app;

import java.util.Scanner;

import com.nissan.lib.CustomerUtilities;

public class YonoApp {

	private static Scanner scanner = new Scanner(System.in);
	private static Scanner scanner1 = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int menuChoice;
		char choice = 'n';
		try {
			System.out.println("YONO APP");
			do {
				System.out.print("MAIN MENU\nPress 1 if you are an ADMIN\nPress 2 if you are a ACCOUNT HOLDER");
				menuChoice = Integer.parseInt(scanner.nextLine());
				
				switch(menuChoice) {
				
				case 1:
					adminMenu();
					break;
				case 2:
					accountHolderMenu();
					break;
				default:
					System.out.println("Invalid selection");
				}
				
				System.out.print("Do you want to see the Main Menu?(Y/N): ");
				choice = scanner1.next().charAt(0);
			}while((choice == 'y')||(choice == 'Y'));
			
			System.out.println("EXITING THE APPLICATION");
			
		}catch(Exception e) {
			System.out.println("Invalid entry");
		}

	}

	private static void adminMenu() {
		char choice = 'n';
		int menuChoice;
		try {
			System.out.println("ADMIN MENU");
			do {
				
				System.out.print("1. Add new Customer\n2. Update Customer Details\n3. Delete Customer\n4. List all Customers\n5. View specific customer details\nPlease select an option: ");
				menuChoice = Integer.parseInt(scanner.nextLine());
				
				switch(menuChoice) {
				
				case 1:
					CustomerUtilities.addCustomers();
					break;
				case 2:
					CustomerUtilities.updateCustomerDetails();
					break;
				case 3:
					CustomerUtilities.deleteCustomer();
					break;
				case 4:
					CustomerUtilities.displayAllCustomers();
					break;
				case 5:
					CustomerUtilities.getCustomerDetails();
					break;
				default:
					System.out.println("Invalid selection");
				}
				
				System.out.print("Do you want to see the Admin Menu?(Y/N): ");
				choice = scanner1.next().charAt(0);
			}while((choice == 'y')||(choice == 'Y'));
		}catch(Exception e) {
			System.out.println("Invalid entry");
		}
	}

	private static void accountHolderMenu() {

			System.out.println("ACCOUNT HOLDER MENU");
			CustomerUtilities.displayMenuAndProcess();
	}

}
