package com.nissan.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="tblOrder")
public class Order {
	
	//instance variables
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer orderNo;
	
	@Column(nullable=false)
	private Integer customerNo;
	private LocalDate orderDate;
	
	@JoinColumn(name="customerNo", insertable=false, updatable=false)
	@ManyToOne
	private Customer customer;
	
	@OneToMany(mappedBy="order")
	private List<OrderItem> orderItems;
	
	//default constructor
	public Order() {
		
	}

	//parameterized constructor
	public Order(Integer orderNo, Integer customerNo, LocalDate orderDate) {
		super();
		this.orderNo = orderNo;
		this.customerNo = customerNo;
		this.orderDate = orderDate;
	}
	
	

	public Order(Integer orderNo, Integer customerNo, LocalDate orderDate, Customer customer) {
		super();
		this.orderNo = orderNo;
		this.customerNo = customerNo;
		this.orderDate = orderDate;
		this.customer = customer;
	}

	
	public Order(Integer orderNo, Integer customerNo, LocalDate orderDate, Customer customer,
			List<OrderItem> orderItems) {
		super();
		this.orderNo = orderNo;
		this.customerNo = customerNo;
		this.orderDate = orderDate;
		this.customer = customer;
		this.orderItems = orderItems;
	}

	//getters and setters
	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(Integer customerNo) {
		this.customerNo = customerNo;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	@JsonBackReference
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	@JsonManagedReference
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	//toString()
	@Override
	public String toString() {
		return "Order [orderNo=" + orderNo + ", customerNo=" + customerNo + ", orderDate=" + orderDate + ", customer="
				+ customer + "]";
	}
}
