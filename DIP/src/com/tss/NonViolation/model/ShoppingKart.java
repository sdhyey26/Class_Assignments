package com.tss.NonViolation.model;

import com.tss.NonViolation.Interface.Ipay;

public class ShoppingKart {
	
	Ipay options ;
	
	public void checkOut(Ipay options , int amount) {
		this.options = options;
		
		this.options.pay(amount);
	}
}
