package com.tss.basic.selectionstatement;

import java.util.Scanner;

public class waterBill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter No of units consumed : ");
		int unit_consumed = sc.nextInt();
		calculateCharge(unit_consumed);
	}
	
	private static void calculateCharge(int unit_consumed) {
		int meter_charge = 75;
		int totalWaterBIll;
		
		if(unit_consumed <= 100) {
			int charge = unit_consumed*5;
			totalWaterBIll = charge + meter_charge;
			System.out.println("Total water bill : " + totalWaterBIll);
		}
		else {
			if(unit_consumed <= 250) {
				int charge = unit_consumed*10;
				totalWaterBIll = charge + meter_charge;
				System.out.println("Total water bill : " + totalWaterBIll);
			}
			else {
				int charge = unit_consumed*20;
				totalWaterBIll = charge + meter_charge;
				System.out.println("Total water bill : " + totalWaterBIll);
			}
		}
	}
	
}
