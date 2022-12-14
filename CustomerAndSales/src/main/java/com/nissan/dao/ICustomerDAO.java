package com.nissan.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.nissan.model.Customer;

@Repository
public interface ICustomerDAO extends JpaRepositoryImplementation<Customer, Integer> {
	
	@Query("from Customer where customerNo=?1")
	public Customer getCustomerByCustomerNumber(Integer _customerNo);
	
}
