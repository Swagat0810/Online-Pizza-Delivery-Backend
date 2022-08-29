package com.cg.onlinepizzaapp.onlinepizzaapp.exception;

public class CustomerAlreadyPresentException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public CustomerAlreadyPresentException(String message) {
		super(message);
		

	}

}