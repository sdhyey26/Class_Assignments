package com.tss.Exceptions;

public class InsufficientLimitException extends RuntimeException {
	private int amount;

	public InsufficientLimitException(int amount) {
		this.amount = amount;
	}
	
	public String getMessage()
	{
		return "The current water level is insufficient for the amount you requested : "+amount;
	}
}
