package com.tss.model.inhertitance.model;

import java.util.Scanner;

public class Rectangle implements IShape{

	@Override
	public  void area() {
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.println("enter length : ");
		int length = sc.nextInt() ;
		System.out.println("enter breadth : ");
		int breadth = sc.nextInt();
		
		int area = length * breadth;
		
		System.out.println("Area of rectangle : " + length * breadth);
	}

}
