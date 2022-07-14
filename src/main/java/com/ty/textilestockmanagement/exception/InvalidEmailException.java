package com.ty.textilestockmanagement.exception;

public class InvalidEmailException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message = "Invalid Email or Password";
	
	public InvalidEmailException() {
		// TODO Auto-generated constructor stub
	}
	
	public InvalidEmailException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
