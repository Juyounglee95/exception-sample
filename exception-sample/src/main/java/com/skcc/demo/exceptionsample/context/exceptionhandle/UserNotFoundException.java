package com.skcc.demo.exceptionsample.context.exceptionhandle;

public class UserNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L; //set UID
	
	public UserNotFoundException() {
		
	}
	public UserNotFoundException(String message) {
		super(message);
	}
}
