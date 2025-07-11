package com.tss.test;

import java.util.Scanner;

import com.tss.Exceptions.InsufficientLimitException;
import com.tss.Exceptions.MaxLimitExceedException;
import com.tss.model.WaterDispenseFiller;
import com.tss.model.WaterDispenser;

public class WaterDispenserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.println("welcome to the water dispenser automation system !!");

		WaterDispenseFiller dispenseFIller = new WaterDispenseFiller();


		System.out.println("1.Fill Water");
		System.out.println("2.Dispense water");
		System.out.println("3.Exit");

		boolean isTrue = true;
		while (isTrue) {
			System.out.println("Enter your choice : ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1: {
				try {
					dispenseFIller.fillWater();
				}
				catch(MaxLimitExceedException exception){
					System.out.println(exception);
				}
				finally {
					System.out.println("the current water level is : " + dispenseFIller.getCurrentCapacity());
				}
			}break;
			
			case 2: {
				try {
					dispenseFIller.dispenseWater();
				}
				catch(InsufficientLimitException exception){
					System.out.println(exception);
				}
				finally {
					System.out.println("the current water level is : " + dispenseFIller.getCurrentCapacity());
				}
			}break;
			
			case 3: {
				System.out.println("Thank you for using our system , visit again !!");
				isTrue = false;
			}

			}

		}

	}

}
