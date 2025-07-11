package com.tss.basic.Arrays;

import java.util.Scanner;

public class SearchNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		System.out.println("enter the size of a array : ");
		int size = scanner.nextInt();
		int sum = 0;
		int array[] = new int[size];
		boolean isFound = true;
		
		System.out.print("Enter a number to be searched : ");
		int searchNum = scanner.nextInt();

		System.out.print("enter array elements : ");

		for (int i = 0; i < array.length; i++) {
			array[i] = scanner.nextInt();
		}
		
		for (int i = 0; i < array.length; i++) {
			if(searchNum == array[i]) {
				System.out.println("The number found at index : " + i);
			}
			else {
				isFound = false;
			}
		}
		
		if(!isFound) {
			System.out.println("The number is not present in the array !!");
		}
	}
}
