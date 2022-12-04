package com.faith.app;

/*
 * A bank has two kinds of accounts, savings and fixed deposit. The interest rates for these are
4% and 11%respectively. Customer account interest needs to be implemented. Implement a
solution to print the interest on the basis of principle, time, & rate given by the user. Design
an appropriate class and method to implement this.
 */

import java.util.Scanner;

import com.faith.bean.Encapsulation1FixedAccount;
import com.faith.bean.Encapsulation1SavingsAccount;

public class Encapsulation1Customer {

	public static void main(String[] args) {
		
		int accountType = 1;
		double principalAmount = 0.0;
		float years = 0.0f;
		
		try {
			
			System.out.print("1. Savings Account\n2. Fixed Account\nPlease select your account type:");
			
			//getting account type from the user
			Scanner scanner = new Scanner(System.in);
			accountType = Integer.parseInt(scanner.nextLine());
			
			//getting principal amount from the user
			System.out.print("Please enter the Principal amount: ");
			principalAmount = Double.parseDouble(scanner.nextLine());
			
			//getting time from user
			System.out.print("Please enter the time in years: ");
			years = Float.parseFloat(scanner.nextLine());
			
			if(accountType == 1) {
				
				//creating object for SavingsAccoountClass
				Encapsulation1SavingsAccount savings = new Encapsulation1SavingsAccount();
				savings.setPrincipal(principalAmount);
				savings.setYears(years);
				savings.displayDetails();
			}else if (accountType == 2) {
				//creating object for FixedAccoountClass
				Encapsulation1FixedAccount fixedAccount = new Encapsulation1FixedAccount();
				fixedAccount.setPrincipal(principalAmount);
				fixedAccount.setYears(years);
				fixedAccount.displayDetails();
			}else {
				System.out.println("Invalid selection");
			}
			scanner.close();
			
		}catch(Exception e) {
			System.out.println("Invalid entry");
		}
		
	}

}
