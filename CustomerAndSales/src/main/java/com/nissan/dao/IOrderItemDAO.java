package com.nissan.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.nissan.model.OrderItem;

@Repository
public interface IOrderItemDAO extends JpaRepositoryImplementation<OrderItem, Integer> {

	@Query("from OrderItem where itemId=?1")
	public OrderItem getItemDetailsById(Integer _itemId);
}
