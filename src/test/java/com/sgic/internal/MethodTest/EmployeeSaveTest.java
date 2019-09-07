package com.sgic.internal.MethodTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.sgic.internal.employee.entities.Employee;
import com.sgic.internal.employee.repositories.EmployeeRepository;
import com.sgic.internal.employee.services.impl.EmployeeServiceImpl;

@RunWith(SpringRunner.class)
public class EmployeeSaveTest {

	@Mock
	EmployeeRepository EmpRepo;

	@InjectMocks
	EmployeeServiceImpl empService;

	@Test
	public void saveTest() {
		Employee emp = new Employee();
		emp.setEmpId(1L);
		emp.setName("java");

		when(EmpRepo.save(emp)).thenReturn(emp);
		Employee result = empService.saveEmployee(emp);

		assertEquals("java", result.getName());

	}
	
	
	@Test
	public void saveEmployee() {
		Employee emp = new Employee();
		emp.setEmpId(2L);
		emp.setName("java");
		when(EmpRepo.save(emp)).thenReturn(emp);
		Employee result = empService.saveEmployee(emp);
		
		assertEquals("java", result.getName());
	}

}
