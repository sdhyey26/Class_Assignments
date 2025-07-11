package com.tss.model.inhertitance.model;

public class ElectricCarModel extends CarModel {
	public int getBatteryLevel() {
		return batteryLevel;
	}

	public void setBatteryLevel(int batteryLevel) {
		this.batteryLevel = batteryLevel;
	}

	public ElectricCarModel(String year, int price, String model, int numberOfDoors, int batteryLevel) {
		super(year, price, model, numberOfDoors);
		this.batteryLevel = batteryLevel;
	}
	
	public ElectricCarModel() {;
	}
	
	public void displayBatteryStatus() {
		System.out.println("current battery status : " + getBatteryLevel());
	}
	
	public void chargeBattery() {
		System.out.println("The battery is charging !!");
	}
	

	private int batteryLevel;
	
}
