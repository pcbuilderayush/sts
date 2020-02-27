package com.cts.srb;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.List;
import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.cts.srb.Service.EmployeeService;
import com.cts.srb.api.EmployeeApi;
import com.cts.srb.model.Department;
import com.cts.srb.model.Employee;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeApi.class)
public class EmployeeControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private EmployeeService service;
	
	@Test
	public void whenFindAll_thenReturnJsonArray() throws Exception{
		
		Employee emp=new Employee("kusuma","kumari",26000,LocalDate.now(),Department.DEVELOPMENT,"8106924625","kusuma@gmail.com");
		
		List<Employee> allEmployees =Arrays.asList(emp);
		
		given(service.findAll()).willReturn(allEmployees);
		
		mvc.perform(get("/emps").contentType(MediaType.APPLICATION_JSON))
		                          .andExpect(status().isOk())
		                          .andExpect(jsonPath("$",hasSize(1)))
		                          .andExpect(jsonPath("$[0].mobileNum",is(emp.getMobileNum())));
	}

}
