package com.tss.exceptions;

public class NoSuchMenuFound extends RuntimeException{
	public String getMessage()
	{
		return "No such Menu Found !!";
	}
	
}
