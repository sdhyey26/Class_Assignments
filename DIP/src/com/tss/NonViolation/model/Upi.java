package com.tss.NonViolation.model;

import com.tss.NonViolation.Interface.Ipay;

public class Upi implements Ipay {

	@Override
	public void pay(int amount) {
		// TODO Auto-generated method stub
		System.out.println("payment succesfull via UPI : " + amount);
	}

}
