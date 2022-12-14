package com.nissan.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.joda.time.DateTime;

@Entity
@Table(name="tblprofessor")
public class Professor {

	//instance variables
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer professorId;
	
	private Integer managerId;
	@Column(nullable=false)
	private String firstName;
	private String lastName;
	@Column(nullable=false)
	private Integer deptId;
	private Double salary;
	private LocalDate joiningDate;
	private LocalDate dateOfBirth;
	private String gender;
	
	private Boolean isActive;
	private DateTime createdAt;
	private DateTime updatedAt;
	
	//default constructor
	public Professor() {

	}

	//parameterized constructor - 1
	public Professor(Integer professorId, Integer managerId, String firstName, String lastName, Integer deptId,
			Double salary, LocalDate joiningDate, LocalDate dateOfBirth, String gender, Boolean isActive,
			DateTime createdAt, DateTime updatedAt) {
		super();
		this.professorId = professorId;
		this.managerId = managerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.deptId = deptId;
		this.salary = salary;
		this.joiningDate = joiningDate;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	//getters and setters
	public Integer getProfessorId() {
		return professorId;
	}

	public void setProfessorId(Integer professorId) {
		this.professorId = professorId;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	//toString()
	@Override
	public String toString() {
		return "Professor [professorId=" + professorId + ", managerId=" + managerId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", deptId=" + deptId + ", salary=" + salary + ", joiningDate="
				+ joiningDate + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", isActive=" + isActive
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}	
}
