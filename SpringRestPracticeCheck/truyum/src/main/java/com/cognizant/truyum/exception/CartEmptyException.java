package com.cognizant.truyum.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Cart not exist")
public class CartEmptyException extends Exception {

	public CartEmptyException() {
		super();
	}

}
