package com.tss.factory.TransportApp.test;

import java.util.Scanner;

import com.tss.factory.TransportApp.model.LicenceGenerator;
import com.tss.factory.TransportApp.model.VehicleFactory;
import com.tss.factory.TransportApp.model.VehicleType;

public class LicenceApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter your choice : 1.two wheeler 2.Four wheeler 3.Heavy vehicle ");
		int choice = sc.nextInt();
		
		LicenceGenerator licence = null ;
		
		if(choice == 1) {
			licence = VehicleFactory.getVehicle(VehicleType.Two_wheeler);
			licence.LicenceGenerator();
		}
		else if(choice == 2) {
			licence = VehicleFactory.getVehicle(VehicleType.Four_wheeler);
			licence.LicenceGenerator();
		}
		else if(choice == 3) {
			licence = VehicleFactory.getVehicle(VehicleType.Heavy_vehicle);
			licence.LicenceGenerator();
		}
		else {
			System.out.println("Enter valid choice!!");
		}
	}
}
