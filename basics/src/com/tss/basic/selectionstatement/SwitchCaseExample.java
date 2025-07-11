package com.tss.basic.selectionstatement;

import java.util.Random;

public class SwitchCaseExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		
		int number = random.nextInt(6);
		
		System.out.println(number);
		
		switch(number) {
		case 1 : System.out.println("ONE");
				break;
		case 2 : System.out.println("TWO");
				break;
		case 3 : System.out.println("THREE");
				break;
		case 4 : System.out.println("FOUR");
				break;
		case 5 : System.out.println("FIVE");
				break;
				
		default : System.out.println("Number out of bounds !!");
		}
	}

}
