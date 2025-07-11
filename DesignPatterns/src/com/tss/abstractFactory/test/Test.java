package com.tss.abstractFactory.test;

import java.util.Scanner;

import com.tss.abstractFactory.model.Icars;
import com.tss.abstractFactory.model.MarutiFactory;
import com.tss.abstractFactory.model.*;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your choice : 1.Maruti 2.Mahindra 3.Tata");
		
		int choice = sc.nextInt();
		Icars car = null;
		
		if(choice == 1) {
			ICarFactory maruti = new MarutiFactory();
			 car = maruti.makeCar();
			 car.start();
			 car.stop();
		}
		else if(choice == 2) {
			ICarFactory mahindra = new MarutiFactory();
			 car = mahindra.makeCar();
			 car.start();
			 car.stop();
		}
		else if(choice == 3) {
			ICarFactory Tata = new TataFactory();
			 car = Tata.makeCar();
			 car.start();
			 car.stop();
		}
		else {
			System.out.println("Enter valid choice");
		}
		
	}
}
