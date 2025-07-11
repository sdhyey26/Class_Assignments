package com.tss.factory.TransportApp.model;

import java.util.Random;

public class FourWheeler implements LicenceGenerator{
	@Override
	public String LicenceGenerator() {
		Random random = new Random();

		String mw = "FW";
        Integer fourDigit = 1000 + random.nextInt(9000); 
        mw += fourDigit.toString();
        System.out.println("The number for two wheeler" + "4-digit number: " + mw);
        
        

        
//        int sixDigit = 100000 + random.nextInt(900000); 
//        System.out.println("6-digit number: " + sixDigit);
		
		return mw;
	}
}
