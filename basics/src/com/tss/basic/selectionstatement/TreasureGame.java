package com.tss.basic.selectionstatement;

import java.util.Scanner;

public class TreasureGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter left or right : ");
		
		String direction = sc.next();
		
		if(direction.equalsIgnoreCase("left")) {
			System.out.println("you want to swim or wait");
			String action = sc.next();
			if(action.equalsIgnoreCase("wait")) {
				System.out.println("Choose Red , yellow or Blue!!");
				String doorColor = sc.next();
				if(doorColor.equalsIgnoreCase("red")) {
					System.out.println("You are burned by fire , game over !!");
				}
				else if(doorColor.equalsIgnoreCase("yellow")) {
					System.out.println("You won the game , Congratulations !!");
				}
				else if(doorColor.equalsIgnoreCase("Blue")) {
					System.out.println("Eaten by beast, Dinner time !!");
				}
				else {
					System.out.println("Game Over !!");
				}
			}
			else {
				System.out.println("You are attacked by trout , better luck next time!!");
			}
		}
		else {
			System.out.println("OOps you fall into the hall !!");
		}
	}
}
