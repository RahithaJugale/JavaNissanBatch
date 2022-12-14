package com.nissan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.model.Order;
import com.nissan.service.IOrderService;

@RestController
@RequestMapping("api/")
public class OrderController {

	@Autowired
	IOrderService orderService;

	// list all orders
	@GetMapping("orders")
	public List<Order> viewAllOrders() {
		return orderService.viewAllOrders();
	}

	// add new order
	@PostMapping("orders")
	public Order addNewOrder(@RequestBody Order order) {
		return orderService.addNewOrder(order);
	}

	// search order by ID
	@GetMapping("orders/{_orderId}")
	public Order searchOrderByOrderId(@PathVariable Integer _orderId) {
		return orderService.searchOrderByOrderId(_orderId);
	}
}
