package com.nissan.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.nissan.model.Order;

@Repository
public interface IOrderDAO extends JpaRepositoryImplementation<Order, Integer> {
	
	@Query("from Order where orderNo=?1")
	public Order getOrderDetailsById(Integer _orderNo);
	
}
