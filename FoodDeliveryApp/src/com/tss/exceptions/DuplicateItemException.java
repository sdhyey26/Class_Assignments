package com.tss.exceptions;

public class DuplicateItemException extends RuntimeException {
	
	public String getMessage() {
		return "Menu already exists !!" ;
	}
}
