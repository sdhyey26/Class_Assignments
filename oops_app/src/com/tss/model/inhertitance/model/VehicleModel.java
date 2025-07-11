package com.tss.model.inhertitance.model;

public class VehicleModel {
	
	private int price ;
	private String model;
	private String year;
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public VehicleModel(String year, int price, String model) {
		super();
		this.year = year;
		this.price = price;
		this.model = model;
	}
	
	public VehicleModel() {
	}
	
	public void startEngine() {
		System.out.println("Engine has started !!");
	}
	
	public void stopEngine() {
		System.out.println("Engine has stopped !!");
	}
	
	public void displayInfo() {
		System.out.println("price : " + getPrice());
		System.out.println("model : " + getModel());
		System.out.println("year : " + getYear());

	}
}
