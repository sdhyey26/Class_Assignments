package com.tss.Exceptions;

public class MaxLimitExceedException extends RuntimeException {
	int amount;
	public MaxLimitExceedException(int amount) {
		this.amount = amount ;
	}
	
	public String getMessage()
	{
		return "The amount you are requesting is exceeding the maximum water capacity limit  : "+amount;
	}
}
