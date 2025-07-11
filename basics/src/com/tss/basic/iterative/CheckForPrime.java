package com.tss.basic.iterative;

import java.util.Scanner;

public class CheckForPrime {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Number:-");
			int number = sc.nextInt();
			int i = 2;
			Boolean isprime = true;
			while (i <= number / 2) {
				if (number % i == 0) {
					isprime = false;
					break;
				}
				i++;
			}
			if (isprime) {
				System.out.println("number is prime");
			} else {
				System.out.println("number is not prime");
			}

		}

}
