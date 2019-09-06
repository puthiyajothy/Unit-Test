package com.sgic.internal.employee.dto;

public class EmployeeDTO {

//	Initialize EmployeeDTO
	private Long empId;

	private String name;

	

	public EmployeeDTO() {
		super();
	}



	public EmployeeDTO(Long empId, String name) {
		super();
		this.empId = empId;
		this.name = name;
	}



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




}