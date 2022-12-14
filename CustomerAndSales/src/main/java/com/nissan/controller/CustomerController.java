package com.nissan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.model.Customer;
import com.nissan.service.ICustomerService;

@RestController
@RequestMapping("api/")
public class CustomerController {

	@Autowired
	ICustomerService customerService;

	// get a list of all customers
	@GetMapping("customers")
	public List<Customer> listAllCustomers() {
		return customerService.listAllCustomers();
	}
	
	//get customer details using customerNo
	@GetMapping("customers/{_customerNo}")
	public Customer getCustomerDetails(@PathVariable Integer _customerNo) {
		return customerService.getCustomerByCustomerNumber(_customerNo);
	}
	
	//add new customer
	@PostMapping("customers")
	public Customer addNewCustomer(@RequestBody Customer customer) {
		return customerService.addNewCustomer(customer);
	}
	
	@PutMapping("customers/{_customerId}")
	public Customer updateCustomer(@PathVariable Integer _customerId, @RequestBody Customer customer) {
		return customerService.updateCustomer(customer);
	}
}
