package com.tss.structural.decorative.test;

import java.util.Scanner;

import com.tss.structural.decorative.model.Both;
import com.tss.structural.decorative.model.CarServiceDecorator;
import com.tss.structural.decorative.model.OilChange;
import com.tss.structural.decorative.model.wheelAlign;

public class test {

	public static void main(String[] args) {
		System.out.println("Enter the choice : 1.regular 2.oil change 3.wheel align 4.both 5.Exit");
		Scanner sc = new Scanner(System.in);
		int total = 0 ;
		boolean isTrue = true;
		
		while(isTrue) {
			System.out.println("enter choice : ");
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1 :
			{
				CarServiceDecorator normal = new CarServiceDecorator();
				System.out.println("regular : " + normal.getCost());
				total += normal.getCost();
			}break;
			
			case 2 :
			{
				OilChange oil = new OilChange();
				System.out.println("oil : "+ oil.getCostOil());
				total += oil.getCostOil();
			}break;
			
			case 3 :{
				wheelAlign wheel = new wheelAlign();
				System.out.println("Wheel align : " + wheel.getWheelCost());
				total += wheel.getWheelCost();
			}break;
				
			case 4 : {
				Both both = new Both();
				System.out.println("both : " + both.bothCost());
				total += both.bothCost();
			}break;
			
			case 5 : {
				isTrue = false;
			}
			
			}
		}
		
		System.out.println("the total bill is : " + total);
	}
}
