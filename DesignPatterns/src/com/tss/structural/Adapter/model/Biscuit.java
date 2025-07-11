package com.tss.structural.Adapter.model;

public class Biscuit implements Iitems{
	
	private String name ;
	private int price ;

	public Biscuit(String name , int price) {
		this.name = name;
		this.price = price;
	}


	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
}
