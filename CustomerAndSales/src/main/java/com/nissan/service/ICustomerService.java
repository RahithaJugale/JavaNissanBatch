package com.nissan.service;

import java.util.List;

import com.nissan.model.Customer;

public interface ICustomerService {

	//get a list of all customers
	List<Customer> listAllCustomers();
	
	//get a particular customer by customer number
	Customer getCustomerByCustomerNumber(Integer _customerNo);
	
	//add new customer
	Customer addNewCustomer(Customer customer);
	
	//update an existing customer
	Customer updateCustomer(Customer customer);
	
}
