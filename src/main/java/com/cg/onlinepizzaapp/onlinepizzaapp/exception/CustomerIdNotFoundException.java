package com.cg.onlinepizzaapp.onlinepizzaapp.exception;

public class CustomerIdNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public CustomerIdNotFoundException(String message) {
		super(message);

	}

}