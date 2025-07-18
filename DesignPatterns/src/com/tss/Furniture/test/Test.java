package com.tss.Furniture.test;

import java.util.Scanner;

import com.tss.Furniture.model.ChairFactory;
import com.tss.Furniture.model.FurnitureStyle;
import com.tss.Furniture.model.IFurnitureFactory;
import com.tss.Furniture.model.IStyle;
import com.tss.Furniture.model.SofaFactory;
import com.tss.Furniture.model.TableFactory;
import com.tss.Furniture.*;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter the style : 1.Modern 2.Victorian");
		
		int choice = sc.nextInt();
		
		IStyle f = null;
		IFurnitureFactory Factory ;
		
		if(choice == 1) {
			System.out.println("enter the style : 1.table 2.chair 3.sofa");
			int furniture = sc.nextInt();
			
			if(furniture == 1) {
				Factory  = new TableFactory();
				f = Factory.furniture(FurnitureStyle.Modern);
				f.style();
			}
			else if(furniture == 2) {
				Factory = new ChairFactory();
				f = Factory.furniture(FurnitureStyle.Modern);
				f.style();
			}
			else if(furniture == 3) {
				Factory = new SofaFactory();
				f = Factory.furniture(FurnitureStyle.Modern);
				f.style();
			}
			else {
				System.out.println("invalid choice !!");
			}
		}
		else if(choice == 2) {
			System.out.println("enter the style : 1.table 2.chair 3.sofa");
			int furniture = sc.nextInt();
			
			if(furniture == 1) {
				Factory = new TableFactory();
				f = Factory.furniture(FurnitureStyle.Victorian);
				f.style();
			}
			else if(furniture == 2) {
				Factory = new ChairFactory();
				f = Factory.furniture(FurnitureStyle.Victorian);
				f.style();
			}
			else if(furniture == 3) {
				Factory = new SofaFactory();
				f = Factory.furniture(FurnitureStyle.Victorian);
				f.style();
			}
			else {
				System.out.println("invalid choice !!");
			}
		}
		else {
			System.out.println("invalid choice !!");
		}
	}
}
