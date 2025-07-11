package com.tss.structural.facade.test;

import java.util.Scanner;

import com.tss.structural.facade.model.HotelReception;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter your choice : 1.Indian menu 2.Italain menu");
		Scanner sc = new Scanner(System.in);
		
		int choice = sc.nextInt();
		
		switch(choice) {
		case 1 : 
		{
			HotelReception hotel = new HotelReception();
			hotel.getIndianMenu();
		}break;
		
		case 2 : 
		{
			HotelReception hotel = new HotelReception();
			hotel.getItalianMenu();
		}break;
		}
	}

}
