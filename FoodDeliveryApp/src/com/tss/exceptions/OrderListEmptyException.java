package com.tss.exceptions;

public class OrderListEmptyException extends RuntimeException{
	
	public String getMessage() {
		return "Order list empty nothing to display !!";
	}
}
