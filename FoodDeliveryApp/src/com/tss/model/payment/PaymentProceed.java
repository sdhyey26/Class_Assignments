package com.tss.model.payment;

import java.util.Scanner;
import java.util.regex.*;

import com.tss.exceptions.InvalidInputException;
import com.tss.model.DeliveryAgents.DeliveryAgent;

public class PaymentProceed {
	Scanner sc = new Scanner(System.in);
	PaymentMethods method;

	private String upi_id;
	private String upi_password;
	private String credit_card;
	private int cvv;

	public String getUpi_id() {
		return upi_id;
	}

	public void setUpi_id(String upi_id) {
		this.upi_id = upi_id;
	}

	public String getUpi_password() {
		return upi_password;
	}

	public void setUpi_password(String upi_password) {
		this.upi_password = upi_password;
	}

	public String getCredit_card() {
		return credit_card;
	}

	public void setCredit_card(String credit_card) {
		this.credit_card = credit_card;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public void setPayment(PaymentMethods method, String name, String Address, String agentName, int total ) {
		if (method == PaymentMethods.UPI) {
			System.out.print("Enter UPI ID: ");
			String upiId = sc.next();
			setUpi_id(upiId);

			if (!getUpi_id().contains("@")) {
				System.out.println("Payment failed: Invalid UPI ID format.");
				return;
			}

			System.out.print("Enter UPI Password: ");
			String upiPwd = sc.next();
			if (upiPwd.length() < 4) {
				System.out.println("Payment failed: UPI password must be at least 4 characters.");
				return;
			}
			setUpi_password(upiPwd);

			System.out.println("Payment of ₹" + total + " successful via UPI ID: " + getUpi_id());
			System.out.println("Your order will be delivered soon by: " + agentName + " to " + Address);
			System.out.println("Thanks for shopping, " + name + "!");
			System.exit(0);
		} else if (method == PaymentMethods.CREDIT_CARD) {
			System.out.print("Enter Credit Card Number (16 digits): ");
			String cardNumber = sc.next();
			if (!cardNumber.matches("\\d{16}")) {
				System.out.println("Payment failed: Credit card number must be 16 digits.");
				return;
			}
			setCredit_card(cardNumber);

			System.out.print("Enter CVV (3 digits): ");
			if (!sc.hasNextInt()) {
				System.out.println("Payment failed: Invalid CVV.");
				sc.next();
				return;
			}
			int cvvInput = sc.nextInt();
			if (cvvInput < 100 || cvvInput > 999) {
				System.out.println("Payment failed: CVV must be 3 digits.");
				return;
			}
			setCvv(cvvInput);

			System.out.println("Payment of ₹" + total + " successful via Credit Card ending with: " + getCredit_card().substring(12));
			System.out.println("Your order will be delivered soon by: " + agentName + " to " + Address);
			System.out.println("Thanks for shopping, " + name + "!");
			System.exit(0);
		} else {
			throw new InvalidInputException();
		}
	}
}

