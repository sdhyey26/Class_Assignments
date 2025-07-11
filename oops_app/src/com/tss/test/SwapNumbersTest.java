package com.tss.test;

import com.tss.model.SwapNumbers;

public class SwapNumbersTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwapNumbers number1 = new SwapNumbers(10);
		SwapNumbers number2 = new SwapNumbers(20);
		
		System.out.println("number 1 : " + number1.getValue());
		System.out.println("number 2 : " + number2.getValue());
		
		swapNumbers( number1 ,  number2);
		
		System.out.println("number 1 : " + number1.getValue());
		System.out.println("number 2 : " + number2.getValue());

	}
	
	public static void swapNumbers(SwapNumbers num1 , SwapNumbers num2) {
		SwapNumbers temp = new SwapNumbers();
		temp.setValue(num1.getValue());
		num1.setValue(num2.getValue());
		num2.setValue(temp.getValue());
		
	}

}
