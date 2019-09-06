package com.sgic.internal.employee.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Employee implements Serializable {

	// Initialize Variable for Attribute of Employee
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empId;


	@Column(name = "name")
	private String name;


	

	public Long getEmpId() {
		return empId;
	}


	public void setEmpId(Long empId) {
		this.empId = empId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Employee() {
		super();
	}


	public Employee(Long empId, String name) {
		super();
		this.empId = empId;
		this.name = name;
	}


	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + "]";
	}




	

	


	


}
