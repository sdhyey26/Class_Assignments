package com.tss.withoutViolation.model;

public class PrintBill {
	public static void printBill(InvoiceModel invoice) {
		
		CalculateModel calculateModel = new CalculateModel();
	
		
	    double discountAmount = calculateModel.calculateDiscount(invoice);
	    double taxAmount = calculateModel.calculateTax(invoice);
	    double finalAmount = calculateModel.calculateFinalCost(invoice);

	    System.out.println("\n===== INVOICE =====");
	    System.out.println("ID: " + invoice.getId());
	    System.out.println("Description: " + invoice.getDescription());
	    System.out.printf("Base Cost: %.2f\n", invoice.getCost());
	    System.out.printf("Discount (%.1f%%): -%.2f\n", invoice.getDiscountPercent(), discountAmount);
	    System.out.printf("Tax (%.1f%%): +%.2f\n", invoice.getTax(), taxAmount);
	    System.out.println("---------------------------");
	    System.out.printf("Final Amount: %.2f\n", finalAmount);
	    System.out.println("=====================");
	}
	

}

