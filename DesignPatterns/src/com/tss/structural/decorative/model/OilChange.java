package com.tss.structural.decorative.model;

public class OilChange extends CarServiceDecorator  {
	
	public double getCostOil() {
		// TODO Auto-generated method stub
		return 400 + getCost();
	}
}
