package com.tss.factory.CarApp.test;

import com.tss.factory.CarApp.model.CarFactory;
import com.tss.factory.CarApp.model.CarTypes;
import com.tss.factory.CarApp.model.Icars;

public class CarTest {
	public static void main(String[] args) {
		CarFactory factory = new CarFactory();
		
		CarTypes car = CarTypes.Mahindra;
		
		Icars cars = factory.makeCars(car);
		
		if(cars == null) {
			System.out.println("cars is null");
		}
		else {
			cars.start();
			cars.stop();
		}
		
	
	}
}
