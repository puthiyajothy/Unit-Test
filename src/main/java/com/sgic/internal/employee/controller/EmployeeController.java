package com.sgic.internal.employee.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.internal.employee.dto.EmployeeDTO;
import com.sgic.internal.employee.dto.mapper.EmployeeDTOMapper;
import com.sgic.internal.employee.entities.Employee;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmployeeController {


	@Autowired
	
	private EmployeeDTOMapper EmpImpl;
	
//	@Autowired
//	private EmployeeServiceImpl EmpImpl;


	@PostMapping(value = "/createemployee") 
	public Employee createEmployee(@RequestBody EmployeeDTO employeedto) {

		return EmpImpl.saveEmployee(employeedto);

	}

	@GetMapping(value = "/getallemployee") 
	public List<EmployeeDTO> sortListEmployeeInfo() {
		 return EmpImpl.getAllSortEmployeeInfo();
	}

	
	
//	@GetMapping("/getempolyeebyid/{empid}") // Get Employee By Employee ID
//	public ResponseEntity<Employee> getEmployeeById(@PathVariable(name = "empid") Long empid) {
//			return new ResponseEntity<>(EmpImpl.getByempId(empid),HttpStatus.OK);
//
//		
//
//	}
	

//	@DeleteMapping("/deletebyid/{empId}") // Delete Employee Using Employee ID
//	public ResponseEntity<String> deleteEmployeeByempId(@PathVariable("empId") Long empId) {
//		try {
//			logger.info("Employee Controller :-> DeleteEmployeeById");
////			employeeDTOMapper.deleteByEmployeeId(empid.toUpperCase());
//			employeeDTOMapper.deleteByEmployeeId(empId);
//			return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
//		} catch (Exception ex) {
//			logger.error("Employee Controller :-> Error" + ex.getMessage());
//		}
//		return null;
//	}
//

//	@GetMapping("/getemail/{email}")
//	// Get Employee By Email
//	public ResponseEntity<EmployeeDTO> getEmployeeByEmail(@PathVariable(name = "email") String email) {
//		try {
//			logger.info("Employee Controller:: -> GetEmail");
//			return new ResponseEntity<>(employeeDTOMapper.getByEmployeeEmailforMapper(email), HttpStatus.OK);
//		} catch (Exception ex) {
//			logger.error("Employee Controller:: -> Error" + ex.getMessage());
//		}
//		return null;

//	@PutMapping("update/{empId}") // update Employee Using Employee ID
//	public ResponseEntity<String> updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
//		try {
//			logger.info("Employee Controller :-> Update");
//			if (employeeDTOMapper.UpdateEmployee(employeeDTO) != null) {
//				return new ResponseEntity<>("Successfully Updated", HttpStatus.OK);
//			}
//			return new ResponseEntity<>("Failed To Update", HttpStatus.OK);
//		} catch (Exception ex) {
//			logger.error("Employee Controller :-> Error" + ex.getMessage());
//		}
//
//		return null;
//	}
//

//	@GetMapping("/getdesignation/{designationid}") // Get Employee By Designation
//	public List<EmployeeDTO> getByDesignation(@PathVariable(name = "designationid") Long designationid) {
//		try {
//			logger.info("Employee Controller :-> GetDesignation");
//			return employeeDTOMapper.getEmployeeByDesignation(designationid);
//		} catch (Exception ex) {
//			logger.error("Employee Controller :-> Error" + ex.getMessage());
//		}
//		return null;
//
//	}
//



}
