package com.tss.model;

public class ElectricityBillApp {
	
	
	public int getApartmentNumber() {
		return apartmentNumber;
	}
	public void setApartmentNumber(int apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}
	public double getUnitConsumed() {
		return unitConsumed;
	}
	public void setUnitConsumed(int unitConsumed) {
		this.unitConsumed = unitConsumed;
	}
	public static double getCostPerUnit() {
		return costPerUnit;
	}
	public static void setCostPerUnit(double costPerUnit2) {
		ElectricityBillApp.costPerUnit = costPerUnit2;
	}
	
	public ElectricityBillApp() {
		super();
		costPerUnit = 7.5;
	}
	
	private double unitConsumed ;
	private double setUnitConsumed;
	private static double costPerUnit ;
	private int apartmentNumber;

	public double billAmount() {
		double total = unitConsumed * costPerUnit;
		return total;
	}
	
	public static void change(int amount) {
		setCostPerUnit(costPerUnit);
	}
	
	public void display() {
		System.out.println("apartment number : " + getApartmentNumber());
		System.out.println("unitConsumed : " + getUnitConsumed());
		System.out.println("cost per unit : " + getCostPerUnit());
		System.out.println("cost per unit : " + billAmount());
	}
}
