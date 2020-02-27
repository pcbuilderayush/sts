package com.cts.srb.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cts.srb.Exception.EmployeeException;

@RestControllerAdvice
public class ExceptionAdvisor {
	
	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<String> handleEmployeeExceptionAction(EmployeeException exp){
		return new ResponseEntity<String>(exp.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleEmployeeExceptionAction(Exception emp){
		return new ResponseEntity<String>(emp.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
