package com.tss.test;

import com.tss.model.Demo;

public class DemoStatic {
	public static void main(String[] args) {
		Demo demo1 = new Demo();
		Demo demo2 = new Demo();
		Demo demo3 = new Demo();
		
		demo1.increment();
		demo2.increment();
		demo3.increment();
		
		demo1.display();
		demo2.display();
		demo3.display();
	}
	
	{
		System.out.println("inside block main");
	}
	
	static
	{
		System.out.println("inside static block in main");
	}
	
	
}
