package com.tss.test;

import java.util.Scanner;

import com.tss.model.Ifactorial;

public class FactorialTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter the number : ");
		int num = sc.nextInt();
		
		Ifactorial factorial = ()->{
			int fact = 1;
			for(int i = 1 ; i <= num ; i++) {
				
				fact *= i;
			}
			return fact;
		};
		
		printFact(factorial);
	}

	private static void printFact(Ifactorial factorial) {
		// TODO Auto-generated method stub
		System.out.println("The factorial of the given num is : " + factorial.factorial());
	}
}
