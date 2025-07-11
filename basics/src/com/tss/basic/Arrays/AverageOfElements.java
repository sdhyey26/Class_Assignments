package com.tss.basic.Arrays;

import java.util.Scanner;

public class AverageOfElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("enter the size of a array : ");
		int size = scanner.nextInt();
		
		int array[] = new int[size];
		
		System.out.println("enter array elements : ");
		
		for(int i = 0 ; i < array.length ; i++) {
			array[i] = scanner.nextInt();
		}
		
		average(array , size);
	}
	
	private static void average(int array[] , int size) {
		
		int sum = 0;
		for(int i = 0 ; i < array.length ; i++) {
			sum = sum+array[i];
		}
		
		int average = sum / size;
		System.out.println("The average of the numbers in the array : " + average);
	}

}
