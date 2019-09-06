package com.sgic.internal.employee.services.impl;


import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sgic.internal.employee.entities.Employee;

import com.sgic.internal.employee.repositories.EmployeeRepository;
import com.sgic.internal.employee.services.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	private static Logger logger = LogManager.getLogger(EmployeeRepository.class);


	@Override
	// Save Employee
	public Employee saveEmployee(Employee employee) {

		try {
			logger.info("Employee Service Imp:--> Save Employee Details methods");
			return employeeRepository.save(employee);
		} catch (Exception ex) {
			logger.error("Employee Service Imp:--> Error" + ex.getMessage());
		}
		return null;

	}

	@Override
	// List Employee
	public List<Employee> findByEmployeeOrderByEmployeeIdDesc(Long empId) {
		try {
			logger.info("Employee Service Imp:--> Get All Employee Details Methods");
			return employeeRepository.findAll(Sort.by(Sort.Direction.DESC, "empId"));
		} catch (Exception ex) {
			logger.error("Employee Service Imp:--> Error" + ex.getMessage());
		}
		return null;

	}

	@Override
	// Find By Employee Id
	public Employee getByempId(Long empId) {
		try {
			logger.info("Employee Service Imp:-->Get By Employee ID Methods");
			return employeeRepository.findEmployeeByEmpId(empId);
		} catch (Exception ex) {
			logger.error("Employee Service Imp:--> Error" + ex.getMessage());
		}
		return null;

	}

	@Override
	// Delete Employee
	public void deleteEmployeeByempId(Long empId) {
		try {
			logger.info("Delete Employee Details Methods");
			employeeRepository.deleteById(empId);
		} catch (Exception ex) {
			logger.error("Employee Service Imp:--> Error" + ex.getMessage());
		}

	}

	@Override
	// Update Employee
	public Employee updateEmployee(Employee employee) {
		try {
			Long empId = employee.getEmpId();
			boolean isExist = employeeRepository.findEmployeeByEmpId(empId) != null;
			if (isExist) {
				logger.info("Employee updates Successfully");
				return employeeRepository.save(employee);
			} else {
				logger.info("Employee Id is Not Found");
			}

		} catch (Exception ex) {
			logger.error("Employee Service Imp:--> Error" + ex.getMessage());
		}

		return null;
	}



	@Override
	// Find By Employee Name
	public List<Employee> getByName(String name) {
		try {
			logger.info("Successfully Get Employee By Name");
			return employeeRepository.findByName(name);
		} catch (Exception ex) {
			logger.error("Employee Service Imp:--> Error" + ex.getMessage());
		}
		return null;

	}

	@Override
	public long count() {
		try {
			return employeeRepository.count();
		} catch (Exception ex) {
			logger.error("Employee Service Imp:--> Error" + ex.getMessage());
		}
		return 0;

	}


	@Override
	public List<Employee> getallemployee() {
	
		return employeeRepository.findAll();
	}

	
	
	@Override
	public void store(MultipartFile file) {
		// TODO Auto-generated method stub
		
	}

	


	
}