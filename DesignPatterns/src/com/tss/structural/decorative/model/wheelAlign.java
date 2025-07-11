package com.tss.structural.decorative.model;

public class wheelAlign extends CarServiceDecorator{

	public double getWheelCost() {
		return getCost() + 600;
	}
}
