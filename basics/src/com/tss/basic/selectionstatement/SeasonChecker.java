package com.tss.basic.selectionstatement;

import java.util.Scanner;

public class SeasonChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("enter the month name in small letters : ");
		Scanner scanner = new Scanner(System.in);
		
		String seasonName = scanner.next();
		String toLowerCase = seasonName.toLowerCase();
		
		switch(toLowerCase) {
		case "january" : System.out.println("Winter");
							break;
		case "february" : System.out.println("Winter");
							break;
		case "march" : System.out.println("Winter");
							break;
		case "april" : System.out.println("Winter");
							break;
		case "may" : System.out.println("summer");
							break;
		case "june" : System.out.println("summer");
							break;
		case "july" : System.out.println("summer");
							break;
		case "august" : System.out.println("summer");
							break;
		case "september" : System.out.println("monsoon");
							break;
		case "october" : System.out.println("monsoon");
							break;
		case "november" : System.out.println("monsoon");
							break;
		case "december" : System.out.println("monsoon");
							break;
		default : System.out.println("Enter a valid month !!");
		}
	}

}
