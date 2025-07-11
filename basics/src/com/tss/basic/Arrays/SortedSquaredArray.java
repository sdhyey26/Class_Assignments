package com.tss.basic.Arrays;

import java.util.Scanner;

public class SortedSquaredArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the size of array: ");
		int size = sc.nextInt();
		int array[] = new int[size];

		System.out.print("Enter sorted array elements (can include negatives): ");
		for (int i = 0; i < size; i++) {
			array[i] = sc.nextInt();
		}

		int[] squaredArray = new int[size];
		int left = 0;
		int right = size - 1;
		int index = size - 1;

		while (left <= right) {
			int leftSquare = array[left] * array[left];
			int rightSquare = array[right] * array[right];

			if (leftSquare > rightSquare) {
				squaredArray[index--] = leftSquare;
				left++;
			} else {
				squaredArray[index--] = rightSquare;
				right--;
			}
		}

		System.out.println("Sorted Squared Array:");
		for (int num : squaredArray) {
			System.out.print(num + " ");
		}

		sc.close();
	}
}
