package com.tss.basic.selectionstatement;

public class MaxForThreeNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	private static void maxChecker(int number1 , int number2 , int number3) {
		if(number1 > number2) {
			if(number1 > number3) {
				System.out.println("number1 is greatest");
			}
			else {
				System.out.println("number3 is greatest");

			}
		}
		if(number2 > number3) {
			if(number2 > number1) {
				System.out.println("number2 is greatest");
			}
			else {
				System.out.println("number is greatest");

			}
		}
	}

}
