package com.nissan.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tblCustomer")
public class Customer {

	// instance variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerNo;

	@Column(nullable = false)
	private String customerName;
	private String address;

	private Boolean isActive;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime createdAt;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime updatedAt;

	@OneToMany(mappedBy = "customer")
	private List<Order> orders;

	// default constructor
	public Customer() {

	}

	// parameterized constructor
	public Customer(Integer customerNo, String customerName, String address, Boolean isActive, DateTime createdAt,
			DateTime updatedAt) {
		super();
		this.customerNo = customerNo;
		this.customerName = customerName;
		this.address = address;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Customer(Integer customerNo, String customerName, String address, Boolean isActive, DateTime createdAt,
			DateTime updatedAt, List<Order> orders) {
		super();
		this.customerNo = customerNo;
		this.customerName = customerName;
		this.address = address;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.orders = orders;
	}

	// getters and setters
	public Integer getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(Integer customerNo) {
		this.customerNo = customerNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public DateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(DateTime createdAt) {
		this.createdAt = createdAt;
	}

	public DateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(DateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@JsonManagedReference
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@PrePersist
	public void onSave() {
		DateTime currentDateTime = new DateTime();
		this.createdAt = currentDateTime;
		this.updatedAt = currentDateTime;
	}

	@PostPersist
	public void onUpdate() {
		DateTime currentDateTime = new DateTime();
		this.updatedAt = currentDateTime;
	}

	// toString()
	@Override
	public String toString() {
		return "Customer [customerNo=" + customerNo + ", customerName=" + customerName + ", address=" + address
				+ ", isActive=" + isActive + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
}
