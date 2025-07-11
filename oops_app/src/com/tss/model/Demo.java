package com.tss.model;

public class Demo {
	private int a = 0;
	private int b = 0;
	protected static int c = 0;
	
	public Demo(){
		System.out.println("inside a constructor of demo");
	}
	
	public void increment() {
		a++;
		b++;
		c++;
	}
	
	public void display() {
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
	
	{
		System.out.println("inside block of Demo class");
	}
	
	static
	{
		System.out.println("inside block of Demo class");
	}
}

