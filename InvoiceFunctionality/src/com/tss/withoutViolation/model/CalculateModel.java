package com.tss.withoutViolation.model;

public class CalculateModel {
	

	 	public static double calculateTax(InvoiceModel invoice) {
		 
	        return (invoice.getCost() * invoice.getTax()) / 100;
	    }
	 
	    public static double calculateDiscount(InvoiceModel invoice) {

	        return (invoice.getCost() * invoice.getDiscountPercent()) / 100;
	    }
	    
	    public static double calculateFinalCost(InvoiceModel invoice) {
	        return invoice.getCost() - calculateDiscount(invoice) + calculateTax(invoice);
	    }
}
