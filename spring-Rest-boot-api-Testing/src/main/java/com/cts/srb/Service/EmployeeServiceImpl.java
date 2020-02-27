package com.cts.srb.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.srb.Dao.EmployeeRepository;
import com.cts.srb.model.Department;
import com.cts.srb.model.Employee;
import com.cts.srb.Exception.EmployeeException;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository emprep;

	@Override
	public Employee add(Employee emp) throws EmployeeException{
		
		if(emp!=null) {
			if(emprep.existsById(emp.getEmpId())) {
				throw new EmployeeException("there exists an employee with the given id");
			}
			else if(emprep.existsByMobileNum(emp.getMobileNum())) {
				throw new EmployeeException("employee with this mobile number is exists");
			}
			else if(emprep.existsByEmail(emp.getEmail())) {
				throw new EmployeeException("employee exists with this email id");
			}
			else {
				emp=emprep.save(emp);
			}
		}
		return emp;
	}
	
	@Override
	public Employee save(Employee emp) throws EmployeeException{
		
		if(emp!=null) {
		Employee oldEmp=emprep.findById(emp.getEmpId()).orElse(null);
		
		if(oldEmp==null) {
			throw new EmployeeException("there exists an employee number is exists");
		}
		
		else if(!oldEmp.getMobileNum().equals(emp.getMobileNum()) && emprep.existsByMobileNum(emp.getMobileNum())) {
			throw new EmployeeException("employee with this mobile number is exists");
		}
		else if(!oldEmp.getEmail().equals(emp.getEmail()) && emprep.existsByEmail(emp.getEmail())) {
			throw new EmployeeException("employee exists with this email id");
		}
		else {
			emp=emprep.save(emp);
			}
		}
		return emp;
	}

	
	@Override
	public void deleteById(Long empId) {
		
		emprep.deleteById(empId);
	}
	
	@Override
	public Employee findById(Long empId) {
		return emprep.findById(empId).orElse(null);
	}
	

	@Override
	public Employee findByMobileNum(String mobileNum) {
		
		return emprep.findByMobileNum(mobileNum);
	}

	@Override
	public Employee findByEmail(String email) {
		
		return emprep.findByEmail(email);
	}

	@Override
	public List<Employee> findAll() {
		
		return emprep.findAll();
	}

	@Override
	public List<Employee> findAllByDept(Department dept) {
		
		return emprep.findAllByDept(dept);
	}

	@Override
	public List<Employee> findAllByDate(LocalDate date) {
		
		return emprep.findAllByDate(date);
	}

	@Override
	public List<Employee> findAllByBasicRange(double lb, double ub) {
		
		return emprep.findAllByBasicRange(lb, ub);
	}
}
