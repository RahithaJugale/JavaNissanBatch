package com.nissan.lib;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 1. Display menu to user
 * 2. Withdrawal process - subtract balance
 * 3. Deposit - add balance
 */

public class Customer {

	// instance variables
	private long[] accountNumbers = new long[5];
	private String[] customerNames = new String[5];
	private String[] panNumbers = new String[5];
	private double[] balance = new double[5];

	private int i = 0;
	private int index = -1;

	private static Scanner scanner = new Scanner(System.in);
	private static Scanner scanner1 = new Scanner(System.in);

	public void mainMenu() {

		char userChoice = 'n';
		try {
			do {
				System.out.print("1. New User\n2. Existing user\nPlease select the appropriate option: ");

				switch (Integer.parseInt(scanner.nextLine())) {

				case 1:
					newUser();
					break;
				case 2:
					displayMenuAndProcess();
					break;
				default:
					System.out.println("Incorrect selection");
				}

				System.out.print("Do you want to continue(Y/N): ");
				userChoice = scanner1.next().charAt(0);
			} while ((userChoice == 'y') || (userChoice == 'Y'));
			System.out.println("Thank You! Exiting...");
		} catch (Exception e) {
			System.out.println("Invalid entry");
		}
	}

	private void newUser() {
		try {
			System.out.println("-----NEW USER------");

			// getting customer name
			System.out.print("Please enter your name: ");
			customerNames[i] = getValidName(scanner.nextLine());

			// getting account number
			System.out.print("Please enter your account number: ");

			do {
				int flag = 0;
				long tempAccNum = getValidAccount(scanner.nextLine());

				// checking if the account number already exists
				for (long accountNumber : accountNumbers) {
					if (tempAccNum == accountNumber) {
						System.out.print("Account number already exists. Please re-enter:");
						flag = 1;
						break;
					}
				}
				if (flag == 0) {
					accountNumbers[i] = tempAccNum;
					break;
				}
			} while (true);

			// get PAN number
			System.out.print("Please enter your PAN number: ");

			do {
				int flag = 0;
				String tempPan;
				tempPan = getValidPan(scanner.nextLine());

				// checking if the account number already exists
				for (String panNumber : panNumbers) {
					if (tempPan == panNumber) {
						flag = 1;
						System.out.print("Please enter your unique PAN number:");
						break;
					}
				}
				if (flag == 0) {
					panNumbers[i] = tempPan;
					break;
				}
			} while (true);

			// getting balance
			System.out.print("Please enter your balance: ");
			balance[i++] = getValidBalance(scanner.nextLine());

		} catch (Exception e) {
			System.out.println("Invalid entry");
		}
	}

	// displaying menu and other processes
	private void displayMenuAndProcess() {
		index = -1;
		char choice = 'y';
		try {
			int flag = 0;
			System.out.println("-------EXISTING USER-------");
			// getting customer account number
			System.out.print("Enter your account number: ");
			long accNo = getValidAccount(scanner.nextLine());

			for (long accountNumber : accountNumbers) {
				index++;
				if (accountNumber == accNo) {
					flag = 1;
					break;
				}
			}

			if (flag == 0) {
				System.out.println("Account number does not exist. Terminating the session. Thank You");
				System.exit(0);
			}

			do {
				// displaying menu to the user
				System.out.print(
						"\n1. Withdraw\n2. Deposit\n3. View Balance\n4. Transfer Amount\n5. View your details\n6. Exit\nPlease select any one of the above options:");

				// passing user input into another method for processing
				processMenu(Integer.parseInt(scanner.nextLine()));

				System.out.print("Do you wish to continue(Y/N): ");
				choice = scanner1.next().charAt(0);

			} while ((choice == 'y') || (choice == 'Y'));

			// when user enters anything other than Yes-> exit
			System.out.println("Thank You, " + customerNames[index] + "! Exiting...");

		} catch (Exception e) {
			System.out.println("Invalid entry");
		}

	}

	private void processMenu(int choice) {
		try {

			switch (choice) {

			case 1:
				withdrawAmount();
				break;
			case 2:
				depositAmount();
				break;
			case 3:
				viewBalance();
				break;
			case 4:
				transferAmount();
				break;
			case 5:
				viewCustomerDetails();
				break;
			case 6:
				System.exit(0);
			default:
				System.out.println("Invalid option");
			}

		} catch (Exception e) {
			System.out.println("Invalid entry");
		}
	}

	private void withdrawAmount() {
		String panNum;
		try {

			// getting withdrawal amount
			System.out.print("Please enter the amount you wish to withdraw:");
			double withdrawalAmount = getValidAmount(scanner.nextLine());
			
			if(balance[index]-1000 < withdrawalAmount) {
				System.out.println("Insufficient funds...!");
			}else if(withdrawalAmount > 50000){
				System.out.print("Withdrawal amount is greater than 50000. Please enter PAN Number: ");
				panNum = getValidPan(scanner.nextLine());
				if(panNum.equals(panNumbers[index])) {
					balance[index] -= withdrawalAmount;					
					System.out.println("Amount withdrawal successful. Balance updated.");
				}else {
					System.out.println("Invalid PAN Number");
				}
			}else {
				balance[index] -= withdrawalAmount;
				System.out.println("Amount withdrawal successful. Balance updated.");
			}

		} catch (Exception e) {
			System.out.println("Invalid entry");
		}
	}

	private void depositAmount() {
		String panNum;
		try {
			
			//getting deposit amount from user
			System.out.print("Please enter the amount you wish to deposit:");
			double depositAmount = getValidAmount(scanner.nextLine());
			
			if(depositAmount > 50000){
				System.out.print("Deposit amount is greater than 50000. Please enter PAN Number: ");
				panNum = getValidPan(scanner.nextLine());
				if(panNum.equals(panNumbers[index])) {
					balance[index] += depositAmount;					
					System.out.println("Amount deposited successfully. Balance updated.");
				}else {
					System.out.println("Invalid PAN Number");
				}
			}else {
				balance[index] += depositAmount;
				System.out.println("Amount deposited successfully. Balance updated.");
			}
			
		}catch(Exception e) {
			System.out.println("Invalid entry");
		}
	}

	private void viewBalance() {
		System.out.println("Current Balance: Rs." + balance[index]);
	}

	private void transferAmount() {
		String panNum;
		long transferAccount;
		int transferIndex = -1;
		int flag = 0;
		double transferAmount;
		try {
			
			//getting account number to where amount is to be transferred
			System.out.print("Please enter the account number to which you want to transfer amount: ");
			
			//checking if account number exists
			do {
				transferAccount = getValidAccount(scanner.nextLine());
				for (long accountNumber : accountNumbers) {
					transferIndex++;
					if (transferAccount == accountNumber) {
						flag = 1;
						break;
					}
				}
				if (flag == 0) {
					System.out.print("Account Number does not exists. Please re-enter: ");
				}else {
					break;
				}
			}while(true);
			
			System.out.print("Enter amount to be transfered: ");
			transferAmount = getValidAmount(scanner.nextLine());
			
			if(balance[index]-1000 < transferAmount) {
				System.out.println("Insufficient funds...!");
			}else if(transferAmount > 50000){
				System.out.print("Transfer amount is greater than 50000. Please enter PAN Number: ");
				panNum = getValidPan(scanner.nextLine());
				if(panNum.equals(panNumbers[index])) {
					balance[index] -= transferAmount;
					balance[transferIndex] += transferAmount;
					System.out.println("Amount transfer successful. Balance updated.");
				}else {
					System.out.println("Invalid PAN Number");
				}
			}else {
				balance[index] -= transferAmount;
				balance[transferIndex] += transferAmount;
				System.out.println("Amount transfer successful. Balance updated.");
			}
			
		}catch(Exception e) {
			System.out.println("Invalid entry");
		}
	}

	private void viewCustomerDetails() {
		System.out.println("---------------------------------------------------");
		System.out.println("Details for Account number "+ accountNumbers[index]);
		System.out.println("---------------------------------------------------");
		System.out.println("Account Holder: "+customerNames[index]);
		System.out.println("PAN Card Number: " + panNumbers[index]);
		System.out.println("Account Balance: " + balance[index]);
		
	}

	private static String getValidName(String name) {
		try {

			// creating pattern using regular expression
			Pattern pattern = Pattern.compile("[^A-Za-z ]");

			do {

				// Match
				Matcher matcher = pattern.matcher(name);
				boolean finder = matcher.find();

				if (finder) {
					System.out.print("Name must contain only alphabets. Please re-enter name: ");
					name = scanner.nextLine();
				} else if (name.length() < 3) {
					System.out.print("Name should contain minimum 3 characters. Please re-enter name: ");
					name = scanner.nextLine();
				} else {
					break;
				}

			} while (true);

		} catch (Exception e) {
			System.out.println("Invalid name");
		}

		return name;
	}

	private static String getValidPan(String pan) {
		try {

			// creating pattern using regular expression
			Pattern panPattern = Pattern.compile("[^A-Za-z0-9]");

			do {

				// Match
				Matcher matcher = panPattern.matcher(pan);
				boolean finder = matcher.find();

				if (finder) {
					System.out.print("PAN number cannot contain special characters. Please re-enter: ");
					pan = scanner.nextLine();
				} else if (pan.length() < 10) {
					System.out.print("PAN number should have 10 digits. Please re-enter: ");
					pan = scanner.nextLine();
				} else {
					break;
				}

			} while (true);

		} catch (Exception e) {
			System.out.println("Invalid entry");
		}

		return pan;
	}

	// validating amount inputs
	private static double getValidAmount(String amount) {

		try {
			Pattern amountPattern = Pattern.compile("[^0-9.]");

			do {

				Matcher amountMatcher = amountPattern.matcher(amount);
				boolean finder = amountMatcher.find();

				if (finder) {
					System.out.print("Amount can contain only positive numbers. Please re-enter: ");
					amount = scanner.nextLine();
				} else if (amount.length() <= 0) {
					System.out.print("Field cannot be blank. Please re-enter: ");
					amount = scanner.nextLine();
				} else {
					break;
				}

			} while (true);
		} catch (Exception e) {
			System.out.println("Invalid entry");
		}
		return Double.parseDouble(amount);
	}

	// validating balance
	private static double getValidBalance(String amount) {

		try {
			Pattern amountPattern = Pattern.compile("[^0-9.]");

			do {

				Matcher amountMatcher = amountPattern.matcher(amount);
				boolean finder = amountMatcher.find();

				if (finder) {
					System.out.print("Amount can contain only positive numbers. Please re-enter: ");
					amount = scanner.nextLine();
				} else if (amount.length() <= 0) {
					System.out.print("Field cannot be blank. Please re-enter: ");
					amount = scanner.nextLine();
				} else if (Double.parseDouble(amount) < 1000) {
					System.out.print("Minimum balance should be 1000. Please re-enter: ");
					amount = scanner.nextLine();
				} else {
					break;
				}

			} while (true);
		} catch (Exception e) {
			System.out.println("Invalid entry");
		}
		return Double.parseDouble(amount);
	}

	// validating customer account number
	private static long getValidAccount(String account) {

		try {
			Pattern accountPattern = Pattern.compile("[^0-9]");

			do {

				Matcher accountMatcher = accountPattern.matcher(account);
				boolean finder = accountMatcher.find();

				if (finder) {
					System.out.print("Account number can contain only numbers. Please re-enter: ");
					account = scanner.nextLine();
				} else if (account.length() <= 0) {
					System.out.print("Field cannot be blank. Please re-enter: ");
					account = scanner.nextLine();
				} else if (account.length() != 10) {
					System.out.print("Account number should have 10 digits. Please re-enter: ");
					account = scanner.nextLine();
				} else {
					break;
				}

			} while (true);
		} catch (Exception e) {
			System.out.println("Invalid entry");
		}
		return Long.parseLong(account);
	}

}
