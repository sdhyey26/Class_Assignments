package com.tss.basic.iterative;

import java.util.ArrayList;
import java.util.Scanner;

public class primeNumberPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("please enter number of rows : ");
		int sum = 0;
		int rows = sc.nextInt();
		boolean isPrime = true;
		ArrayList<Integer> primeNumArray = new ArrayList<Integer>();

		for (int i = 1; i <= rows; i++) {
			sum += i;
		}

		System.out.println("You will need " + sum + " Prime numbers !");
		System.out.println();

			int totalPrime = 0;
			for (int i = 2; i <= 10000; i++) {
				if(totalPrime == sum) {
					break;
				}
				for (int j = 2; j <= i / 2; j++) {
					if (i % j == 0) {
						isPrime = false;
						break;
					}
					else {
						isPrime = true;
					}
				}
				if (isPrime) {
					primeNumArray.add(i);
					totalPrime++;
				}
			}
		
		for(int i : primeNumArray ) {
		      System.out.print(i);
		      System.out.print(" ");
		      
		}
		System.out.println();
		System.out.println();
		
		int k = 0;
		for(int i = 0 ; i < rows ; i++) {
			for(int j = 0 ; j <= i ; j++) {
				System.out.print(primeNumArray.get(k) + " ");
				k++;
			}
			System.out.println();
		}
	}
}
