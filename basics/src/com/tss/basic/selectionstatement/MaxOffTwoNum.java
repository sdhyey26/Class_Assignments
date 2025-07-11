package com.tss.basic.selectionstatement;

import java.util.Scanner;

public class MaxOffTwoNum {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter number1 : ");
		int number1 = sc.nextInt();
		
		System.out.println("enter number2 : ");
		int number2 = sc.nextInt();
		
		maxChecker(number1 , number2);
	}
	
	private static void maxChecker(int number1 , int number2) {
		if(number1 > number2) {
			System.out.println("Number 1 is greater");
		}
		if(number2 > number1 ){
			System.out.println("number 2 is greater");
		}
		if(number1 == number2) {
			System.out.println("both are equal");
		}
	}
}
