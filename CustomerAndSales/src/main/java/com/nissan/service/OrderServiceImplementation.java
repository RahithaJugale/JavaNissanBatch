package com.nissan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.dao.IOrderDAO;
import com.nissan.model.Order;

@Service
public class OrderServiceImplementation implements IOrderService {

	@Autowired
	IOrderDAO orderDAO;
	
	//add new order
	@Override
	@Transactional
	public Order addNewOrder(Order order) {
		return orderDAO.save(order);
	}

	//list all orders
	@Override
	public List<Order> viewAllOrders() {
		return orderDAO.findAll();
	}

	//search order by ID
	@Override
	public Order searchOrderByOrderId(Integer _orderId) {
		return orderDAO.getOrderDetailsById(_orderId);
	}

}
