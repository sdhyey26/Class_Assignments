package com.tss.basic.iterative;

import java.util.Scanner;

public class PalindromeNumber {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in); 
		
		System.out.println("Enter a number : ");
		
		int number = sc.nextInt();
		
		String num = Integer.toString(number);
		String rev = "";
		int i = num.length()-1;
		while(i >= 0) {
			rev += num.charAt(i);
			i--;
		}
		
		if(rev.equals(num)) {
			System.out.println("Palindrome");
		}
		else {
			System.out.println("not a palindrome");
		}
	}
}
