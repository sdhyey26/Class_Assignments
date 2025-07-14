package com.tss.test;

import java.util.Scanner;

import com.tss.model.Admin;

public class Main {
	public static void main(String[] args) {
		System.out.println("Welcome to the Food delivery app!!");
		
		System.out.println("1.Admin login 2.Normal Login");
		
		Scanner sc = new Scanner(System.in);
		String choiceAdminOrNormal = sc.next();
		
		if(choiceAdminOrNormal.equals("1")) {
			System.out.println("Enter name : ");
			String adminName = sc.next();
			System.out.println("Enter password : ");
			String password = sc.next();
			Admin admin = new Admin();
			
			if(admin.getName().equals(adminName) && admin.getPassword().equals(password)) {
				System.out.println("Hello " + adminName + " Welcome !!");
				
				System.out.println("");
			}
			else {
				System.out.println("You entered wrong credentials !!");
			}
		}
		
	}
}
