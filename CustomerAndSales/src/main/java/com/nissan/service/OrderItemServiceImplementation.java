package com.nissan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.dao.IOrderItemDAO;
import com.nissan.model.OrderItem;

@Service
public class OrderItemServiceImplementation implements IOrderItemService {

	@Autowired
	IOrderItemDAO orderItemDAO;
	
	//add new order item
	@Override
	@Transactional
	public OrderItem addNewOrderItem(OrderItem orderItem) {
		return orderItemDAO.save(orderItem);
	}

	//list all ordered items
	@Override
	public List<OrderItem> viewAllOrders() {
		return orderItemDAO.findAll();
	}

	//search item by item id
	@Override
	public OrderItem searchItemOrderedByItemId(Integer _itemID) {
		OrderItem orderItem = orderItemDAO.getItemDetailsById(_itemID);
		return orderItem;
	}

}
