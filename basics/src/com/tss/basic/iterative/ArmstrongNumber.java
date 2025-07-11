package com.tss.basic.iterative;

import java.util.Scanner;

public class ArmstrongNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter the number : ");
		int number = sc.nextInt();
		String num = Integer.toString(number);
		int sum = 0;
		int numeric = number;
		
		while(number != 0) {
			int digit = number % 10;
			sum += Math.pow(digit, num.length());
			number /= 10;
		}
		System.out.println(sum);
		
		if(sum == numeric) {
			System.out.println("the given number is a armstong number !!");
		}
		else {
			System.out.println("the given number is not a armstrong number !!");
		}
	}

}
