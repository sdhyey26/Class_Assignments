package com.tss.abstractFactory.model;

public class MarutiFactory implements ICarFactory {

	@Override
	public Icars makeCar() {
		// TODO Auto-generated method stub
		
		Icars maruti = new Maruti();
		
		return maruti;
	}

	
}
