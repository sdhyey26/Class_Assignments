package com.tss.structural.decorative.model;

public class Both extends CarServiceDecorator {

	public double bothCost() {
	
		OilChange oil = new OilChange();
		wheelAlign wheel = new wheelAlign();
		
		return oil.getCost() + wheel.getCost() + getCost();
				
	}
}
