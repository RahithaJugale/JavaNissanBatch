package com.nissan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tblGender")
public class Gender {
	
	//instance variables
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer genderId;
	private String gender;
	
	//default constructor
	public Gender() {

	}

	//parameterized constructor
	public Gender(Integer genderId, String gender) {
		super();
		this.genderId = genderId;
		this.gender = gender;
	}

	//getters and setters
	public Integer getGenderId() {
		return genderId;
	}

	public void setGenderId(Integer genderId) {
		this.genderId = genderId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	//toString()
	@Override
	public String toString() {
		return "Gender [genderId=" + genderId + ", gender=" + gender + "]";
	}
}
