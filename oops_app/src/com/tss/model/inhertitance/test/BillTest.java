package com.tss.model.inhertitance.test;

import java.util.Scanner;

import com.tss.model.inhertitance.model.CreditCard;
import com.tss.model.inhertitance.model.DebitCard;
import com.tss.model.inhertitance.model.Paypal;
import com.tss.model.inhertitance.model.UpiMethod;

public class BillTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your choice for payment!!");
		
		boolean isTrue = true;
		
		System.out.println("Enter amount to be paid : ");
		int amount = sc.nextInt();
		
		System.out.println("1.Credit card");
		System.out.println("2.Debit card");
		System.out.println("3.UPI");
		System.out.println("4.PayPal");
		System.out.println("5.Exit");
		
		while(isTrue) {
			System.out.println("Enter your choice : ");
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1 : {
				CreditCard creditCard = new CreditCard();
				creditCard.payment(amount);
			}break;
			
			case 2 : {
				DebitCard debitCard = new DebitCard();
				debitCard.payment(amount);
			}break;
			
			case 3 : {
				UpiMethod upi = new UpiMethod();
				upi.payment(amount);
			}break;
			
			case 4 : {
				Paypal paypal = new Paypal();
				paypal.payment(amount);
			}break;
			
			case 5 : {
				isTrue = false;
			}
			}
			
		}
		
	}

}
