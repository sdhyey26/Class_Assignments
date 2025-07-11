package com.tss.test;

import java.util.Scanner;

public class MatrixUsingIdentation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matrix[][] = new int[3][3];	
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter matrix elemetns : ");
		
		for(int i = 0 ; i < 3 ; i++) {
			readValue( sc , i , matrix);
		}
		
		for(int i = 0 ; i < 3 ; i++) {
			printMatrix(sc , i , matrix);
			System.out.println();
		}
	}
	
	public static void readValue(Scanner sc , int i , int[][] a ) {
		for(int j = 0 ; j < 3 ; j++) {
			a[i][j] = sc.nextInt();
		}
	}
	
	public static void printMatrix(Scanner sc , int i , int[][] a) {
		for(int j = 0 ; j < 3 ; j++) {
			System.out.print(a[i][j] + " "); 
		}
	}

}
