package com.nissan.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.dao.ICustomerDAO;
import com.nissan.model.Customer;

@Service
public class CustomerServiceImplementation implements ICustomerService {

	@Autowired
	ICustomerDAO customerDAO;
	
	//get a list of all customers
	@Override
	public List<Customer> listAllCustomers() {
		
		return customerDAO.findAll();
	}

	//search for a customer using customer number
	@Override
	public Customer getCustomerByCustomerNumber(Integer _customerNo) {

		Customer customer = customerDAO.getCustomerByCustomerNumber(_customerNo);
		
		if(customer != null)
			return customer;
		return null;
	}
	
	//add new customer
	@Override
	public Customer addNewCustomer(Customer customer) {
		return customerDAO.save(customer);
	}


	//update customer
	@Override
	public Customer updateCustomer(Customer customer) {
		return customerDAO.save(customer);

	}
}
