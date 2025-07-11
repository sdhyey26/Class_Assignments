package com.tss.basic;

import java.util.Scanner;

public class AreaCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the radius : ");
		float radius = sc.nextFloat();
		
		double area = 3.14*radius*radius;
		
		System.out.print("area : " + area);
	}

}