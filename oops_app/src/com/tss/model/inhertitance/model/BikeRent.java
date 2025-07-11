package com.tss.model.inhertitance.model;

public class BikeRent extends VehicleRentalModel {

	@Override
	public void totalRent() {
		// TODO Auto-generated method stub
		if(getNumberOfDays() > 5) {
			float rent1 = (float) (getNumberOfDays() * getRentPerDay() * 0.9);
			System.out.println("The discounted price of bike rented : " + rent1);
		}
		else {
			float rent1 = getNumberOfDays() * getRentPerDay();
			System.out.println("The price of bike rented : " + rent1);

		}
	}
	
	public String display() {
		return "VehicleRentalModel [vehicleNumber=" + getVehicleNumber() + ", rentPerDay=" + getRentPerDay() + ", fuelType="
				+ getFuelType() + ", numberOfDays=" + getNumberOfDays() + "]";
	}

}
