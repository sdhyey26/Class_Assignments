package com.tss.nonViolation.test;

import com.tss.nonViolation.model.DbLogger2;
import com.tss.nonViolation.model.ILogger;
import com.tss.nonViolation.model.TaxCalculator2;

public class TaxTest2 {
	public static void main(String[] args) {
		ILogger logger = new DbLogger2();
		TaxCalculator2 calculator = new TaxCalculator2(logger);
		int tax = calculator.calculateTax(1000, 2);
		System.out.println("calculated tax is : " + tax);
	}
}