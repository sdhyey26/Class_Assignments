package com.tss.structural.Adapter.test;

import java.util.ArrayList;
import java.util.Scanner;

import com.tss.structural.Adapter.model.Biscuit;
import com.tss.structural.Adapter.model.CartItems;
import com.tss.structural.Adapter.model.Chocolate;
import com.tss.structural.Adapter.model.Hat;
import com.tss.structural.Adapter.model.HatAdapter;
import com.tss.structural.Adapter.model.Iitems;

public class Test {
	public static void main(String[] args) {
		System.out.println("Enter the things you wanted to add : 1.biscuit 2.chocolate 3.hat 4.Exit");

		Scanner sc = new Scanner(System.in);

		CartItems list = new CartItems();
		ArrayList<Iitems> items = new ArrayList<>();

		boolean isTrue = true;
		while (isTrue) {
			
			System.out.println("enter the choice : ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1: {
				Iitems biscuit = new Biscuit("Oreo", 10);
				items.add(biscuit);
			}break;
				

			case 2: {
				Iitems chocolate = new Chocolate("Dairy Milk", 10);
				items.add(chocolate);

			}break;
				

			case 3: {
				Hat hat = new Hat("hugo", "boss", 100);
				HatAdapter getHat = new HatAdapter(hat);
				items.add(getHat);
			}
				break;

			case 4:
				isTrue = false;
		}
		
		
		
		
		
	}
		CartItems cart = new CartItems();
		cart.setItems(items);
		for(Iitems item : cart.getItems()) {
			System.out.println(item.getName());
			System.out.println(item.getPrice());
		}
}
}
