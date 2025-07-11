package com.tss.basic.selectionstatement;

import java.util.Scanner;

public class diffCharges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc = new Scanner(System.in);
		
		System.out.println("enter No of units consumed : ");
		int unit_consumed = sc.nextInt();
		calculateCharge(unit_consumed);
	}
	
	private static void calculateCharge(int unit_consumed){
		int meter_charge = 75;
		int totalWaterBIll;
		
		if(unit_consumed <= 100) {
			int charge = unit_consumed*5;
			totalWaterBIll = charge + meter_charge;
			System.out.println("Total water bill : " + totalWaterBIll);
		}
		else {
			if(unit_consumed <= 250) {
				int remaining = unit_consumed - 100;
				int charge = remaining*5 + 100*10;
				totalWaterBIll = charge + meter_charge;
				System.out.println("Total water bill : " + totalWaterBIll);			
			}
			else {
				int remaining1 = unit_consumed - 250;
				if(remaining1 > 100) {
					int remaining2 = remaining1 - 100;
					int charge = remaining2*10 + remaining1*20 ;
					totalWaterBIll = charge + meter_charge;
					System.out.println("Total water bill : " + totalWaterBIll);
				}
				else {
					int charge = remaining1*20;
					totalWaterBIll = charge + meter_charge;
					System.out.println("Total water bill : " + totalWaterBIll);
				}
			}
		}
	}

}
