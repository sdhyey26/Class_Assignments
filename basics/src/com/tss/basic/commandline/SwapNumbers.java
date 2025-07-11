package com.tss.basic.commandline;

import java.util.Scanner;

public class SwapNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("enter a : ");
		int number1 =  Integer.parseInt(args[0]);
		
		System.out.print("enter b : ");
		int number2 =  Integer.parseInt(args[1]);
		
		System.out.println("Before Swap");
		System.out.println("number1 : " + number1);
		System.out.println("number2 : " + number2);
		
		System.out.println("After Swap");
		swapNum(number1 , number2);
		
		}
	
		private static void swapNum(int a , int b) {
		int temp;
		temp = a;
		a = b;
		b = temp;
		System.out.println("a : " + a);
		System.out.println("b : " + b);
	}

}
