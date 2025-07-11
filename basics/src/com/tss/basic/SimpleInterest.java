package com.tss.basic;

import java.util.Scanner;

public class SimpleInterest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("enter prinicple : ");
		float principle = sc.nextFloat();
		
		System.out.print("enter Rare of interest : ");
		float rate = sc.nextFloat();
		
		System.out.print("enter Number of years : ");
		float year = sc.nextFloat();
		
		float simpleInterest = (principle * rate * year)/100;
		
		System.out.print("Simple interest : " + simpleInterest );
	}

}
