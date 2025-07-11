package com.tss.basic.TwoDimensionalArray;

import java.util.Scanner;

public class TwoDimensionalArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Array elements : ");
		
		int array[][] = new int[3][3];
		
		for(int i = 0 ; i < 3 ; i++) {
			for(int j = 0 ; j < 3 ; j++) {
				array[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0 ; i < 3 ; i++) {
			for(int j = 0 ; j < 3 ; j++) {
				System.out.print(array[i][j] + "\t");;
			}
			System.out.println();
		}
	}

}
