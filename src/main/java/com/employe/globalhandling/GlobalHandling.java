package com.employe.globalhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.employe.customexception.InvalidSalaryException;

@RestControllerAdvice
public class GlobalHandling {
	
	@ExceptionHandler(InvalidSalaryException.class)
	public ResponseEntity<Object> salaryHandle(){
		return new ResponseEntity<Object> ("Invalid Salary",HttpStatus.BAD_REQUEST);
	}

}
