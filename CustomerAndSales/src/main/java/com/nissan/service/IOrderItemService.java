package com.nissan.service;

import java.util.List;

import com.nissan.model.OrderItem;

public interface IOrderItemService {

	// add new orderItem
	OrderItem addNewOrderItem(OrderItem orderItem);

	// view all orders
	List<OrderItem> viewAllOrders();

	// search order by orderId
	OrderItem searchItemOrderedByItemId(Integer _itemID);
}
