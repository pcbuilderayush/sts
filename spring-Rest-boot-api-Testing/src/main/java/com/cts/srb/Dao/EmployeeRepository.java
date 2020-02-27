package com.cts.srb.Dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.srb.model.Department;
import com.cts.srb.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	
	boolean existsByMobileNum(String mobileNum);
	boolean existsByEmail(String email);
	
	Employee findByMobileNum(String mobileNum);
	Employee findByEmail(String email);
	
	List<Employee> findAllByDept(Department dept);
	List<Employee> findAllByDate(LocalDate date);

	@Query("SELECT e FROM Employee e WHERE e.basic>=:lb and e.basic<:ub")
	List<Employee> findAllByBasicRange(double lb,double ub);
}
