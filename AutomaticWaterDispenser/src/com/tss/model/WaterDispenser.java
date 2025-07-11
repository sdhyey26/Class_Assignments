package com.tss.model;

public class WaterDispenser {
	public static int maxCapacity = 100;
	
	public int getCurrentCapacity() {
		return currentCapacity;
	}

	public void setCurrentCapacity(int currentCapacity) {
		this.currentCapacity = currentCapacity;
	}

	public int currentCapacity;
	
}
