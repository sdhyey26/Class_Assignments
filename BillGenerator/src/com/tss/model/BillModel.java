package com.tss.model;

public class BillModel {
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}
	public double getTax() {
		return tax;
	}
	
	private double finalAmount;
	public double getFinalAmount() {
		return finalAmount;
	}
	public void setFinalAmount(double finalAmount) {
		this.finalAmount = finalAmount;
	}

	private String itemName;
	private double basePrice;
	private double  tax = basePrice + (basePrice*18)/100;
	public BillModel(String itemName, double basePrice , double finalAmount ) {
		super();
		this.itemName = itemName;
		this.basePrice = basePrice;
		this.finalAmount = finalAmount;
	}
	@Override
	public String toString() {
		return "BillModel [finalAmount=" + finalAmount + ", itemName=" + itemName + ", basePrice=" + basePrice
				+ ", tax=" + tax + "]";
	}
	
	
	
}
