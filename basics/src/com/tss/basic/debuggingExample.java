package com.tss.basic;

import java.util.Random;

public class debuggingExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		int number = random.nextInt(5);

		System.out.println(number);
		int result = factorialCalculator(number);

		System.out.println(result);
	}

	public static int factorialCalculator(int number) {
		int factorial = 1;
		for (int i = 1; i <= number; i++) {
			factorial = factorial * i;
		}
		return factorial;
	}
}
