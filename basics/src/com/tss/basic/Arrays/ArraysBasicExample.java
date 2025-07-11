package com.tss.basic.Arrays;

import java.util.Scanner;

public class ArraysBasicExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter elements of a Array : ");
		int array[] = new int[5];
		
		for(int i = 0 ; i<5 ; i++) {
			array[i] = scanner.nextInt();
		}
		
		for(int i = 0 ; i<5 ; i++) {
			System.out.print(" " + array[i]);
		}
		
	}

}
