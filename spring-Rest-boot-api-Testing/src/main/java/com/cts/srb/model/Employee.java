package com.cts.srb.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long empId;

	@NotEmpty(message = "firstName can not be empty")
	@NotNull(message = "firstName can not be omitted")
	private String firstName;

	@NotEmpty(message = "lastName can not be empty")
	@NotNull(message = "lastName can not be omitted")
	private String lastName;

	@Min(value = 25000, message = "basic can not be less than 25 thousand")
	@Max(value = 45000, message = "basic can not be more than 4.5 lakhs")
	private double basic;

	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate date;

	@Enumerated(EnumType.STRING)
	private Department dept;

	@Pattern(regexp = "[1-9][0-9]{9}", message = "mobile number is expected to be 10 digits")
	@NotNull(message = "mobile number can not be omitted")
	private String mobileNum;

	@Email(message = "email must be a valid one")
	@NotNull(message = "Email can not be omitted")
	private String email;

	public Employee() {
		
	}
	public Employee(String firstName,String lastName,double basic,LocalDate date,Department dept,String mobileNum,String email) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.basic=basic;
		this.date=date;
		this.dept=dept;
		this.mobileNum=mobileNum;
		this.email=email;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getBasic() {
		return basic;
	}

	public void setBasic(double basic) {
		this.basic = basic;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

}
