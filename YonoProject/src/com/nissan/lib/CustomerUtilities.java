package com.nissan.lib;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nissan.model.Customer;

public class CustomerUtilities {

	private static List<Customer> customers = new ArrayList<Customer>();
	private static Scanner scanner = new Scanner(System.in);
	private static Scanner scanner1 = new Scanner(System.in);
		
	public static void addCustomers() {
		long accNo;
		int pin;
		String name;
		int accountType;
		String accType;
		double balance;
		long phone;
		String email;
		String pan;
		try {
			char choice = 'n';
			do {
				System.out.println("ADD NEW CUSTOMER");
				
				System.out.print("Please enter your mobile number: ");
				phone = getValidPhone(scanner.nextLine());
				
				if(checkPhoneExists(phone)) {
					System.out.println("An account exists with the same phone number. Please re-try.");
					continue;
				}
				
				System.out.print("Please enter name: ");
				name = getValidName(scanner.nextLine());
				
				do {
					System.out.print("1. Savings Account\n2. Current Account\nPlease choose account type: ");
					accountType = Integer.parseInt(scanner.nextLine());
					if((accountType == 1)||(accountType == 2)) {
						break;
					}else
						System.out.println("Invalid selection. Please try again");
					
				}while(true);
				
				if(accountType == 1)
					accType = "Savings Account";
				else
					accType = "Current Account";
				
				System.out.print("Please enter balance: ");
				balance = getValidBalance(scanner.nextLine());
				
				System.out.print("Please enter your PAN number: ");

				do {
					int flag = 0;
					pan = getValidPan(scanner.nextLine());

					// checking if the pan number already exists
					for (Customer customer : customers) {
						if (pan == customer.getPanNumber()) {
							flag = 1;
							System.out.print("Please enter your unique PAN number:");
							break;
						}
					}
					if (flag == 0) {
						break;
					}
				} while (true);

				
				System.out.print("Please enter your e-mail ID: ");
				email = getValidEmail(scanner.nextLine());
				
				Random random = new Random();
				accNo = random.nextInt(100000000, 999999999);
				pin = random.nextInt(1000, 9999);
				
				Customer customer = new Customer(name, accType, balance, pan, phone, email);
				
				customer.setAccountNumber(accNo);
				customer.setPin(pin);
				customers.add(customer);
				
				
				System.out.println("Customer Added. Please note down the ACCOUNT NUMBER and PIN for future references.");
				System.out.println("Account Number: " + accNo);
				System.out.println("PIN: " + pin);
				
				System.out.print("Do you want to add another customer? (Y/N): ");
				choice = scanner1.next().charAt(0);
								
			}while((choice == 'Y')||(choice == 'y'));
			
		}catch(Exception e) {
			System.out.println("Invalid entry");
		}
	}
	
	private static boolean checkPhoneExists(long phone) {
		if(customers.size() == 0)
			return false;
		else {
			for(Customer customer : customers) {
				if(customer.getPhoneNumber() == phone)
					return true;
			}
		}
		return false;
	}

	private static String getValidName(String name) {
		try {
			// defining pattern
			Pattern namePattern = Pattern.compile("[^A-Za-z ]");

			do {

				// defining matcher
				Matcher nameMatcher = namePattern.matcher(name);
				boolean finder = nameMatcher.find();

				// validating for anything other than alphabets
				if (finder) {
					System.out.print("Name should contain only alphabets. Please re-enter: ");
					name = scanner.nextLine();
				} else if (name.length() < 3) {
					System.out.print("Name should have minimum 3 characters. Please re-enter: ");
					name = scanner.nextLine();
				} else if (name.length() > 30) {
					System.out.print("Name should have only 30 characters. Please re-enter: ");
					name = scanner.nextLine();
				} else
					break;
			} while (true);
		} catch (Exception e) {
			System.out.println("Invalid entry");
		}
		return name;
	}
	
	private static String getValidAmount(String amount) {
		try {
			// defining pattern
			Pattern amountPattern = Pattern.compile("[^0-9.]");

			do {

				// defining matcher
				Matcher amountMatcher = amountPattern.matcher(amount);
				boolean finder = amountMatcher.find();

				// validating for anything other than numbers
				if (finder) {
					System.out.print("Field should contain only numbers. Please re-enter: ");
					amount = scanner.nextLine();
				} else if (amount.length() <= 0) {
					System.out.print("Field should not be blank. Please re-enter: ");
					amount = scanner.nextLine();
				} else
					break;
			} while (true);
		} catch (Exception e) {
			System.out.println("Invalid entry");
		}

		return amount;
	}
	
	private static long getValidPhone(String number) {

		try {
			Pattern numberPattern = Pattern.compile("[^0-9]");

			do {

				Matcher numberMatcher = numberPattern.matcher(number);
				boolean finder = numberMatcher.find();

				if (finder) {
					System.out.print("Phone number can contain only numbers. Please re-enter: ");
					number = scanner.nextLine();
				} else if (number.length() <= 0) {
					System.out.print("Field cannot be blank. Please re-enter: ");
					number = scanner.nextLine();
				} else if (number.length() != 10) {
					System.out.print("Phone number should have 10 digits. Please re-enter: ");
					number = scanner.nextLine();
				} else {
					break;
				}

			} while (true);
		} catch (Exception e) {
			System.out.println("Invalid entry");
		}
		return Long.parseLong(number);
	}
	
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
	
	private static String getValidEmail(String email) {
		
		try {
			
			Pattern emailPattern = Pattern.compile("[^A-Za-z0-9@.]");
			
			do {
				Matcher emailMatcher = emailPattern.matcher(email);
				boolean finder = emailMatcher.find();
				
				if(finder) {
					System.out.print("Please enter a valid e-mail address: ");
					email = scanner.nextLine();
				}else
					break;
			}while(true);
			
		}catch(Exception e) {
			System.out.println("Invalid entry");
		}
		
		return email;
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
	
	//-------------------------------------------------------------------------------------------------
	//update customer details
	
	public static void updateCustomerDetails() {
		long phone;
		int flag = 0;
		long accNumber;
		char choice = 'n';
		Customer updateCustomer = null;
		String email;
		int updateChoice;
		try {
			System.out.println("UPDATE CUSTOMER DETAILS");
			do {
				System.out.print("Please enter your account number: ");
				accNumber = getValidAccount(scanner.nextLine());
				
				for(Customer customer : customers) {
					if(accNumber == customer.getAccountNumber()) {
						updateCustomer = customer;
						break;
					}else {
						flag++;
					}
				}
				if(flag == customers.size()) {
					System.out.println("Account number NOT FOUND. Please try-again");
					continue;
				}
				
				System.out.print("1. Update phone number\n2. Update e-mail ID\nPlease select any option: ");
				updateChoice = Integer.parseInt(scanner.nextLine());
				
				switch(updateChoice) {
				
				case 1: 
					do {
						System.out.print("Please enter new phone number: ");
						phone = getValidPhone(scanner.nextLine());
						
						if(checkPhoneExists(phone)) {
							System.out.println("An account exists with the same phone number. Please re-try.");
							continue;
						}else {
							break;
						}
					}while(true);
					updateCustomer.setPhoneNumber(phone);
					System.out.println("Phone number updated successfully");
					break;
					
				case 2:
					System.out.print("Please enter new email ID: ");
					email = getValidEmail(scanner.nextLine());
					
					updateCustomer.setEmail(email);
					System.out.println("E-mail updated successfully");
					break;
					
				default:
					System.out.println("Invalid selection. Exiting your current session");
				}
				
				System.out.println("Do you want to update another customer's details: ");
				choice = scanner1.next().charAt(0);
				
			}while ((choice == 'Y')||(choice == 'y'));
		}catch(Exception e) {
			System.out.println("Invalid entry");
		}
	}
	
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
				} else if (account.length() != 9) {
					System.out.print("Account number should have 9 digits. Please re-enter: ");
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
	
	//---------------------------------------------------------------------------------------------------------
	//deleting a customer
	public static void deleteCustomer() {
		char choice = 'n';
		long accNumber;
		Customer deleteCustomer = null;
		int flag = 0;
		try {
			System.out.println("DELETE CUSTOMER");
			do {
				System.out.print("Please enter your account number: ");
				accNumber = getValidAccount(scanner.nextLine());
				
				for(Customer customer : customers) {
					if(accNumber == customer.getAccountNumber()) {
						deleteCustomer = customer;
						break;
					}else {
						flag++;
					}
				}
				if(flag == customers.size()) {
					System.out.println("Account number NOT FOUND. Please try-again");
					continue;
				}
				
				customers.remove(deleteCustomer);
				System.out.println("Account deleted");
			}while ((choice == 'Y')||(choice == 'y'));
		}catch(Exception e) {
			System.out.println("Invalid entry");
		}
	}
	
	//------------------------------------------------------------------------------------------------------
	//Account holder operations
	
	public static void displayMenuAndProcess() {
		
		int pin;
		char choice = 'y';
		try {
			int flag = 0;
			Customer existingCustomer = null;
			// getting customer account number
			System.out.print("Please enter your account number to view available options: ");
			long accNo = getValidAccount(scanner.nextLine());

			for (Customer customer : customers) {
				if (customer.getAccountNumber() == accNo) {
					existingCustomer = customer;
					flag = 1;
					break;
				}
			}

			if (flag == 0) {
				System.out.println("Account number does not exist. Terminating your session. Thank You");
			}
			
			//getting ATM PIN
			do {
				System.out.print("Enter PIN: ");
				pin = getValidPin(scanner.nextLine());
				
				if(existingCustomer.getPin() != pin) {
					System.out.println("Incorrect PIN. Please try again: ");
				}else
					break;
			}while(true);

			do {
				// displaying menu to the user
				System.out.print(
						"\n1. Withdraw\n2. Deposit\n3. View Balance\n4. Transfer Amount\n5. View your details\n6. Exit\nPlease select any one of the above options:");

				// passing user input into another method for processing
				processMenu(Integer.parseInt(scanner.nextLine()), existingCustomer);

				System.out.print("Do you wish to see Account Holder Menu again(Y/N): ");
				choice = scanner1.next().charAt(0);

			} while ((choice == 'y') || (choice == 'Y'));

			// when user enters anything other than Yes-> exit
			System.out.println("Thank You, " + existingCustomer.getCustomerName() + "! Exiting...");

		} catch (Exception e) {
			System.out.println("Invalid entry");
		}

	}

	private static void processMenu(int choice, Customer _existingCustomer) {
		try {

			switch (choice) {

			case 1:
				withdrawAmount(_existingCustomer);
				break;
			case 2:
				depositAmount(_existingCustomer);
				break;
			case 3:
				viewBalance(_existingCustomer);
				break;
			case 4:
				transferAmount(_existingCustomer);
				break;
			case 5:
				viewCustomerDetails(_existingCustomer);
				break;
			case 6:
				System.out.println("Thank You, " + _existingCustomer.getCustomerName() + "! Exiting...");
				System.exit(0);
			default:
				System.out.println("Invalid option");
			}

		} catch (Exception e) {
			System.out.println("Invalid entry");
		}
	}

	private static void withdrawAmount(Customer _customer) {
		String panNum;
		try {

			// getting withdrawal amount
			System.out.print("Please enter the amount you wish to withdraw:");
			double withdrawalAmount = Double.parseDouble(getValidAmount(scanner.nextLine()));

			if (_customer.getBalance() - _customer.getMinimumBalance() < withdrawalAmount) {
				System.out.println("Insufficient funds...!");
			} else if (withdrawalAmount > 50000) {
				System.out.print("Withdrawal amount is greater than 50000. Please enter PAN Number: ");
				panNum = getValidPan(scanner.nextLine());
				if (panNum.equals(_customer.getPanNumber())) {
					_customer.setBalance(_customer.getBalance() - withdrawalAmount);
					System.out.println("Amount withdrawal successful. Balance updated.");
				} else {
					System.out.println("Invalid PAN Number");
				}
			} else {
				_customer.setBalance(_customer.getBalance() - withdrawalAmount);
				System.out.println("Amount withdrawal successful. Balance updated.");
			}

		} catch (Exception e) {
			System.out.println("Invalid entry");
		}
	}

	private static void depositAmount(Customer _customer) {
		String panNum;
		try {

			// getting deposit amount from user
			System.out.print("Please enter the amount you wish to deposit:");
			double depositAmount = Double.parseDouble(getValidAmount(scanner.nextLine()));

			if (depositAmount > 50000) {
				System.out.print("Deposit amount is greater than 50000. Please enter PAN Number: ");
				panNum = getValidPan(scanner.nextLine());
				if (panNum.equals(_customer.getPanNumber())) {
					_customer.setBalance(_customer.getBalance() + depositAmount);
					System.out.println("Amount deposited successfully. Balance updated.");
				} else {
					System.out.println("Invalid PAN Number");
				}
			} else {
				_customer.setBalance(_customer.getBalance() + depositAmount);
				System.out.println("Amount deposited successfully. Balance updated.");
			}

		} catch (Exception e) {
			System.out.println("Invalid entry");
		}
	}

	private static void viewBalance(Customer _customer) {
		System.out.println("Your Current Balance: Rs." + _customer.getBalance());
	}

	private static void transferAmount(Customer _existingCustomer) {
		String panNum;
		long transferAccount;
		int flag = 0;
		double transferAmount;
		Customer transferCustomer = null;
		try {

			// getting account number to where amount is to be transferred
			System.out.print("Please enter the account number to which you want to transfer amount: ");

			// checking if account number exists
			do {
				transferAccount = getValidAccount(scanner.nextLine());
				for (Customer customer : customers) {
					if (transferAccount == customer.getAccountNumber()) {
						transferCustomer = customer;
						flag = 1;
						break;
					}
				}
				if (flag == 0) {
					System.out.print("Account Number does not exists. Please re-enter: ");
				} else {
					break;
				}
			} while (true);

			System.out.print("Enter amount to be transfered: ");
			transferAmount = Double.parseDouble(getValidAmount(scanner.nextLine()));

			if (_existingCustomer.getBalance() - _existingCustomer.getMinimumBalance() < transferAmount) {
				System.out.println("Insufficient funds...!");
			} else if (transferAmount > 50000) {
				System.out.print("Transfer amount is greater than 50000. Please enter PAN Number: ");
				panNum = getValidPan(scanner.nextLine());
				if (panNum.equals(_existingCustomer.getPanNumber())) {
					_existingCustomer.setBalance(_existingCustomer.getBalance() - transferAmount);
					transferCustomer.setBalance(transferCustomer.getBalance() + transferAmount);
					System.out.println("Amount transfer successful. Balance updated.");
				} else {
					System.out.println("Invalid PAN Number");
				}
			} else {
				_existingCustomer.setBalance(_existingCustomer.getBalance() - transferAmount);
				transferCustomer.setBalance(transferCustomer.getBalance() + transferAmount);
				System.out.println("Amount transfer successful. Balance updated.");
			}

		} catch (Exception e) {
			System.out.println("Invalid entry");
		}
	}

	private static void viewCustomerDetails(Customer _customer) {
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Details for Account number " + _customer.getAccountNumber());
		System.out.println("-----------------------------------------------------------------");
		System.out.println("|    Account Holder Name   |  " + _customer.getCustomerName());
		System.out.println("|    Account Type          |  " + _customer.getCustomerName());
		System.out.println("|    Account Balance       |  " + _customer.getBalance());
		System.out.println("|    PAN Card Number       |  " + _customer.getPanNumber());
		System.out.println("|    Phone Number          |  " + _customer.getPhoneNumber());
		System.out.println("|    E-mail                |  " + _customer.getEmail());
		System.out.println("|    ATM PIN               |  " + _customer.getPin());
		

	}
	
	private static int getValidPin(String pin) {

		try {
			Pattern pinPattern = Pattern.compile("[^0-9.]");

			do {

				Matcher pinMatcher = pinPattern.matcher(pin);
				boolean finder = pinMatcher.find();

				if (finder) {
					System.out.print("PIN can contain only numbers. Please re-enter: ");
					pin = scanner.nextLine();
				} else if (pin.length() <= 0) {
					System.out.print("Field cannot be blank. Please re-enter: ");
					pin = scanner.nextLine();
				} else if (pin.length() > 4) {
					System.out.print("Please re-enter your FOUR digit PIN number: ");
					pin = scanner.nextLine();
				} else {
					break;
				}

			} while (true);
		} catch (Exception e) {
			System.out.println("Invalid entry");
		}
		return Integer.parseInt(pin);
	}
	
	//--------------------------------------------------------------------------------------------------------
	//display all customers
	
	public static void displayAllCustomers() {
		
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("-----------------------------------------------------------Customers List------------------------------------------------------------------");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(String.format("%-17s%-25s%-20s%-15s%-40s%-20s", "Account number", "Customer Name", "Account Type", "Phone Number", "E-mail", "Pan Number" ));
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
		
		
		for(Customer customer : customers) {
			System.out.println(String.format("%-17s%-25s%-20s%-15s%-40s%-20s", customer.getAccountNumber(), customer.getCustomerName(), customer.getAccountType(), customer.getPhoneNumber(), customer.getEmail(), customer.getPanNumber() ));
		}
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
	}
	//-------------------------------------------------------------------------------------------------------------
	//display details of specific customers
	
	public static void getCustomerDetails() {
		try {
			Customer existingCustomer = null;
			int flag = 0;
			do {
				System.out.print("Please enter account number to view all details: ");
				long accNumber = getValidAccount(scanner.nextLine());
				
				for(Customer customer : customers) {
					if(accNumber == customer.getAccountNumber()) {
						existingCustomer = customer;
						break;
					}else {
						flag++;
					}
				}
				if(flag == customers.size()) {
					System.out.println("Account number NOT FOUND. Please try-again");
					continue;
				}else
					break;
			
			}while(true);
			
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("-----------------------------------------------------------CUSTOMER FOUND------------------------------------------------------------------");
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println(String.format("%-17s%-25s%-20s%-15s%-40s%-20s", "Account number", "Customer Name", "Account Type", "Phone Number", "E-mail", "Pan Number" ));
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println(String.format("%-17s%-25s%-20s%-15s%-40s%-20s", existingCustomer.getAccountNumber(), existingCustomer.getCustomerName(), existingCustomer.getAccountType(), existingCustomer.getPhoneNumber(), existingCustomer.getEmail(), existingCustomer.getPanNumber() ));
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
			
			
		}catch(Exception e) {
			System.out.println("Invalid entry");
		}
	}

}
