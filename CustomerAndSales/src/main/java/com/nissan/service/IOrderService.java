package com.nissan.service;

import java.util.List;

import com.nissan.model.Order;

public interface IOrderService {

	//add new order
	Order addNewOrder(Order order);
	
	//view all orders
	List<Order> viewAllOrders();
	
	//search order by orderId
	Order searchOrderByOrderId(Integer _orderId);
	
}
