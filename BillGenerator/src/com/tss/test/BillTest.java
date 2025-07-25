package com.tss.test;

import java.util.function.Consumer;
import java.util.function.Supplier;

import com.tss.model.BillModel;


public class BillTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double finalAmount = 45000;
		BillModel items = new BillModel("laptop", 45000 , finalAmount);
		
		Supplier<BillModel> addedTax = ()->{
			double shippingprice = 1200;
			items.setFinalAmount(finalAmount + shippingprice);
			return items;
		};
		
		Consumer<BillModel> printBill = (item)->{
			System.out.println(item.toString());
		};
		
		printBill.accept(addedTax.get());
		
	}

}
