package com.ty.textilestockmanagement.exception;

public class NoIdFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String message = "ID doesnot exits";
	
	public NoIdFoundException() {
	}
	
	public NoIdFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
