package com.sgic.internal.APITest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sgic.internal.employee.EmployeeApplication;
import com.sgic.internal.employee.controller.EmployeeController;
import com.sgic.internal.employee.dto.EmployeeDTO;
import com.sgic.internal.employee.dto.mapper.EmployeeDTOMapper;
import wiremock.com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
@ContextConfiguration(classes={EmployeeApplication.class})
public class EmployeeApiTest {

	@MockBean
	EmployeeDTOMapper service;

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void GetMethodapi() throws Exception {
		List<EmployeeDTO> emplist = new ArrayList<>();
		EmployeeDTO employee = new EmployeeDTO();
		employee.setEmpId(1L);
		employee.setName("name");
		emplist.add(employee);
		
		System.out.println(emplist);

//		when(service.getallemployee()).thenReturn(emp);
//		assertEquals(1, EmpRepo.findAll().size());
		
		when(service.getAllSortEmployeeInfo()).thenReturn(emplist);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getallemployee").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = "[{\"empId\":1,\"name\":\"name\"}]";;
		assertEquals(expected, result.getResponse().getContentAsString());

	}
	
	
	@Test
	public void SaveApiTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/createemployee").content(asJsonString(new EmployeeDTO(1L, "java")))
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk());
	
	
	
	}
	
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
