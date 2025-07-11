package com.tss.NonViolation.model;

import com.tss.NonViolation.Interface.Ipay;

public class CreditCard implements Ipay{

	@Override
	public void pay(int amount) {
		// TODO Auto-generated method stub
		System.out.println("Payment succesfull via credit card : "  + amount);
	}

}
