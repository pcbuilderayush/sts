package com.cts.srb.Service;

import java.time.LocalDate;
import java.util.List;

import com.cts.srb.model.Department;
import com.cts.srb.model.Employee;
import com.cts.srb.Exception.EmployeeException;

public interface EmployeeService {
	
	Employee add(Employee emp) throws EmployeeException;
	Employee save(Employee emp) throws EmployeeException;
	void deleteById(Long empId);
	
	Employee findByMobileNum(String mobileNum);
	Employee findById(Long empId);
	Employee findByEmail(String email);
	
	List<Employee> findAll();
	List<Employee> findAllByDept(Department dept);
	List<Employee> findAllByDate(LocalDate date);
	List<Employee> findAllByBasicRange(double lb,double ub);

}
