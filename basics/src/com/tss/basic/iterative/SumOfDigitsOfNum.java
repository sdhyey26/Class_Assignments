package com.tss.basic.iterative;

import java.util.Scanner;

public class SumOfDigitsOfNum {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter Numbers : ");
		int number = sc.nextInt();
		int sum = 0;
		
		while(number != 0) {
			int digit = number % 10;
			sum += digit;
			number /= 10;
		}
		System.out.println("Sum of digits : " + sum);
	}
}
