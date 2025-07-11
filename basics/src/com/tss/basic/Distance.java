package com.tss.basic;
import java.math.*;
import java.util.Scanner;

public class Distance {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter X1 : ");
		int x1 = sc.nextInt();
		
		System.out.println("Enter X2 : ");
		int x2 = sc.nextInt();
		
		System.out.println("Enter Y1 : ");
		int y1 = sc.nextInt();
		
		System.out.println("Enter Y2 : ");
		int y2 = sc.nextInt();

		double distance = Math.sqrt(Math.pow((x2-x1),2) + Math.pow((y2-y1),2));
		
		System.out.print("Distance between two points : " + distance);
	}
}
