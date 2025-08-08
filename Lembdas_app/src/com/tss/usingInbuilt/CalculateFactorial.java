package com.tss.usingInbuilt;

import java.util.Scanner;
import java.util.function.Consumer;

public class CalculateFactorial {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the num : ");
		int num = sc.nextInt();
		
		Consumer<Integer> factorial = (number)->{
			int fact = 1;
			for(int i = 1 ; i <= number ; i++) {
				
				fact *= i;
			}
			System.out.println(fact);
		};
		
		factorial.accept(num);
	}
}
