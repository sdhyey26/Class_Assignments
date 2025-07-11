package com.tss.model.inhertitance.test;

import java.util.Scanner;

import com.tss.model.inhertitance.model.BikeRent;
import com.tss.model.inhertitance.model.CarRent;
import com.tss.model.inhertitance.model.TruckRent;
import com.tss.model.inhertitance.model.VehicleRentalModel;


public class VehicleRentalTest {

	public static void main(String[] args) {

//		private int vehicleNumber;
//		private int rentPerDay;
//		private String fuelType;

		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		CarRent car = new CarRent();
		BikeRent bike = new BikeRent();
		TruckRent truck = new TruckRent();

		System.out.println("please choose what you want to rent : 1.Car 2.bike 3.Truck");
		System.out.println("enter your choice : ");
		int choice = sc.nextInt();
		
		System.out.print("vehicleNumber : ");
		int vehicleNumber = sc.nextInt();
		System.out.print("rentPerDay : ");
		int rentPerDay = sc.nextInt();
		System.out.print("fuelType : ");
		String fuelType = sc.next();
		System.out.print("Enter number of days : ");
		int numberOfDays = sc.nextInt();

		System.out.println("1.display all details");
		System.out.println("2.display total rent to be paid : ");
		System.out.println("3.Exit");
		
		boolean isTrue = true;
		
		while(isTrue) {
			System.out.println("enter your choice : ");
			int choice1 = sc.nextInt();
			
			switch(choice1) {
			
			case 1 : {
				if(choice == 1) {
					car.setFuelType(fuelType);
					car.setNumberOfDays(numberOfDays);
					car.setRentPerDay(rentPerDay);
					car.setVehicleNumber(vehicleNumber);
					System.out.println(car.display());					
				}
				if(choice == 2) {
					bike.setFuelType(fuelType);
					bike.setNumberOfDays(numberOfDays);
					bike.setRentPerDay(rentPerDay);
					bike.setVehicleNumber(vehicleNumber);
					System.out.println(bike.display());
					
				}
				if(choice == 3) {
					truck.setFuelType(fuelType);
					truck.setNumberOfDays(numberOfDays);
					truck.setRentPerDay(rentPerDay);
					truck.setVehicleNumber(vehicleNumber);
					System.out.println(truck.display());
				}
			}break;
			
			case 2 :
			{
				if(choice == 1) {
					
					car.totalRent();
				}
				if(choice == 2) {
					
					bike.totalRent();
				}
				if(choice == 3) {
				
					truck.totalRent();
				}
			}break;
			
			case 3 :
			{
				isTrue = false;
			}
			}
		}
	}

}
