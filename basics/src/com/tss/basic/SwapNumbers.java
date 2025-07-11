package com.tss.basic;

import java.util.Scanner;

public class SwapNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("enter a : ");
		int number1 =  sc.nextInt();
		
		System.out.print("enter b : ");
		int number2 =  sc.nextInt();
		
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
