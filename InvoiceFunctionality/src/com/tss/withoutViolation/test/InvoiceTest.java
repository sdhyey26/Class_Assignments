package com.tss.withoutViolation.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.tss.withoutViolation.model.InvoiceModel;
import com.tss.withoutViolation.model.PrintBill;

public class InvoiceTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintBill print = new PrintBill();
		int id;
		String description;
		double cost;
		double discountPercent;
		System.out.println("enter the number of account : ");
		int count = sc.nextInt();
		List<InvoiceModel> billList = new ArrayList<>();
		
		for(int i = 0 ; i < count ; i++) {
			System.out.println("Enter id : " );
			id = sc.nextInt();
			
			System.out.println("Enter Description : ");
			description = sc.next();
			
			System.out.println("Enter cost : ");
			cost = sc.nextDouble();
			
			System.out.println("Enter discount Percent : ");
			discountPercent= sc.nextDouble();
			
			InvoiceModel invoiceModel = new InvoiceModel(id , description , cost , discountPercent);
			billList.add(invoiceModel);
		}
		
		for(InvoiceModel invoice : billList ) {
			print.printBill(invoice);
		}
	}
}
