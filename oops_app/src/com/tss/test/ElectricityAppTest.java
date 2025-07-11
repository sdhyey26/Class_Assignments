package com.tss.test;

import java.util.Scanner;

import com.tss.model.ElectricityBillApp;

public class ElectricityAppTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the number of bills to be generated : ");
		int number = sc.nextInt();

		ElectricityBillApp bill[] = new ElectricityBillApp[number];
		ElectricityBillApp bill1 = new ElectricityBillApp();

		for (int i = 0; i < number; i++) {
			bill[i] = new ElectricityBillApp();
			readValue(bill[i], sc, i);
		}

		System.out.println("1.Display Bill ");
		System.out.println("2.price change request by government authority only ");
		System.out.println("3.Exit ");

		boolean isTrue = true;
		while (isTrue) {
			System.out.print("enter your choice : ");
			int choice = sc.nextInt();

			switch (choice) {

			case 1: {
				System.out.println("enter the particular aprtment number starting from first : ");
				int apartmentNum = sc.nextInt();

				for (int i = 0; i < number; i++) {
					if (bill[i].getApartmentNumber() == apartmentNum) {
						bill[i].display();
					}
				}
			}
				break;

			case 2: {
				System.out.println("enter the amount to be changed : ");
				int amount = sc.nextInt();

				System.out.println("previous price : " + ElectricityBillApp.getCostPerUnit());
				ElectricityBillApp.setCostPerUnit(amount);
				System.out.println("after change : "+ ElectricityBillApp.getCostPerUnit());
			}
				break;

			case 3:
				isTrue = false;
			}
		}

	}

	public static void readValue(ElectricityBillApp bill, Scanner sc, int i) {
		System.out.print("please enter the units consumed : ");
		int unitConsumed = sc.nextInt();
		bill.setUnitConsumed(unitConsumed);
		bill.setApartmentNumber(i + 1);
	}
}
