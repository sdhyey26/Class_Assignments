package com.tss.basic.TwoDimensionalArray;

import java.util.Scanner;

public class MatricesAddMultiplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int array1[][] = new int[3][3];
		int array2[][] = new int[3][3];
		int add[][] = new int[3][3];
		int mul[][] = new int[3][3];

		System.out.println("enter elements for matrice 1 : ");
		readMatrix1(array1, sc);

		System.out.println("enter elements for matrice 2 : ");
		readMatrix2(array2, sc);

		add = addition(array1, array2);
		mul = multiplication(array1, array2);

		System.out.println("Matrix Addition : ");
		printMatrix(add);
		System.out.println("Matrix Addition : ");
		printMatrix(mul);

	}

	public static int[][] addition(int array1[][], int array2[][]) {
		int resultArray[][] = new int[3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				resultArray[i][j] = array1[i][j] + array2[i][j];
			}
		}

		return resultArray;
	}

	public static int[][] multiplication(int array1[][], int array2[][]) {
		int resultArray[][] = new int[3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					resultArray[i][j] += array1[i][k] * array2[k][j];
				}
			}
		}

		return resultArray;
	}

	public static void readMatrix1(int array1[][], Scanner sc) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				array1[i][j] = sc.nextInt();
			}
		}
	}

	public static void readMatrix2(int array2[][], Scanner sc) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				array2[i][j] = sc.nextInt();
			}
		}
	}

	public static void printMatrix(int resultArray[][]) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(resultArray[i][j] + "\t");
				}
			System.out.println();
		}
	}

}
