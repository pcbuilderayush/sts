package com.cts.swrbd.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cts.swrbd.exception.EmployeeException;

@RestControllerAdvice
public class ExceptionAdvisor {

	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<String> handleEmployeeExceptionAction(EmployeeException exp){
		return new ResponseEntity<String>(exp.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	
}
