package com.tss.NonViolation.test;

import java.util.Scanner;

import com.tss.NonViolation.Interface.Ipay;
import com.tss.NonViolation.model.CreditCard;
import com.tss.NonViolation.model.ShoppingKart;
import com.tss.NonViolation.model.Upi;

public class IpayTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("select the options you wanna pay with !!");
		
		System.out.println("credit cardc(c) / Upi(u)");
		String choice = sc.next();

		System.out.println("enter the amount : ");
		int amount = sc.nextInt();
		
		
		if(choice.equals("c")) {
			Ipay options = new CreditCard();
			ShoppingKart s = new ShoppingKart();
			s.checkOut(options, amount);
		}
		if(choice.equals("u")) {
			Ipay options = new Upi();
			ShoppingKart s = new ShoppingKart();
			s.checkOut(options, amount);
		}
		
		
	}
}
