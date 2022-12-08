package com.nissan.model;

public class Customer {
	
	//instance variables
	private long accountNumber;
	private String customerName;
	private String accountType;
	private double balance;
	private double minimumBalance = 1000.0;
	private long phoneNumber;
	private String email;
	private int pin;
	private String panNumber;
	
	//default constructor
	public Customer() {
		super();
	}	
	
	//parameterized constructor
	public Customer(String customerName, String accountType, double balance, String panNumber, long phoneNumber, String email) {
		super();
		this.customerName = customerName;
		this.accountType = accountType;
		this.balance = balance;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.panNumber = panNumber;
	}

	//getters and setters
	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getMinimumBalance() {
		return minimumBalance;
	}

	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}

	public String getPanNumber() {
		return panNumber;
	}
	
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	
	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "Customer [accountNumber=" + accountNumber + ", customerName=" + customerName + ", accountType="
				+ accountType + ", balance=" + balance + ", minimumBalance=" + minimumBalance + ", phoneNumber="
				+ phoneNumber + ", email=" + email + ", pin=" + pin + "]";
	}

}
