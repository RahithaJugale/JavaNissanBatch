package com.nissan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.model.OrderItem;
import com.nissan.service.IOrderItemService;

@RestController
@RequestMapping("api/")
public class OrderItemController {

	@Autowired
	IOrderItemService orderItemService;

	// add new order item
	@PostMapping("orderItems")
	public OrderItem addNewOrderItem(@RequestBody OrderItem orderItem) {
		return orderItemService.addNewOrderItem(orderItem);
	}

	// list all ordered items
	@GetMapping("orderItems")
	public List<OrderItem> viewAllOrders() {
		return orderItemService.viewAllOrders();
	}

	// search item by item id
	@GetMapping("orderItems/{_itemID}")
	public OrderItem searchItemOrderedByItemId(@PathVariable Integer _itemID) {
		return orderItemService.searchItemOrderedByItemId(_itemID);
	}
}
