package com.sgic.internal.MethodTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.sgic.internal.employee.entities.Employee;
import com.sgic.internal.employee.repositories.EmployeeRepository;
import com.sgic.internal.employee.services.impl.EmployeeServiceImpl;

@RunWith(SpringRunner.class)
public class Employeeget {

	@InjectMocks
	EmployeeServiceImpl service;

	@Mock
	EmployeeRepository EmpRepo;
	
	@Test
	public void GetMethod() {
		List<Employee> emp = new ArrayList<>();
		Employee employee = new Employee();
		employee.setEmpId(1L);
		employee.setName("Name");
		emp.add(employee);

		when(service.getallemployee()).thenReturn(emp);
		assertEquals(1, EmpRepo.findAll().size());

	}

}
