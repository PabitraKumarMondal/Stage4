package com.cognizant.springlearn.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason = "Bad Request") --> this can be used in mismatch of url pattern
@ResponseStatus(value= HttpStatus.NOT_FOUND, reason = "Country not found")
public class CountryNotFoundException extends Exception{

	public CountryNotFoundException() {
		super();
	}
	
	
}
