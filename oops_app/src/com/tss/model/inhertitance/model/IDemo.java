package com.tss.model.inhertitance.model;

public interface IDemo {
	public static void method1() {
		System.out.println("the method is in the interface");
	}
	
	public default void method2() {
		System.out.println("the method is in the interface");
		method3();
	}
	
	private void method3() {
		System.out.println("the method is in the interface");
	}
}
