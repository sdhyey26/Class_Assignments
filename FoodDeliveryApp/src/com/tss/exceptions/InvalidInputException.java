package com.tss.exceptions;

public class InvalidInputException extends RuntimeException {
	public String getMessage() {
		return "Not a valid input !!";
		
	}
}
