package com.tss.structural.Adapter.model;

public class Hat {
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getLongName() {
		return LongName;
	}
	public Hat(String shortName, String longName, int price) {
		super();
		this.shortName = shortName;
		this.LongName = longName;
		this.price = price;
	}
	public Hat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setLongName(String longName) {
		LongName = longName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	private String shortName ;
	private String LongName ;
	private int price ;
	
	
}
