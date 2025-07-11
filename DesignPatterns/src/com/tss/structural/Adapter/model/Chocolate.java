package com.tss.structural.Adapter.model;

public class Chocolate implements Iitems{

	
	private String name ;
	public Chocolate(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	private int price ;

	


	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}

}
