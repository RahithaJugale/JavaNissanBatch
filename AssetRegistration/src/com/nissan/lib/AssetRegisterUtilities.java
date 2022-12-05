package com.nissan.lib;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//computer name - string 30
//brand - string 20
//manufacture date - date
//isAvailable - boolean
//quantity - int

public class AssetRegisterUtilities {

	public static Scanner scanner = new Scanner(System.in);
	public static Scanner scanner1 = new Scanner(System.in);
	public static int i = 0;

	public static void getUserInput() {

		// declaring variables for storing
		String[] computerNames = new String[5];
		String[] brands = new String[5];
		Date[] manufactureDates = new Date[5];
		boolean[] isAvailable = new boolean[5];
		int[] quantity = new int[5];

		char choice = 'n';

		try {

			do {

				// getting computer name
				System.out.print("Please enter the name of the computer: ");
				String compName = getValidComputerName(scanner.nextLine());
				computerNames[i] = compName;

				// getting brand name
				System.out.print("Please enter the brand name: ");
				String brandName = getValidBrandName(scanner.nextLine());
				brands[i] = brandName;

				// getting manufacture date
				System.out.print("Please enter Manufacturing Date (dd/mm/yyyy): ");
				// String manufactureDate = scanner.nextLine();
				manufactureDates[i] = formatDate(scanner.nextLine());

				// getting availability of the computer
				System.out.print("Is the model available?(Y/N): ");
				isAvailable[i] = ismodelAvailable(scanner1.next().charAt(0));

				// getting quantity
				if (isAvailable[i]) {
					System.out.print("Please enter the quantity available: ");
					quantity[i++] = validateQuantity(scanner.nextLine());
				} else {
					quantity[i++] = 0;
				}

				System.out.print("Do you want to continue?(Y/N): ");
				choice = scanner1.next().charAt(0);

			} while ((choice == 'y') || (choice == 'Y'));

			// printing details
			System.out.print("Press X to print asset details:");
			char printKey = scanner1.next().charAt(0);
			if ((printKey == 'x') || (printKey == 'X'))
				displayDetails(computerNames, brands, manufactureDates, isAvailable, quantity);
			else {
				System.out.println("Invalid input. Thank you. Exiting...");
				System.exit(0);
			}

		} catch (Exception e) {
			System.out.println("Invalid entry");
		}

	}

	// method to validate computer name
	private static String getValidComputerName(String name) {

		try {
			// declaring pattern
			Pattern compPattern = Pattern.compile("[^A-za-z0-9 ]");

			do {

				// declaring matcher
				Matcher compMatcher = compPattern.matcher(name);
				boolean finder = compMatcher.find();

				// validation starts here
				if (finder) {
					System.out.print("Name of the computer cannot contain special characters. Please re-enter");
					name = scanner.nextLine();
				} else if (name.length() < 5) {
					System.out.print("Name of the computer should have atleast 5 characters. Please re-enter: ");
					name = scanner.nextLine();
				} else if (name.length() > 30) {
					System.out.print("Name of the computer should have more than 30 characters. Please re-enter: ");
					name = scanner.nextLine();
				} else {
					break;
				}

			} while (true);
		} catch (Exception e) {
			System.out.println("Invalid entry");
		}

		return name;

	}

	// method to validate computer name
	private static String getValidBrandName(String brand) {

		try {
			// declaring pattern
			Pattern brandPattern = Pattern.compile("[^A-za-z ]");

			do {

				// declaring matcher
				Matcher brandMatcher = brandPattern.matcher(brand);
				boolean finder = brandMatcher.find();

				// validation starts here
				if (finder) {
					System.out.print("Brand name can contain only alphabets. Please re-enter");
					brand = scanner.nextLine();
				} else if (brand.length() < 2) {
					System.out.print("Name of the computer should have atleast 2 characters. Please re-enter: ");
					brand = scanner.nextLine();
				} else if (brand.length() > 20) {
					System.out.print("Name of the computer should have more than 20 characters. Please re-enter: ");
					brand = scanner.nextLine();
				} else {
					break;
				}

			} while (true);
		} catch (Exception e) {
			System.out.println("Invalid entry");
		}

		return brand;

	}

	private static Date formatDate(String inputDate) throws ParseException {

		try {
			Pattern datePattern = Pattern.compile("[^0-9/]");

			do {

				Matcher dateMatcher = datePattern.matcher(inputDate);
				boolean finder = dateMatcher.find();

				if (finder) {
					System.out.print("Please enter a valid date in the format dd/mm/yyyy: ");
					inputDate = scanner.nextLine();
				} else if (inputDate.length() <= 0) {
					System.out.print("Field cannot be empty. Please re-enter date: ");
					inputDate = scanner.nextLine();
				} else {
					break;
				}
			} while (true);
		} catch (Exception e) {
			System.out.println("Invalid entry");
		}

		// parsing
		Date utilDate = new SimpleDateFormat("dd/MM/yyyy").parse(inputDate);

		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		return sqlDate;
	}

	private static boolean ismodelAvailable(char choice) {
		int flag = 0;
		try {
			do {
				if ((choice == 'y') || (choice == 'Y') || (choice == 'n') || (choice == 'N')) {
					if ((choice == 'y') || (choice == 'Y')) {
						flag = 1;
						break;
					} else {
						flag = 0;
						break;
					}
				} else {
					System.out.print("Please enter either yes or no. Please re-enter: ");
					choice = scanner1.next().charAt(0);
				}

			} while (true);
		} catch (Exception e) {
			System.out.println("Invalid entry");
		}
		if (flag == 1)
			return true;
		else
			return false;
	}

	private static int validateQuantity(String quantity) {

		try {
			Pattern quantityPattern = Pattern.compile("[^0-9]");

			do {

				Matcher quantityMatcher = quantityPattern.matcher(quantity);
				boolean finder = quantityMatcher.find();

				if (finder) {
					System.out.print("Quantity can contain only numbers. Please re-enter: ");
					quantity = scanner.nextLine();
				} else if (Integer.parseInt(quantity) < 0) {
					System.out.print("Quantity should be greater than 0. Please re-enter: ");
					quantity = scanner.nextLine();
				} else {
					break;
				}
			} while (true);
		} catch (Exception e) {
			System.out.println("Invalid entry");
		}
		return Integer.parseInt(quantity);
	}

	private static void displayDetails(String[] computerName, String[] brand, Date[] manufactureDate,
			boolean[] isAvailable, int[] quantity) {

		System.out.println();
		System.out.println(String.format("%-30s%20s%20s%15s%10s", "Computer Name", "Brand Name", "Manufacture Date",
				"isAvailable", "Quantity"));
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------");
		for (int j = 0; j < i; j++) {
			System.out.println(String.format("%-30s%20s%20s%15s%10s", computerName[j], brand[j], manufactureDate[j],
					isAvailable[j], quantity[j]));

		}
	}

}
