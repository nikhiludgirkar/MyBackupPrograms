package com.shaadi.exceptions;

public class ExplicitAssertionError extends RuntimeException{

	private static final long serialVersionUID = 1L;
	public ExplicitAssertionError(final String message) {
		super(message);
	}
}
