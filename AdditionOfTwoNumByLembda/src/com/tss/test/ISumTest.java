package com.tss.test;

import java.util.Scanner;

import com.tss.model.Isum;

public class ISumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Isum isum = ()->{
			Scanner sc = new Scanner(System.in);

			
			System.out.println("enter a : ");
			int a = sc.nextInt();
			
			System.out.println("enter b : ");
			int b = sc.nextInt();
			return a+b;
		};
		
		System.out.println("the sum of the given numbers : " + isum.sum()) ;
	}
	
	

}
