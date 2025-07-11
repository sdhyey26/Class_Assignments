package com.tss.basic.selectionstatement;

import java.util.Scanner;

public class RideCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter your height in cms : ");
		int height = sc.nextInt();

		if (height > 120) {
			System.out.println("You can ride but firt enter your age : ");
			int age = sc.nextInt();

			if (age < 12) {
				int cost = 5;
				System.out.println("If you want photo enter your choice : ");

				String choice = sc.next();
				if (choice.equalsIgnoreCase("yes")) {
					cost = cost + 3;
					System.out.println("you will have to pay : " + cost + "$");
				} else {
					System.out.println("you will have to pay : " + cost + "$");
				}
			}
			if (age == 12 && age < 18) {
				int cost = 7;
				System.out.println("If you want photo enter your choice : ");

				String choice = sc.next();
				if (choice.equalsIgnoreCase("yes")) {
					cost = cost + 3;
					System.out.println("you will have to pay : " + cost + "$");
				} else {
					System.out.println("you will have to pay : " + cost + "$");
				}
			}

			if (age >= 18 && age < 45) {
				int cost = 12;
				System.out.println("If you want photo enter your choice : ");

				String choice = sc.next();
				if (choice.equalsIgnoreCase("yes")) {
					cost = cost + 3;
					System.out.println("you will have to pay : " + cost + "$");
				} else {
					System.out.println("you will have to pay : " + cost + "$");
				}
			}

			if (age >= 45 && age <= 55) {
				int cost = 0;
				System.out.println("Do you want to add photos : ");
				String choice = sc.next();

				if (choice.equals("yes")) {
					cost = cost + 3;
					System.out.println("you will have to pay : " + cost + "$");
				} else {
					System.out.println("you will have to pay : " + cost + "$");
				}
			}
			if (age > 55) {
				int cost = 12;
				System.out.println("you will have to pay : " + cost + "$");
			}
		} else {
			System.out.println("Sorry you cant drive !!");
		}
	}
}
