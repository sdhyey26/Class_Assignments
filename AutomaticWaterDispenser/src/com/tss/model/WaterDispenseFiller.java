package com.tss.model;

import java.util.Scanner;

import com.tss.Exceptions.InsufficientLimitException;
import com.tss.Exceptions.MaxLimitExceedException;

public class WaterDispenseFiller extends WaterDispenser {
	
	int currentLevel;
	
	
	public WaterDispenseFiller() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter current level : ");
		currentLevel = sc.nextInt();

		if(currentLevel > maxCapacity) {
			throw new MaxLimitExceedException(currentLevel);

		}
		else
			setCurrentCapacity(currentLevel);
	}
	
	
	public void dispenseWater() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("The current water level is (Dont exceed the maxcapacity) : " + getCurrentCapacity());

		
		System.out.println("Enter the amount to be dispense (in literes) : ");
		int amount = sc.nextInt();
		
		if(amount > getCurrentCapacity()) {
			throw new InsufficientLimitException( amount);
		}
		else if(amount < 0) {
			System.out.println("negative values are not allowed re-enter ");
		}
		else {
			System.out.println("successfully dispensed : ");
			setCurrentCapacity(getCurrentCapacity() - amount);
		}
	}
	
	public void fillWater() {
		Scanner sc = new Scanner(System.in);
		System.out.println("The current water level is  : " + getCurrentCapacity());
		
		System.out.println("Enter the amount to be filled (Dont exceed the maxcapacity): ");
		int amount = sc.nextInt();
		
		if(amount > maxCapacity) {
			throw new MaxLimitExceedException(amount);
		}
		else if(getCurrentCapacity() + amount > maxCapacity) {
			throw new MaxLimitExceedException( amount);		}
		else {
			System.out.println("water level increased by : " + amount);
			int total = currentCapacity + amount;
			setCurrentCapacity(total);
		}
	}
	
}
