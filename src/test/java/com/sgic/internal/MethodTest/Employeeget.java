package com.sgic.internal.MethodTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sgic.internal.employee.entities.Employee;
import com.sgic.internal.employee.repositories.EmployeeRepository;
import com.sgic.internal.employee.services.impl.EmployeeServiceImpl;

@RunWith(SpringRunner.class)
public class Employeeget {

	@InjectMocks
	EmployeeServiceImpl service;

	@Mock
	EmployeeRepository EmpRepo;
	
//	@MockBean
//	private MockMvc mockMvc;
	

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

	@Test
	public void EmpGet() {
		List<Employee> emplist = new ArrayList<>();
		Employee emplist1 = new Employee();
		emplist1.setEmpId(2L);
		emplist1.setName("java");
		emplist.add(emplist1);

		when(service.getallemployee()).thenReturn(emplist);
		assertEquals(1, EmpRepo.findAll().size());

	}

	public void getemployee() {
		List<Employee> empoyee2 = new ArrayList<>();
		Employee employee1 = new Employee();
		employee1.setEmpId(1L);
		employee1.setName("jothi");
		empoyee2.add(employee1);

		when(service.getallemployee()).thenReturn(empoyee2);
		assertEquals(1, EmpRepo.findAll().size());

	}
	


}
