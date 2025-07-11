package com.tss.model.inhertitance.model;

public class TruckRent extends VehicleRentalModel {

	@Override
	public void totalRent() {
		// TODO Auto-generated method stub
		int rent1 = (getNumberOfDays() * getRentPerDay()) + 500;
		System.out.println("The amount of rent of the truck is : " + rent1);
	}
	
	public String display() {
		return "VehicleRentalModel [vehicleNumber=" + getVehicleNumber() + ", rentPerDay=" + getRentPerDay() + ", fuelType="
				+ getFuelType() + ", numberOfDays=" + getNumberOfDays() + "]";
	}

}
