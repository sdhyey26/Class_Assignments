package com.tss.factory.CarApp.model;

public class CarFactory {
	public Icars makeCars(CarTypes car) {
		
		
		if(car ==  CarTypes.Mahindra) {
			return new Mahindra();
		}
		else if(car ==  CarTypes.Maruti) {
			return new Maruti();
		}
		else if(car == CarTypes.Tata) {
			return new Tata();
		}
		else
			return null;
		
	}
}
