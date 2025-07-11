package com.tss.model.inhertitance.model;

public class CarModel extends VehicleModel{
	private int numberOfDoors ;

	
	public int getNumberOfDoors() {
		return numberOfDoors;
	}

	public void setNumberOfDoors(int numberOfDoors) {
		this.numberOfDoors = numberOfDoors;
	}

	
	
	public CarModel(String year, int price, String model, int numberOfDoors) {
		super(year, price, model);
		this.numberOfDoors = numberOfDoors;
	}
	

	public CarModel() {
		
	}
	
	public void lockDoors() {
		System.out.println("Door has locked !!");
	}
	
	public void unlockDoors() {
		System.out.println("Door has unlocked !!");
	}
	
	public void displayCarModel() {
		System.out.println("number of doors : " + getNumberOfDoors());
	}
	
}
