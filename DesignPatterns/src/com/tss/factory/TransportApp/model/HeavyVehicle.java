package com.tss.factory.TransportApp.model;

import java.util.Random;

public class HeavyVehicle implements LicenceGenerator{
	
	@Override
	public String LicenceGenerator() {
		Random random = new Random();

		String mw = "Hv";
		Integer sixDigit = 100000 + random.nextInt(900000); 
		mw += sixDigit.toString();
		System.out.println("6-digit number: " + mw);        
        
		return mw;
	}
}
