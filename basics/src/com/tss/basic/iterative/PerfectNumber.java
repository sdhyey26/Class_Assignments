package com.tss.basic.iterative;

import java.util.Scanner;

public class PerfectNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter number : ");
		int number = sc.nextInt();
		int sum = 0;
		
		int i = 1;
		while(i <= number/2){
			if(number % i == 0) {
				sum += i;
			}
			i++;
		}
		System.out.println(sum);
		
		if(sum == number) {
			System.out.println("Perfect Number");
		}
		else {
			System.out.println("not a perfect number");
		}
	}
}
