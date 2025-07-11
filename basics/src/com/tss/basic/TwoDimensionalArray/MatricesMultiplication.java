package com.tss.basic.TwoDimensionalArray;

import java.util.Scanner;

public class MatricesMultiplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int array1[][] = new int[3][3];
		int array2[][] = new int[3][3];
		int resultArray[][] = new int[3][3];
		
		System.out.println("enter elements for matrice 1 : ");
		for(int i = 0 ; i < 3 ; i++) {
			for(int j = 0 ; j < 3 ; j++) {
				array1[i][j] = sc.nextInt();
			}
		}
		
		System.out.println("enter elements for matrice 2 : ");
		for(int i = 0 ; i < 3 ; i++) {
			for(int j = 0 ; j < 3 ; j++) {
				array2[i][j] = sc.nextInt();
			}
		}
		
		System.out.println("Enter the resultant matrix : ");
		
		for(int i = 0 ; i < 3 ; i++) {
			for(int j = 0 ; j < 3 ; j++) {
				for(int k = 0 ; k < 3 ; k++) {
					resultArray[i][j] += array1[i][k] * array2[k][j];
				}
			}
		}
		
		for(int i = 0 ; i < 3 ; i++) {
			for(int j = 0 ; j < 3 ; j++) {
				System.out.print(resultArray[i][j] + "\t");;
			}
			System.out.println();
		}
	}

}
