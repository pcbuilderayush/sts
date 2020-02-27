package com.cts.srb;

import static org.assertj.core.api.Assertions.assertThat;


import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.srb.Dao.EmployeeRepository;
import com.cts.srb.model.Department;
import com.cts.srb.model.Employee;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeDaoUnitTest {

	private Employee emps[];
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public EmployeeDaoUnitTest() {
		emps=new Employee[] {
				new Employee("kiran","naidu",32000,LocalDate.now(),Department.DEVELOPMENT,"4562879320","kiran@gmail.com")
		};
	}
	
	@Before
	public void beforeEachTest() {
		for(Employee e:emps) {
			entityManager.persist(e);
		}
		entityManager.flush();
	}
	
	@After
	public void afterEachTest() {
		for(Employee e:emps) {
			entityManager.remove(e);
		}
		entityManager.flush();
	}

	@Test
	public void whenFindByMobileNum_thenReturnEmployee() {
		Employee e=employeeRepository.findByMobileNum(emps[0].getMobileNum());
		assertThat(e).isEqualTo(emps[0]);
	}
	
	@Test
	public void whenFindByMobileNum_withNonExistingMobileNum_thenReturnNull() {
		Employee e=employeeRepository.findByMobileNum("2305785420");
		assertThat(e).isNull();
	}
}
