package com.tss.model.inhertitance.model;

public abstract class VehicleRentalModel {
	private int vehicleNumber;
	private int rentPerDay;
	private String fuelType;
	

	private int numberOfDays;
	
	public int getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(int vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public int getRentPerDay() {
		return rentPerDay;
	}

	public void setRentPerDay(int rentPerDay) {
		this.rentPerDay = rentPerDay;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	
	public int getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

	public abstract void totalRent();
}
