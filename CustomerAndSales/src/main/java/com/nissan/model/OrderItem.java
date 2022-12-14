package com.nissan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="tblOrderItem")
public class OrderItem {
	
	//instance variables
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer itemId;
	private Integer orderNo;
	private String itemName;
	private Integer quantity;
	
	@JoinColumn(name="orderNo",insertable=false, updatable=false)
	@ManyToOne
	private Order order;
	
	//default constructor
	public OrderItem() {

	}

	//parameterized constructor
	public OrderItem(Integer itemId, Integer orderNo, String itemName, Integer quantity) {
		super();
		this.itemId = itemId;
		this.orderNo = orderNo;
		this.itemName = itemName;
		this.quantity = quantity;
	}

	//getters and setters
	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@JsonBackReference
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	//toString()
	@Override
	public String toString() {
		return "OrderItem [itemId=" + itemId + ", orderNo=" + orderNo + ", itemName=" + itemName + ", quantity="
				+ quantity + ", order=" + order + "]";
	}
}
