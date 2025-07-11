package com.tss.model.inhertitance.model;

public class CarRent extends VehicleRentalModel{

	@Override
	public void totalRent() {
		// TODO Auto-generated method stub
		int rent1 = getNumberOfDays() * getRentPerDay();
		System.out.println("the total rent of the car is : " + rent1);
	}

	public String display() {
		return "VehicleRentalModel [vehicleNumber=" + getVehicleNumber() + ", rentPerDay=" + getRentPerDay() + ", fuelType="
				+ getFuelType() + ", numberOfDays=" + getNumberOfDays() + "]";
	}
}
