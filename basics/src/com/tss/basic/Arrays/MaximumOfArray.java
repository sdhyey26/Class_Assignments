package com.tss.basic.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MaximumOfArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> arraylist = new ArrayList<Integer>(); 

		System.out.println("enter the size of a array : ");
		int size = scanner.nextInt();
		int sum = 0;
		int array[] = new int[size];

		System.out.println("enter array elements : ");

		for (int i = 0; i < array.length; i++) {
			array[i] = scanner.nextInt();
			arraylist.add(array[i]);
		}
		
		Collections.sort(arraylist);
		
		System.out.println("the maximum element is : " + arraylist.getLast());
		
	}

}
