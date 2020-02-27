package com.cts.srb;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.srb.Dao.EmployeeRepository;
import com.cts.srb.Service.EmployeeService;
import com.cts.srb.Service.EmployeeServiceImpl;
import com.cts.srb.model.Department;
import com.cts.srb.model.Employee;

@RunWith(SpringRunner.class)
public class EmployeeServiceImplUnitTest {
	
	@TestConfiguration //mocking can be done
	static class EmployeeServiceImplTestContextConfiguration{  //innerClass
		
		@Bean
		public EmployeeService employeeService() {
			
			return new EmployeeServiceImpl();
		}
		
	}
	
	@Autowired
	private EmployeeService employeeService;
	
	@MockBean
	private EmployeeRepository employeeRepository;

	@Before
	public void setUp() {
		Employee emp=new Employee("kusuma","kumari",26000,LocalDate.now(),Department.DEVELOPMENT,"8106924625","kusuma@gmail.com");
		
		Mockito.when(employeeRepository.findByMobileNum(emp.getMobileNum())).thenReturn(emp);
	}
	
	@Test
	public void whenValidMobileNum_thenEmployeeShouldBeFound() {
		String mno="8106924625";
		Employee found=employeeService.findByMobileNum(mno);
		assertThat(found.getMobileNum()).isEqualTo(mno);
	}
	
	@Test
	public void whenInvalidMobileNum_thenEmployeeShouldNotBeFound() {
		String mno="2354016975";
		Employee found=employeeService.findByMobileNum(mno);
		assertThat(found).isNull();
	}
}
