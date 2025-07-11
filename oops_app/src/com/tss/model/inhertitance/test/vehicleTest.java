package com.tss.model.inhertitance.test;

import java.util.Scanner;

import com.tss.model.inhertitance.model.ElectricCarModel;

public class vehicleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		//String year, int price, String model, int numberOfDoors, int batteryLevel
		System.out.println("Enter year : ");
		String year = sc.next();
		
		System.out.println("Enter Price : ");
		int price = sc.nextInt();
		
		System.out.println("Enter car model : ");
		String model = sc.next();
		
		System.out.println("enter number of doors : ");
		int numberOfDoors = sc.nextInt();
		
		System.out.println("Enter battery level : ");
		int batteryLevel = sc.nextInt();
		
		ElectricCarModel vehicle = new ElectricCarModel(year , price , model , numberOfDoors , batteryLevel);
		
		vehicle.displayCarModel();
		vehicle.displayInfo();
		vehicle.lockDoors();
		vehicle.unlockDoors();
		vehicle.chargeBattery();
		vehicle.getBatteryLevel();
		
	}

}
